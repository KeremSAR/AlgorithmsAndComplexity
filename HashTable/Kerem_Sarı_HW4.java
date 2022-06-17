/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kerem_sarı_hw4;

/**
 *
 * @author kerem
 */
public class Kerem_Sarı_HW4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HW4_Interface hashTable = new HW4_Hash(10000); // please enter the hashSize
       
        System.out.println(hashTable.GetHash("KeremSarı"));
        hashTable.ReadFileandGenerateHash("C:\\Users\\kerem\\Desktop\\HW4.txt", 10000);   //please change current file folder according to your system and Hash Size
        hashTable.DisplayResult("C:\\Users\\kerem\\Desktop\\Output.txt");  //please change current file folder according to your system for hash results
        hashTable.DisplayResult();  // displays the results on console
        hashTable.showFrequency("Turned");   
        hashTable.checkWord("voice");   // Finds the position of the word in hash table. 
        hashTable.NumberOfCollusion();  // Shows the number of colisions
        hashTable.TestEfficiency();     // Shows table size, efficiency and Filled and empty spaces for given hash size 
        
        /* please call under methods after other operations. these method disolves the hash table*/
        hashTable.showMaxRepeatedWord(); // changes the order of  the hash table 
        hashTable.DisplayResultOrdered("C:\\Users\\kerem\\Desktop\\Output2.txt"); /**please change current file folder according to your system for ordered hash results
                                                                                   * changes the order of the hash table                                            
                                                                                   */
    }
    
}
