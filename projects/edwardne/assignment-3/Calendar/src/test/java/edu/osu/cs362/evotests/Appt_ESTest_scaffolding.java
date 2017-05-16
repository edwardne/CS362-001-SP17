/**
 * Scaffolding file used to store all the setups needed to run 
 * tests automatically generated by EvoSuite
 * Tue May 16 00:54:11 GMT 2017
 */

package edu.osu.cs362;

import org.evosuite.runtime.annotation.EvoSuiteClassExclude;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.evosuite.runtime.sandbox.Sandbox;
import org.evosuite.runtime.sandbox.Sandbox.SandboxMode;

@EvoSuiteClassExclude
public class Appt_ESTest_scaffolding {

  private static final java.util.Properties defaultProperties = (java.util.Properties) java.lang.System.getProperties().clone(); 

  private org.evosuite.runtime.thread.ThreadStopper threadStopper =  new org.evosuite.runtime.thread.ThreadStopper (org.evosuite.runtime.thread.KillSwitchHandler.getInstance(), 3000);

  @BeforeClass 
  public static void initEvoSuiteFramework() { 
    org.evosuite.runtime.RuntimeSettings.className = "edu.osu.cs362.Appt"; 
    org.evosuite.runtime.GuiSupport.initialize(); 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
    org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
    org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
    org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.RECOMMENDED; 
    org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.init(); 
    initializeClasses();
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
  } 

  @AfterClass 
  public static void clearEvoSuiteFramework(){ 
    Sandbox.resetDefaultSecurityManager(); 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
  } 

  @Before 
  public void initTestCase(){ 
    threadStopper.storeCurrentThreads();
    threadStopper.startRecordingTime();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().initHandler(); 
    org.evosuite.runtime.sandbox.Sandbox.goingToExecuteSUTCode(); 
    setSystemProperties(); 
    org.evosuite.runtime.GuiSupport.setHeadless(); 
    org.evosuite.runtime.Runtime.getInstance().resetRuntime(); 
    org.evosuite.runtime.agent.InstrumentingAgent.activate(); 
  } 

  @After 
  public void doneWithTestCase(){ 
    threadStopper.killAndJoinClientThreads();
    org.evosuite.runtime.jvm.ShutdownHookHandler.getInstance().safeExecuteAddedHooks(); 
    org.evosuite.runtime.classhandling.JDKClassResetter.reset(); 
    resetClasses(); 
    org.evosuite.runtime.sandbox.Sandbox.doneWithExecutingSUTCode(); 
    org.evosuite.runtime.agent.InstrumentingAgent.deactivate(); 
    org.evosuite.runtime.GuiSupport.restoreHeadlessMode(); 
  } 

  public void setSystemProperties() {
 
    java.lang.System.setProperties((java.util.Properties) defaultProperties.clone()); 
    java.lang.System.setProperty("java.vm.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.specification.version", "1.8"); 
            java.lang.System.setProperty("java.home", "C:\\Program Files (x86)\\Java\\jdk1.8.0_25\\jre"); 
    java.lang.System.setProperty("user.home", "C:\\Users\\Noda Dragon"); 
            java.lang.System.setProperty("java.awt.headless", "true"); 
                                java.lang.System.setProperty("user.dir", "C:\\Users\\Noda Dragon\\Desktop\\SE2\\CS362-001-SP17\\projects\\edwardne\\assignment-3\\Calendar"); 
    java.lang.System.setProperty("java.io.tmpdir", "C:\\Users\\NODADR~1\\AppData\\Local\\Temp\\"); 
    java.lang.System.setProperty("awt.toolkit", "sun.awt.windows.WToolkit"); 
    java.lang.System.setProperty("file.encoding", "Cp1252"); 
    java.lang.System.setProperty("file.separator", "\\"); 
        java.lang.System.setProperty("java.awt.graphicsenv", "sun.awt.Win32GraphicsEnvironment"); 
    java.lang.System.setProperty("java.awt.printerjob", "sun.awt.windows.WPrinterJob"); 
    java.lang.System.setProperty("java.class.path", "C:\\Users\\NODADR~1\\AppData\\Local\\Temp\\EvoSuite_pathingJar6909237277041573869.jar"); 
    java.lang.System.setProperty("java.class.version", "52.0"); 
        java.lang.System.setProperty("java.endorsed.dirs", "C:\\Program Files (x86)\\Java\\jdk1.8.0_25\\jre\\lib\\endorsed"); 
    java.lang.System.setProperty("java.ext.dirs", "C:\\Program Files (x86)\\Java\\jdk1.8.0_25\\jre\\lib\\ext;C:\\WINDOWS\\Sun\\Java\\lib\\ext"); 
    java.lang.System.setProperty("java.library.path", "lib"); 
    java.lang.System.setProperty("java.runtime.name", "Java(TM) SE Runtime Environment"); 
    java.lang.System.setProperty("java.runtime.version", "1.8.0_25-b18"); 
    java.lang.System.setProperty("java.specification.name", "Java Platform API Specification"); 
    java.lang.System.setProperty("java.specification.vendor", "Oracle Corporation"); 
        java.lang.System.setProperty("java.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vendor.url", "http://java.oracle.com/"); 
    java.lang.System.setProperty("java.version", "1.8.0_25"); 
    java.lang.System.setProperty("java.vm.info", "mixed mode, sharing"); 
    java.lang.System.setProperty("java.vm.name", "Java HotSpot(TM) Client VM"); 
    java.lang.System.setProperty("java.vm.specification.name", "Java Virtual Machine Specification"); 
    java.lang.System.setProperty("java.vm.specification.vendor", "Oracle Corporation"); 
    java.lang.System.setProperty("java.vm.specification.version", "1.8"); 
    java.lang.System.setProperty("java.vm.version", "25.25-b02"); 
    java.lang.System.setProperty("line.separator", "\r\n"); 
    java.lang.System.setProperty("os.arch", "x86"); 
    java.lang.System.setProperty("os.name", "Windows 8.1"); 
    java.lang.System.setProperty("os.version", "6.3"); 
    java.lang.System.setProperty("path.separator", ";"); 
    java.lang.System.setProperty("user.country", "US"); 
    java.lang.System.setProperty("user.language", "en"); 
    java.lang.System.setProperty("user.name", "Noda Dragon"); 
    java.lang.System.setProperty("user.timezone", "America/Los_Angeles"); 
          }

  private static void initializeClasses() {
    org.evosuite.runtime.classhandling.ClassStateSupport.initializeClasses(Appt_ESTest_scaffolding.class.getClassLoader() ,
      "edu.osu.cs362.Appt"
    );
  } 

  private static void resetClasses() {
  }
}
