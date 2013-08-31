package org.jetbrains.plugins.scala.lang.typeInference.generated

import org.jetbrains.plugins.scala.lang.typeInference.TypeInferenceTestBase

/**
 * @author Alefas
 * @since 05.09.12
 */
class TypeInferenceScalaReflectTest extends TypeInferenceTestBase {
  //This class was generated by build script, please don't change this
  override def folderPath: String = super.folderPath + "scalaReflect/"

  protected override def isIncludeReflectLibrary: Boolean = true

  def testSCL4662() {doTest()}

  def testSCL5592() {doTest()}

  def testSCL5790() {doTest()}

  def testSCL5871() = doTest()
}