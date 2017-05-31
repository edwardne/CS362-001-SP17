/*
 * This file was automatically generated by EvoSuite
 * Tue May 16 00:54:07 GMT 2017
 */

package edu.osu.cs362;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import edu.osu.cs362.Appt;
import edu.osu.cs362.CalDay;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true)
public class CalDay_ESTest extends CalDay_ESTest_scaffolding {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      boolean boolean0 = calDay0.isValid();
      assertTrue(boolean0);
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.year = 23;
      int int0 = calDay0.getYear();
      assertEquals(23, int0);
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.year = 3012;
      calDay0.year = (-1414);
      int int0 = calDay0.getYear();
      assertEquals((-1414), int0);
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = 5;
      int int0 = calDay0.getMonth();
      assertEquals(5, int0);
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.month = 100;
      calDay0.month = (-805);
      int int0 = calDay0.getMonth();
      assertEquals((-805), int0);
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.day = Integer.MAX_VALUE;
      int int0 = calDay0.getDay();
      assertEquals(Integer.MAX_VALUE, int0);
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.day = (-2120);
      int int0 = calDay0.getDay();
      assertEquals((-2120), int0);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try { 
        calDay0.addAppt((Appt) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      boolean boolean0 = calDay0.isValid();
      assertFalse(boolean0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      // Undeclared exception!
      try { 
        calDay0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      calDay0.valid = true;
      // Undeclared exception!
      try { 
        calDay0.iterator();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      Iterator<?> iterator0 = calDay0.iterator();
      assertNull(iterator0);
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      // Undeclared exception!
      try { 
        calDay0.getSizeAppts();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test13()  throws Throwable  {
      CalDay calDay0 = null;
      try {
        calDay0 = new CalDay((GregorianCalendar) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         assertThrownBy("edu.osu.cs362.CalDay", e);
      }
  }

  @Test(timeout = 4000)
  public void test14()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getDay();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test15()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getYear();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test16()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      assertNull(linkedList0);
  }

  @Test(timeout = 4000)
  public void test17()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      int int0 = calDay0.getMonth();
      assertEquals(0, int0);
  }

  @Test(timeout = 4000)
  public void test18()  throws Throwable  {
      CalDay calDay0 = new CalDay();
      String string0 = calDay0.toString();
      assertEquals("", string0);
  }
}