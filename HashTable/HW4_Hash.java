/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerem_sarı_hw4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author kerem
 */
public class HW4_Hash implements HW4_Interface {
    private HashList[] arrayHash;
    //private int arraySize;
   // private int size;
    int elementNum =0;
    private int collision=0;
   
    public HW4_Hash(int sizeOfHash){     // constructor for hash size
        
       // this.arraySize=sizeOfHash;
        arrayHash= new HashList[sizeOfHash];
    }
    @Override
    public Integer GetHash(String mystring){
        
        String key =mystring;
        int hash = 31;
        for (int i = 0; i < key.length(); i++) {
            hash =(hash*31+(int)key.charAt(i))% arrayHash.length;    
        }
        
        if (hash<0) {
            hash += arrayHash.length;
        }
     
       return hash;
    }

    @Override
    public void ReadFileandGenerateHash(String filename, int size) {
        try {
            Scanner s = new Scanner(new File(filename));
            
            while (s.hasNext()) {
                String word = s.nextLine().replace(".", "").replace(",", "").replace("?", "").replace("--", "").replace(":", "").replace(";", ""); //removes punctuation marks
                String[] tempArray = word.split(" ");           // it takes each data with splitting the empty spaces   
                for (int i = 0; i < tempArray.length; i++) {  
                     GetHashIndexList(tempArray[i]);       
                }               
                          
            }
        }  
        
        catch (FileNotFoundException ex) {
            System.out.println("Couldn't read the file");
        }
        
    }
    

    public int GetHashIndexList(String mystring) {
        String ConvertedMystring = mystring.toUpperCase(new Locale("en"));//toLowerCase(new Locale("en"));
        int key = GetHash(ConvertedMystring);
       
        if (!"".equals(ConvertedMystring.trim())){   // to prevent detecting space at the beggining
            HashList head = arrayHash[key];
             
            while(head != null){
                 if (head.value.equals(ConvertedMystring)) {    // same words in text will be not in the chain
                     head.frequency+=1;                 // calculating same values in the given text

                     return head.frequency;               
                 }
                 head = head.next;
                
             }

            head = arrayHash[key];
            elementNum++;               // calculates number of element in the hash table
            HashList node = new HashList(ConvertedMystring);
            node.next = head;
            arrayHash[key]=node;       // added to first place
            arrayHash[key].frequency=1;
            // System.out.println( key +  " " +arrayHash[key].value);
        
       } 
        return key;
    }

    @Override
    public void DisplayResult(String Outputfile) {  
        try {
            File file = new File(Outputfile);
            FileWriter fileWrite = new FileWriter(file);
            
            for (int i = 0; i < arrayHash.length; i++) {
            HashList node = arrayHash[i];  // created a node to visit chain without distorting it
            while (node!= null) {
                fileWrite.write("\n"+node.value+ "  " + node.frequency);
                node = node.next;
            }
            
        }
            fileWrite.close();
        } catch (IOException ex) {
            System.out.println("Couldn't Display the  Result");
        }
        
    }

    @Override
    public void DisplayResult() {
        for (int i = 0; i < arrayHash.length; i++) {
            HashList node = arrayHash[i];  // created a node to visit chain without distorting it
            while (node!= null) {
                System.out.println(node.value+ " " + node.frequency);
                node = node.next;
            }
        }
    }

    @Override
    public void DisplayResultOrdered(String Outputfile) {
      try {
            File file = new File(Outputfile);
            FileWriter fileWrite = new FileWriter(file);
            
            HashList[] node = new HashList[elementNum] ;
            int u=0;
            for (int i = 0; i < arrayHash.length; i++) {      // all linked list puts in a custom array
                
                HashList temparr = arrayHash[i];  // created a node to visit chain without distorting it

                while (temparr!= null) {

                    node[u] = temparr;
                    u++; 
                    temparr = temparr.next;           
                }
        }
            for (int i = 0; i < node.length; i++) {             // Selection sorting
           
                int pos =i;
                for (int j = i+1; j < node.length; j++) {
                    if (node[j] != null && node[pos] != null ) {
                        if (node[j].frequency > node[pos].frequency) {
                            pos =j;
                        }

                    }  
                }
                
                if (node[i] != null && node[pos] != null) {     //  Selection sorting
                    String temp = node[i].value;
                    node[i].value= node[pos].value;
                    node[pos].value= temp;

                    int tempfreq = node[i].frequency;
                    node[i].frequency = node[pos].frequency;
                    node[pos].frequency = tempfreq;
                }
            
        }
        
      fileWrite.write("Sorted Hash");
        for (int i = 0; i < node.length; i++) {             // sorted hash written to Output2.txt file
            HashList node1 = node[i];                    // created a node to visit chain without distorting it
            while (node1!= null) {
                fileWrite.write("\n"+node1.value+ " " + node1.frequency);
                break;
            }
        }
        fileWrite.close();
      }
      catch (IOException ex) {
            System.out.println("Couldn't Display the  Result");
        }
    }
    

