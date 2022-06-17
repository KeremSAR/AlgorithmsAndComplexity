# Hash Table
* The purpose of this project is the find out how a chaining hash table uses with the 
hash function and compute an index to find desired value with small computation. Also, how 
to read a “.txt” file, show word frequency of the given text and display output to “.txt” files in 
the ordered and normal way. Java JDK 8 programming language is used with Apache NetBeans 
IDE 12.5 environment to build the algorithms of this assignment. All algorithms will be 
explained in the following content
* GetHash() method generates hash index (an integer value) related to input word. In this 
method, Horner’s Method [1] is used to generate a finely disturbed hash table. This method 
sums the ASCII values of every character of strings with the given offset to generate better 
randomness. In the project, 31 base value is used, the reason is this value is a prime and odd
number, which reduces the potential for many collisions. According to Josh Bloch’s Effective 
Java [2] “A nice property of 31 is that the multiplication can be replaced by a shift and 
subtraction for better performance: 31* i == (i <<5)-i. Modern VM’s do this sort of
optimization automatically.” For this project, 31 property is provided better distribution for the 
given text, among of 17,23,29,33,37, etc. To prevent collision and keep the indexes in a given
size, the modulo operation has been used for every character index summation. If the index 
goes negative the hash table size is added to the index.
* GetHashIndexList() method was created to generate the hash table. To prevent collision 
separate chaining method is also used. The given string is converted to upper case and English 
language. Upper case distribution showed better distribution than lower case because the ASCII 
values (A-Z, 65-90) (a-z, 97-122) are different for each character. Then, the same indexes for 
each value are added using the LinkedList technique to the table to prevent collision. Then, the 
same values extracted from the list and frequency of the word are calculated that way.
* ReadFileandGenerateHash() method every string in the text parsed. Then, every 
element is put into the hash table by calling GetHashIndexList() method.
* DisplayResult(String Outputfile) displays the hash table with their frequencies on a 
“.txt” file. A while loop is created to detect all values in the chain. If the chain of the last element 
is NULL breaks the loop and goes to the next position of the hash table.
* DisplayResultOrdered(String Outputfile) displays the hash table in a “.txt” file in an 
ordered fashion by their frequencies. The most repeated word is listed at the beginning and the 
least repeated words at the end. To sort values by their frequencies, all the elements in the chains are extracted to an array then the selection sorting algorithm is used to sort the elements by their
frequencies. To show showMaxRepeatedWord() first element of sorted array printed.
* showFrequency(String myword) shows the given word of frequency from the hash 
table. If the word is not in the table frequency returns -1. The method checks the given word is 
found in the hash table. A while loop is created that checks every element are whether equal to
the given word. If it is equal prints its frequency and returns -1.
* checkWord(String myword)) checks the given word is found in the hash table. A while 
loop is created that checks every element are whether equal to the given word. If it is equal 
prints its position and frequency and returns 0 because no need to check other elements
* NumberOfCollusion() calculates the collision number of the hash table. A while loop 
is created to check every element whether is NULL If it is not null check the next element 
whether is NULL. If it is, increase the variable by one. These go by like every chain of the hash 
table
* TestEfficiency() calculates the efficiency of the hash table. Stored elements are divided 
by the hash table size to calculate the load factor and multiplied by 100 to give the presentence
of the load factor
* In this project, for 500 table size, fills 222 elements out of 291 elements and the collision 
is 69, the efficiency is %44.4. For 1000 table size, fills 262 elements out of 291 elements and
the collision is 29, the efficiency is %26.199999. For 10000 table size fills 287 elements out of
291 elements and the collision is 4, the efficiency is %2.87. In summary, for large size hashes,
Horner’s Method [3] can be used to distribute the indexes finely manner but smaller sizes 
adding values without any multiplying prime number and using lower cases can provide better 
distribution. So, you should shape your GetHash() method according to what kind of input you 
have.
# REFERENCES
- SEDGEWICK, ROBERT, and KEVIN WAYNE. "3.4 HASH TABLES." (2016) 11-19. 
pages.
-  Bloch, Joshua. Effective java. Addison-Wesley Professional, 2008. “Chapter 3, Item 9: 
Always override hashcode when you override equals”, page 48
- http://mathcenter.oxford.emory.edu/site/cs171/generatingHashCodes/ “Generating Hash 
Codes"

