/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;
import java.util.Random;




/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
       String[] schemes = {"http","https","file"};
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       UrlValidator urlVal2 = new UrlValidator(schemes, null, UrlValidator.ALLOW_2_SLASHES);
       UrlValidator urlVal3 = new UrlValidator(null, null, UrlValidator.NO_FRAGMENTS);

       assertTrue(urlVal.isValid("http://www.amazon.com"));

       assertFalse(urlVal.isValid(null));
       assertFalse(urlVal.isValid(""));
       assertFalse(urlVal.isValid("hi"));

       assertFalse(urlVal.isValid("http:///"));//too many slashes
       assertFalse(urlVal.isValid("http://www.amazon.com//"));//too many slashes
       assertTrue(urlVal2.isValid("http://www.amazon.com//"));//two slashes enabled
       assertFalse(urlVal.isValid("http:/amazon.com"));//too few slashes

       assertTrue(urlVal.isValid("http2://www.amazon.com"));
       assertFalse(urlVal.isValid("2http://www.amazon.com"));

       assertFalse(urlVal2.isValid("http2://www.amazon.com"));
       assertFalse(urlVal2.isValid("http2://www.amazon.com"));//invaild scheme with set schemes enabled

       assertTrue(urlVal2.isValid("file://"));//valid file
       assertFalse(urlVal2.isValid("file://.com"));//invalid file

       assertFalse(urlVal3.isValid("http://www.amazon.com/foo.html#bar"));//fragment with fragment disabled
       assertTrue(urlVal.isValid("http://www.amazon.com/foo.html#bar"));//fragment with fragment enabled

   }
   
   public void testYourFirstPartition()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //IP testing
       //testing valid port numbers
       assertTrue(urlVal.isValid("http://12.123.45.67"));
       assertTrue(urlVal.isValid("http://255.255.255.255"));
       assertTrue(urlVal.isValid("http://0.0.0.0/8"));
       assertTrue(urlVal.isValid("https://0.0.0.0"));
       assertTrue(urlVal.isValid("http://1.1.1.1:8"));

       //testing invalid port numbers
       assertFalse(urlVal.isValid("http://1.1.1.1.1"));
       assertFalse(urlVal.isValid("http://-1.1.1.1"));
       assertFalse(urlVal.isValid("http://300000.3000000.3000000.30000000"));
       assertFalse(urlVal.isValid("http://1.1.a.1"));
       //assertFalse(urlVal.isValid("http://256.256.256.256")); //Bug #2
       //assertFalse(urlVal.isValid("http://0.0.0.0/100000000")); //POTENTIAL FAULT
       //assertFalse(urlVal.isValid("https://0.0.0.0/-1")); //POTENTIAL FAULT
   }
   
   public void testYourSecondPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //DOMAIN testing
       //testing valid domains
       assertTrue(urlVal.isValid("https://nsa.gov"));
       assertTrue(urlVal.isValid("https://www.google.com"));
       assertTrue(urlVal.isValid("https://www.google.com"));
       assertTrue(urlVal.isValid("https://sourceforge.net"));
       assertTrue(urlVal.isValid("https://en.wikipedia.org"));
       assertTrue(urlVal.isValid("http://oregonstate.edu/"));
       assertTrue(urlVal.isValid("https://mail.google.com/mail/u/0/#inbox"));
       //assertTrue(urlVal.isValid("https://www.gov.uk/government/how-government-works"));//Bug #1

       assertTrue(urlVal.isValid("http://www.amazon.com/?action=view")); //Bug #3
       assertFalse(urlVal.isValid("http://www.amazon.com?action=view"));

       //testing invaild domains
       assertFalse(urlVal.isValid("https://something.nope"));
       assertFalse(urlVal.isValid("https://something.nope/"));
       assertFalse(urlVal.isValid("https://something.not/this/one/#either"));
       assertFalse(urlVal.isValid("https://something.or/this_one.jpg"));
   }
   
   
   public void testIsValid()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       UrlValidator urlVal2 = new UrlValidator(null, null, UrlValidator.NO_FRAGMENTS+UrlValidator.ALLOW_2_SLASHES+UrlValidator.ALLOW_ALL_SCHEMES);

       ResultPair[] scheme = {new ResultPair("http://", true),
               new ResultPair("ftp://", true),
               new ResultPair("http2://", true),
               new ResultPair("3http://", false),
               new ResultPair("http:/", false),
               new ResultPair("http:", false),
               new ResultPair("http/", false),
               new ResultPair("://", false),
               new ResultPair("", false)};

       ResultPair[] authority = {new ResultPair("www.google.com", true),
               new ResultPair("go.com", true),
               new ResultPair("go.au", true),
               new ResultPair("255.com", true),
               new ResultPair("go.a", false),
               new ResultPair("go.a1a", false),
               new ResultPair("go.cc", true),
               new ResultPair("go.1aa", false),
               new ResultPair("aaa.", false),
               new ResultPair(".aaa", false),
               new ResultPair("aaa", false),
               new ResultPair("", false)
       };


       ResultPair[] port = {new ResultPair("1.2.3.4.5", false),
               new ResultPair("1.2.3.4.", false),
               new ResultPair("1.2.3", false),
               new ResultPair(".1.2.3.4", false),
               new ResultPair("0.0.0.0", true),
               new ResultPair("255.255.255.255", true),
               //new ResultPair("256.256.256.256", false)//Bug #2 again
       };
       ResultPair[] portEnd = {new ResultPair(":80", true),
               //new ResultPair(":65535", true),
               new ResultPair(":0", true),
               new ResultPair("", true),
               new ResultPair(":-1", false),
               //new ResultPair(":65636", true),
               new ResultPair(":65a", false)
       };
       ResultPair[] path = {new ResultPair("/test1", true),
               new ResultPair("/t123", true),
               new ResultPair("/$23", true),
               new ResultPair("/..", false),
               new ResultPair("/../", false),
               new ResultPair("/test1/", true),
               new ResultPair("", true),
               new ResultPair("/test1/file", true),
               new ResultPair("/..//file", false),
               new ResultPair("/test1//file", false)
       };
       //Test allow2slash, noFragment
       ResultPair[] pathOptions = {new ResultPair("/test1", true),
               new ResultPair("/t123", true),
               new ResultPair("/$23", true),
               new ResultPair("/..", false),
               new ResultPair("/../", false),
               new ResultPair("/test1/", true),
               new ResultPair("/#", false),
               new ResultPair("", true),
               new ResultPair("/test1/file", true),
               new ResultPair("/t123/file", true),
               new ResultPair("/$23/file", true),
               new ResultPair("/../file", false),
               new ResultPair("/..//file", false),
               new ResultPair("/test1//file", true),
               new ResultPair("/#/file", false)
       };

       ResultPair[] query = {//new ResultPair("?action=view", true),//Bug #3 again
               //new ResultPair("?action=edit&mode=up", true),//Bug #3 again
               new ResultPair("", true)
       };

       Random random = new Random(System.currentTimeMillis());

	for(int i = 0;i<10000;i++)
	   {
           boolean allValid = true;

	       String conc = "";

           int randScheme = random.nextInt(scheme.length);
           int randAuth = random.nextInt(authority.length);
           int randPath= random.nextInt(path.length);
           int randQuery= random.nextInt(query.length);

           for(int j=0; j < scheme.length; j++)
           {
               if(j==randScheme)
               {
                   conc +=scheme[j].item;
                   if(scheme[j].valid== false)
                   {
                       allValid = false;
                       System.out.println("INVAILD HERE " + scheme[j].item);
                   }
               }
           }
           int randPortOption= random.nextInt(2);//choose whether or not to use port number
           if(randPortOption == 0) {
               for (int j = 0; j < authority.length; j++) {
                   if (j == randAuth) {
                       conc += authority[j].item;
                       if (authority[j].valid == false) {
                           allValid = false;
                           System.out.println("INVAILD HERE " + authority[j].item);
                       }
                   }
               }

           }
           else {
               int randPort = random.nextInt(port.length);
               int randEnd = random.nextInt(portEnd.length);
               for (int j = 0; j < port.length; j++) {
                   if (j == randPort) {
                       conc += port[j].item;
                       if (port[j].valid == false) {
                           allValid = false;
                           System.out.println("INVAILD HERE " + port[j].item);
                       }
                   }
               }
               for (int j = 0; j < portEnd.length; j++) {
                   if (j == randEnd) {
                       conc += portEnd[j].item;
                       if (portEnd[j].valid == false) {
                           allValid = false;
                           System.out.println("INVAILD HERE " + portEnd[j].item);
                       }
                   }
               }
           }
           int randOption= random.nextInt(2);//choose wheter or not to test with two slash and fragments enabled
           if(randOption==0)
           {
               for (int j = 0; j < path.length; j++) {
                   if (j == randPath) {
                       conc += path[j].item;
                       if (path[j].valid == false) {
                           allValid = false;
                           System.out.println("INVAILD HERE " + path[j].item);
                       }
                   }
               }
           }

           else
           {
               int randOptions = random.nextInt(pathOptions.length);

               for (int j = 0; j < pathOptions.length; j++) {
                   if (j == randOptions) {
                       conc += pathOptions[j].item;
                       if (pathOptions[j].valid == false) {
                           allValid = false;
                           System.out.println("INVAILD HERE " + pathOptions[j].item);
                       }
                   }
               }
           }
           for(int j=0; j < query.length; j++)
           {
               if(j==randQuery)
               {
                   conc +=query[j].item;
                   if(query[j].valid== false)
                   {
                       allValid = false;
                       System.out.println("INVAILD HERE " + query[j].item);
                   }
               }
           }
           System.out.println(conc);
           if(randOption==1)
           {
               System.out.println("TWO SLASH AND NO FRAGMENTS ALLOWED");
               assertEquals(allValid, urlVal2.isValid(conc));
           }
           else
           {
               assertEquals(allValid, urlVal.isValid(conc));
           }
	   }
   }
   
   public void testAnyOtherUnitTest()
   {
	   
   }
   /**
    * Create set of tests by taking the testUrlXXX arrays and
    * running through all possible permutations of their combinations.
    *
    * @param testObjects Used to create a url.
    */
   

}
