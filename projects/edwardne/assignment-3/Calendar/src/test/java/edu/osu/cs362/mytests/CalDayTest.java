package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		CalDay bad = new CalDay();
		assertEquals(false, bad.valid);
		 assertEquals(null, bad.getAppts());
		 //get todays date
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		CalDay cal = new CalDay((GregorianCalendar)rightnow);
		assertEquals(rightnow.get(Calendar.DAY_OF_MONTH), cal.getDay());
		assertEquals(0, cal.getSizeAppts());
		assertEquals(rightnow.get(Calendar.MONTH), cal.getMonth());
		assertEquals(rightnow.get(Calendar.YEAR), cal.getYear());
		assertEquals(true, cal.isValid());

		cal.toString();
		assertEquals(new LinkedList(), cal.getAppts());

		cal.iterator();
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

		 startHour = 2;
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour = 17;
		 Appt appt3 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour = -1;
		 Appt appt4 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 startHour = 2;
		 Appt appt5 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 startHour = 15;
		 Appt appt6 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 cal.addAppt(appt);
		cal.addAppt(appt2);
		cal.addAppt(appt3);
		cal.addAppt(appt4);
		 cal.addAppt(appt5);
		 cal.addAppt(appt6);
		assertEquals(2 ,(cal.getAppts()).get(0).getStartHour());
		 assertEquals(2 ,(cal.getAppts()).get(1).getStartHour());
		 assertEquals(13 ,(cal.getAppts()).get(2).getStartHour());
		 assertEquals(15 ,(cal.getAppts()).get(3).getStartHour());
		 assertEquals(17 ,(cal.getAppts()).get(4).getStartHour());

		assertFalse((cal.iterator()==null));
		cal.toString();
		//cal.appts = null;
		cal.valid = false;
		cal.addAppt(appt);
		assertEquals(null, cal.iterator());
		assertEquals("", cal.toString());

		 cal.appts = null;
		 cal = new CalDay((GregorianCalendar)rightnow);
		 assertEquals(new LinkedList<Appt>(), cal.appts);
	 }
	
}
