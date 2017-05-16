package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable table = new TimeTable();
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 int thisMonth = rightnow.get(Calendar.MONTH)+1;
		 int thisYear = rightnow.get(Calendar.YEAR);
		 int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
		 CalDay cal = new CalDay((GregorianCalendar)rightnow);
		 int startHour=13;
		 int startMinute=30;
		 int startDay=thisDay;
		 int startMonth=thisMonth;
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
		 cal.addAppt(appt);

		 startHour = 2;
		 Appt appt2 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startHour = 17;
		 startDay += 1;
		 Appt appt3 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 startDay += 1;
		 startHour = -1;
		 Appt appt4 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<Appt> emptyAppts = new LinkedList<Appt>();
		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt4);
		 emptyAppts.add(appt4);

		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 assertFalse(table.getApptRange(listAppts,today,tomorrow)==null);
		 assertFalse(table.getApptRange(emptyAppts,today,tomorrow)==null);
		 //table.getApptOccurences(appt,tomorrow,today);
		 GregorianCalendar delete= (GregorianCalendar)today.clone();
		 assertFalse(table.deleteAppt(listAppts, appt)==null);
		 appt.setStartDay(1);
		 Appt appt5 = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 assertEquals(null, table.deleteAppt(listAppts, appt));
		 assertEquals(null, table.deleteAppt(listAppts, appt5));
		 assertEquals(null, table.deleteAppt(null, appt4));
		 Appt apptn = null;
		 assertEquals(null, table.deleteAppt(listAppts, apptn));

		 GregorianCalendar lastday = (GregorianCalendar)today.clone();
		 lastday.add(Calendar.DAY_OF_MONTH,3);

		 table.getApptRange(listAppts,today,lastday);
	 }

}
