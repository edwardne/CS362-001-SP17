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

       assertEquals(true, urlVal.isValid("http://www.amazon.com"));
       assertEquals(false, urlVal.isValid(null));
       assertEquals(false, urlVal.isValid(""));
       assertEquals(false, urlVal.isValid("hi"));
       assertEquals(false, urlVal.isValid("http:///"));
       assertEquals(false, urlVal.isValid("http://www.amazon.com//"));

       assertEquals(false, urlVal2.isValid("http2://www.amazon.com"));//bad scheme
       assertEquals(true, urlVal2.isValid("file://"));//good file
       assertEquals(false, urlVal2.isValid("file://.com"));//bad file
       assertEquals(false, urlVal3.isValid("http://www.amazon.com/foo.html#bar"));//fragment

       assertFalse(urlVal.isValid("http://www.amazon.com/?") );
	   
	//ADDITIONAL TESTING BASED ON WHAT "SHOULD" BE RIGHT
       //IP testing
       assertTrue(urlVal.isValid("http://1.1.1.1"));
       assertFalse(urlVal.isValid("http://1.1.1.1.1"));
       assertFalse(urlVal.isValid("http://-1.1.1.1"));
       assertTrue(urlVal.isValid("http://255.255.255.255"));
       assertFalse(urlVal.isValid("http://300000.3000000.3000000.30000000"));
       assertTrue(urlVal.isValid("http://0.0.0.0/8"));
       //assertFalse(urlVal.isValid("http://259.259.259.259")); //POTENTIAL FAULT
       //assertFalse(urlVal.isValid("http://0.0.0.0/100000000")); //POTENTIAL FAULT
       assertTrue(urlVal.isValid("https://0.0.0.0"));
       assertFalse(urlVal.isValid("http://1.1.a.1"));

       //DOMAIN testing
       assertTrue(urlVal.isValid("https://nsa.gov"));
       //assertTrue(urlVal.isValid("https://www.gov.uk/government/how-government-works")); //POTENTIAL FAULT
       //assertTrue(urlVal.isValid("https://www.google.com/search?q=how")); //POTENTIAL FAULT
       //assertTrue(urlVal.isValid("https://www.google.com/search?q=maximum+value+for+an+ip+block&ie=utf-8&oe=utf-8#q=OSU+location")); //POTENTIAL FAULT
	   
   }
   
   public void testYourFirstPartition()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //IP testing
       //testing valid port numbers
       assertTrue(urlVal.isValid("http://1.1.1.1"));
       assertTrue(urlVal.isValid("http://255.255.255.255"));
       assertTrue(urlVal.isValid("http://0.0.0.0/8"));
       assertTrue(urlVal.isValid("https://0.0.0.0"));

       //testing invalid port numbers
       assertFalse(urlVal.isValid("http://1.1.1.1.1"));
       assertFalse(urlVal.isValid("http://-1.1.1.1"));
       assertFalse(urlVal.isValid("http://300000.3000000.3000000.30000000"));
       assertFalse(urlVal.isValid("http://1.1.a.1"));
       //assertFalse(urlVal.isValid("http://259.259.259.259")); //POTENTIAL FAULT
       //assertFalse(urlVal.isValid("http://0.0.0.0/100000000")); //POTENTIAL FAULT
       //assertFalse(urlVal.isValid("https://0.0.0.0/-1")); //POTENTIAL FAULT
   }
   
   public void testYourSecondPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       //DOMAIN testing
       //testing valid domains
       assertTrue(urlVal.isValid("https://nsa.gov"));
       //assertTrue(urlVal.isValid("https://www.gov.uk/government/how-government-works")); //POTENTIAL FAULT
       assertTrue(urlVal.isValid("https://www.google.com"));
       assertTrue(urlVal.isValid("https://sourceforge.net"));
       assertTrue(urlVal.isValid("https://en.wikipedia.org"));
       assertTrue(urlVal.isValid("https://mail.google.com/mail/u/0/#inbox"));

       //testing invaild domains
       assertFalse(urlVal.isValid("https://something.nope"));
       assertTrue(urlVal.isValid("https://something.nope.org"));
       //assertFalse(urlVal.isValid("abc://amazon.com")); //POTENTIAL FAULT
       assertFalse(urlVal.isValid("http:/amazon.com"));

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
