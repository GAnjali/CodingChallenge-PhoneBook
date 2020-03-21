# PhoneBook
Phone book is an application which is used to generate the list of possible matches with the dictionary words for provided phone numbers.\
**Conditions included:**
- Application reads the input phone numbers and dictionary(uses default dictionary) from PhoneBook/src/main/data directory.<br/>
  (Update dictionary.txt with your data if you want to have your own dictionary).<br/>
  Example:<br/>
  Phone number: 2255<br/>
  Dictionary matched word: CALL<br/>
- Application tries to replace every digit of phone number with characters in keypad and generates all possibilities, prints the word which are matched with dictionary words.<br/>
- All punctuations and white spaces are getting ignored in phone numbers
- If there is a word boundary '.' it will get replaced with '-'.<br/>
- If there is no match found for a phone number, it will tries to skip a digit and find sub matched words among them.<br/>
- Output will always be in capital letters.<br/>
  **For Example:**<br/>
   Phone Number: 73239246<br/>
   Sub matched word: READY2GO<br/>

**Requirements:**
1. Java
2. Maven
    
**Steps to run:** Use below commands <br/>
- Package the jar using maven<br/>
<pre><code> mvn clean package</code></pre>
- Run the program<br/>
<pre> <code> java -cp target/PhoneBook-1.0-SNAPSHOT.jar PhoneBook</code></pre>
- Run all tests<br/>
<pre> <code> mvn clean test</code></pre>