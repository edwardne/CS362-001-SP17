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

       assertFalse(urlVal2.isValid("http2://www.amazon.com"));
       assertFalse(urlVal2.isValid("http2://www.amazon.com"));//invaild scheme with set schemes enabled

       assertTrue(urlVal2.isValid("file://"));//valid file
       assertFalse(urlVal2.isValid("file://.com"));//invalid file

       assertFalse(urlVal3.isValid("http://www.amazon.com/foo.html#bar"));//fragment with fragment disabled
       assertTrue(urlVal.isValid("http://www.amazon.com/foo.html#bar"));//fragment with fragment enabled

       assertFalse(urlVal.isValid("http://www.amazon.com/?"));

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

       //testing invalid port numbers
       assertFalse(urlVal.isValid("http://1.1.1.1.1"));
       assertFalse(urlVal.isValid("http://-1.1.1.1"));
       assertFalse(urlVal.isValid("http://300000.3000000.3000000.30000000"));
       assertFalse(urlVal.isValid("http://1.1.a.1"));
       //assertFalse(urlVal.isValid("http://256.256.256.256")); //POTENTIAL FAULT
       //assertFalse(urlVal.isValid("http://0.0.0.0/100000000")); //POTENTIAL FAULT
       //assertFalse(urlVal.isValid("https://0.0.0.0/-1")); //POTENTIAL FAULT
   }
   
   public void testYourSecondPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //DOMAIN testing
       //testing valid domains
       assertTrue(urlVal.isValid("https://nsa.gov"));
       assertTrue(urlVal.isValid("https://www.google.com"));
       assertTrue(urlVal.isValid("https://sourceforge.net"));
       assertTrue(urlVal.isValid("https://en.wikipedia.org"));
       assertTrue(urlVal.isValid("http://oregonstate.edu/"));
       assertTrue(urlVal.isValid("https://mail.google.com/mail/u/0/#inbox"));
       //assertTrue(urlVal.isValid("https://www.gov.uk/government/how-government-works")); //POTENTIAL FAULT
       //assertTrue(urlVal.isValid("https://www.google.com/search?q=how")); //POTENTIAL FAULT


       //testing invaild domains
       assertFalse(urlVal.isValid("https://something.nope"));
       assertFalse(urlVal.isValid("https://something.nope/"));
       assertFalse(urlVal.isValid("https://something.not/this/one/#either"));
       assertFalse(urlVal.isValid("https://something.or/this_one.jpg"));
   }
   
   
   public void testIsValid()
   {
	   for(int i = 0;i<10000;i++)
	   {
		   
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
