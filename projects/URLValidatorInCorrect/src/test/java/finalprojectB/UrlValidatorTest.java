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
       assertFalse(urlVal.isValid("http:/amazon.com"));//too few slashes

       assertTrue(urlVal.isValid("http2://www.amazon.com"));
       assertFalse(urlVal2.isValid("http2://www.amazon.com"));//invaild scheme with set schemes enabled

       assertTrue(urlVal2.isValid("file://"));//vaild file
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
       assertTrue(urlVal.isValid("https://www.google.com"));
       assertTrue(urlVal.isValid("https://sourceforge.net"));
       assertTrue(urlVal.isValid("https://en.wikipedia.org"));
       assertTrue(urlVal.isValid("http://oregonstate.edu/"));
       assertTrue(urlVal.isValid("https://mail.google.com/mail/u/0/#inbox"));
       //assertTrue(urlVal.isValid("https://www.gov.uk/government/how-government-works")); //POTENTIAL FAULT
       //assertTrue(urlVal.isValid("https://www.google.com/search?q=how")); //POTENTIAL FAULT
       //assertTrue(urlVal.isValid("https://www.google.com/search?q=maximum+value+for+an+ip+block&ie=utf-8&oe=utf-8#q=OSU+location")); //POTENTIAL FAULT


       //testing invaild domains
       assertFalse(urlVal.isValid("https://something.nope"));
       assertFalse(urlVal.isValid("https://something.not/this/one/#either"));
       assertFalse(urlVal.isValid("https://something.or/this_one.jpg"));
       //assertFalse(urlVal.isValid("abc://amazon.com")); //POTENTIAL FAULT

   }
   
   
   public void testIsValid()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       String head1 = "http://";
       String head2 = "https://";
       String head3 = "";

       String body1 = "abc";
       String body2 = "0.0.0.0";
       String body3 = "";

       String dot1 = ".com";
       String dot2 = ".net";
       String dot3 = ".gov";

       String tail1 = "/10/";
       String tail2 = "/search?=abc/";
       String tail3 = "/#abc/";

       long randomseed =10;
       Random random = new Random(randomseed);

	for(int i = 0;i<10000;i++)
	   {
           String conc = "";

           int l = random.nextInt(2);
           if(l == 0){
               conc += head1;
           }else if(l == 1){
               conc += head2;
           }else if(l == 2){
               conc += head3;
           }

           int m = random.nextInt(2);
           if(m == 0){
               conc += body1;
           }else if(m == 1){
               conc += body2;
           }else if(m == 2){
               conc += body3;
           }

           int n = random.nextInt(2);
           if(n == 0){
               conc += dot1;
           }else if(n == 1){
               conc += dot2;
           }else if(n == 2){
               conc += dot3;
           }

           int o = random.nextInt(2);
           if(o == 0){
               conc += tail1;
           }else if(o == 1){
               conc += tail2;
           }else if(o == 2){
               conc += tail3;
           }

           urlVal.isValid(conc);
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
