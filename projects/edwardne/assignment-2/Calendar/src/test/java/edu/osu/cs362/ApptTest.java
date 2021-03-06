package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
	 @Test
	 public void test02()    throws Throwable{
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
	 	appt.setStartHour(24);
	 	assertEquals(false, appt.getValid());
	 	assertEquals(null, appt.toString());
	 	appt.setStartHour(-1);
	 	assertEquals(false, appt.getValid());
	 	appt.setStartHour(12);
	 	assertEquals(true, appt.getValid());

	 	appt.setStartMinute(60);
	 	assertEquals(false, appt.getValid());
	 	appt.setStartMinute(-1);
	 	assertEquals(false, appt.getValid());
	 	appt.setStartMinute(45);
	 	assertEquals(true, appt.getValid());

		 appt.setStartDay(32);
		 assertEquals(false, appt.getValid());
		 appt.setStartDay(0);
		 assertEquals(false, appt.getValid());
		 appt.setStartDay(7);
		 assertEquals(true, appt.getValid());

	 	appt.setStartMonth(13);
	 	assertEquals(false, appt.getValid());
	 	appt.setStartMonth(0);
	 	assertEquals(false, appt.getValid());
	 	appt.setStartMonth(11);
	 	assertEquals(true, appt.getValid());

		 appt.setStartYear(2017);
		 assertEquals(true, appt.getValid());

		 appt.setDescription(null);
		 assertEquals("", appt.getDescription());

		 appt.setTitle(null);
		 assertEquals("", appt.getDescription());

		 appt.toString();
		 appt.setStartHour(0);
		 appt.toString();
		 appt.setStartHour(4);
		 appt.toString();
	 }


	
}
