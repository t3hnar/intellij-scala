package org.jetbrains.plugins.scala.lang.refactoring.move

import com.intellij.refactoring.move.moveClassesOrPackages.MoveClassHandler
import com.intellij.psi._
import org.jetbrains.plugins.scala.lang.psi.api.ScalaFile

/**
 * Pavel.Fatin, 12.05.2010
 */

class ScalaMoveClassHandler extends MoveClassHandler {
  def doMoveClass(aClass: PsiClass, moveDestination: PsiDirectory): PsiClass = {
    aClass.getContainingFile match {
      case file: ScalaFile => {
        val newPackage: PsiPackage = JavaDirectoryService.getInstance.getPackage(moveDestination)

        if (file.getClasses.size == 1) {
          if (moveDestination != file.getContainingDirectory)
            moveSingular(aClass, file, moveDestination, newPackage)
          else
            null
        } else {
          movePlural(aClass, file, moveDestination, newPackage)
        }
      }
      case _ => null
    }
  }

  // Only one template definition in the file, so move the entire file.
  private def moveSingular(aClass: PsiClass, file: ScalaFile,
                           newDirectory: PsiDirectory, newPackage: PsiPackage): PsiClass = {

    aClass.getManager.moveFile(file, newDirectory)

    if (newPackage != null) {
      file.setPackageName(newPackage.getQualifiedName)
    }

    // important to return the class from the new file, it will have new qualifier.
    file.getClasses().head
  } 

  // To move one class from a file with >1 template definitions, copy the file.
  // In the original file, delete this class. In the copy, delete everything else.
  private def movePlural(aClass: PsiClass, file: ScalaFile,
                         newDirectory: PsiDirectory, newPackage: PsiPackage): PsiClass = {
    val newFile = newDirectory.copyFileFrom(getName(aClass), file).asInstanceOf[ScalaFile]

    if (newPackage != null) {
      newFile.setPackageName(newPackage.getQualifiedName)
    }

    //todo: Handle comments correctly in both the original and the new file.
    val classes = newFile.asInstanceOf[ScalaFile].getClasses
    val newClass = classes.head.replace(aClass).asInstanceOf[PsiClass]
    aClass.delete
    classes.tail.foreach(_.delete)

    newClass
  }

  def getName(clazz: PsiClass) = {
    clazz.getContainingFile match {
      case file: ScalaFile => if (file.getClasses.size > 1) clazz.getName + ".scala" else file.getName
      case _ => null
    }
  }
}