package org.jetbrains.jps.incremental.scala.sbt;

import org.jetbrains.jps.model.JpsDummyElement;
import org.jetbrains.jps.model.ex.JpsElementTypeWithDummyProperties;
import org.jetbrains.jps.model.module.JpsModuleType;

/**
 * @author Pavel Fatin
 */
class SharedSourcesModuleType extends JpsElementTypeWithDummyProperties implements JpsModuleType<JpsDummyElement> {
  public static final SharedSourcesModuleType INSTANCE = new SharedSourcesModuleType();
}
