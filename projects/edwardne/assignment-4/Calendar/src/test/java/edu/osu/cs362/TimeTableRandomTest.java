package edu.osu.cs362;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.LinkedList;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	/**
	 * Generate Random Tests that tests Appt Class.
	 */
	@Test
	public void randomtest()  throws Throwable  {

		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		System.out.println("Start testing...");


		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed =iteration;
			//			System.out.println(" Seed:"+randomseed );
			Random random = new Random(randomseed);
			TimeTable table = new TimeTable();

			int startHour=ValuesGenerator.getRandomIntBetween(random, -50, 100);
			int startMinute=ValuesGenerator.getRandomIntBetween(random, -50, 100);
			int startDay=ValuesGenerator.getRandomIntBetween(random, -50, 100);
			int startMonth=ValuesGenerator.getRandomIntBetween(random, -50, 100);
			int startYear=2017;
			String title="Birthday Party";
			String description= (String) ValuesGenerator.getString(random);
			//Construct a new Appointment object with the initial data
			Appt appt = new Appt(startHour,
					startMinute ,
					startDay ,
					startMonth ,
					startYear ,
					title,
					description);
			//randomly choose if listAppts or Appt are going to be null
			int randMode = ValuesGenerator.getRandomIntBetween(random, 1, 4);

			if(randMode==1)
			{
				LinkedList<Appt> listAppts = null;
				Appt apptn= null;
				table.deleteAppt(listAppts, apptn);
			}
			if(randMode==2)
			{
				LinkedList<Appt> listAppts = null;
				table.deleteAppt(listAppts, appt);
			}
			if(randMode==3)
			{
				LinkedList<Appt> listAppts = new LinkedList<Appt>();
				listAppts.add(appt);
				Appt apptn= null;
				table.deleteAppt(listAppts, apptn);
			}
			if(randMode==4)
			{
				LinkedList<Appt> listAppts = new LinkedList<Appt>();
				Appt appt2 = new Appt(startHour+1,
						startMinute ,
						startDay ,
						startMonth ,
						startYear ,
						title,
						description);
				listAppts.add(appt);
				listAppts.add(appt2);
				table.deleteAppt(listAppts, appt2);
			}


			for (int i = 0; i < NUM_TESTS; i++) {
				String methodName = ApptRandomTest.RandomSelectMethod(random);
				if (methodName.equals("setTitle")){
					String newTitle=(String) ValuesGenerator.getString(random);
					appt.setTitle(newTitle);
				}

			}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			if((iteration%10000)==0 && iteration!=0 )
				System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

		}


		System.out.println("Done testing...");
	}
}