    @Override
    public int showFrequency(String myword) {
        String givenWord = myword.toUpperCase(new Locale("en"));
        if (!"".equals(givenWord.trim())){   // to prevent detecting spaces at the beggining
        for (int i = 0; i < arrayHash.length; i++) {
            HashList node = arrayHash[i];  // created a node to visit chain without distorting it
            while (node != null) {            
            
                if (node.value.equals(givenWord)) {
                    
                    System.out.println("The frequency of {"+node.value +"} is "+ "{"+ node.frequency+"}");
                    return -1;
                }
                else{
                    node = node.next;
                }
        }
        }
        }
         System.out.println("{"+givenWord+ "} is not found in the text its frequecy is -1");
         return -1;
    }

    @Override
    public String showMaxRepeatedWord() {
         HashList[] node = new HashList[elementNum] ;
            int u=0;
            for (int i = 0; i < arrayHash.length; i++) {      // all linked list puts in a custom array
            HashList temparr = arrayHash[i];  // created a node to visit chain without distorting it  
            while (temparr!= null) {      
                node[u] = temparr;
                u++;
                temparr = temparr.next;           
            }
        }
            for (int i = 0; i < node.length; i++) {             // selection sort
           
                int pos =i;
                for (int j = i+1; j < node.length; j++) {
                    if (node[j] != null && node[pos] != null ) {
                        if (node[j].frequency > node[pos].frequency) {
                            pos =j;
                        }       
                    }     
                }
                if (node[i] != null && node[pos] != null) {     // selection sort
                    String temp = node[i].value;
                    node[i].value= node[pos].value;
                    node[pos].value= temp;

                    int tempfreq = node[i].frequency;
                    node[i].frequency = node[pos].frequency;
                    node[pos].frequency = tempfreq;
                }

        }
        System.out.println("Most repeated word is " + "{"+node[0].value+"}"+ "-->" +node[0].frequency );
     
        return node[0].value;
    }
    int position=0;
    @Override
    public int checkWord(String myword) {
        
        String givenWord = myword.toUpperCase(new Locale("en"));
        if (!"".equals(givenWord.trim())){
        for (int i = 0; i < arrayHash.length; i++) {
            HashList node = arrayHash[i];  // created a node to visit chain without distorting it
            while (node != null) {            
            
                if (node.value.equals(givenWord)) {
                    
                    System.out.println("{"+node.value + "} is found in location " +"["+ i +"}"+ " and number of occurences  is " +"{"+ node.frequency+"}" );
                    return 0;
                }
                else{
                    node = node.next;
                }
        }
        }
        }
        System.out.println(givenWord+ " is not found in the text");
        return 0;
    }

    @Override
    public float TestEfficiency() {
        float emptyHash = 0;
        float filledHash = 0; 
         for (int i = 0; i < arrayHash.length; i++) {
                       
            if(arrayHash[i]!= null) {
                filledHash++;
            }
            else
                emptyHash++;
        }
         System.out.println("fill " + (int)filledHash + " empty " + (int)emptyHash);
         System.out.println("Size of Hash is: {" + arrayHash.length + "} and Efficiency of Hash is: {%" + 100*(filledHash/arrayHash.length)+"} out of {"+elementNum+"} elements");  // load factor
     return 100*(filledHash/arrayHash.length) ;
    }

    @Override
    public int NumberOfCollusion() {
        
        for (int i = 0; i <arrayHash.length ; i++) {
            
            HashList node = arrayHash[i];
            while(node!= null){                
                if (node.next != null ){ 
                    
                   collision++;
                   node = node.next;
                }
                else{
                    node = node.next; 
                }   
           }
            
       }

        System.out.println("Number of colusion is : {"+ collision+"}");
        return collision;
    }
    
    
}
