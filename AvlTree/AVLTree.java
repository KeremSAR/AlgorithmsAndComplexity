/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerem_sarı_bonushw;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author kerem
 */
public class AVLTree{
    AVLNode root ;
    
    Integer Height (AVLNode t){
        int heightVal, heightRight , heightLeft ;
        if (t == null) {
           heightVal = -1;
        }
        else{
            heightLeft = Height(t.left);
            heightRight = Height(t.right);
            heightVal = 1 + (heightLeft> heightRight ? heightLeft : heightRight);
            
        }
        return heightVal;
    }
    
    private AVLNode rightRotate( AVLNode node){
        
        AVLNode newParent = node.left;

        node.left = newParent.right;
        newParent.right = node;         //rotates right
       
        node.height = Height(node);            
        newParent.height = Height(newParent);       // updates height
         
        return newParent;   
    }
    private AVLNode leftRotate( AVLNode node){
        
        AVLNode newParent = node.right;
      
        node.right = newParent.left;    
        newParent.left = node;          // rotates left

        node.height = Height(node);
        newParent.height = Height(newParent);   // updates height
         
        return newParent;   
    }
 
    public void insertStudent (Integer idNr, String name, String surname ){
        root = Insert(root, idNr, name, surname);    
    }
    
    public AVLNode searchStudent(Integer idNr){
        
        SearchBinary(root, idNr); 
        return null;
        
    }
    
    private AVLNode SearchBinary( AVLNode node,Integer idNr){
        
        if (node == null) {
            System.out.println("NULL");
            return null;
        }
        
        if (idNr < node.idNr ) {
            SearchBinary(node.left, idNr);
        }
        else if (idNr > node.idNr) {
            SearchBinary(node.right, idNr);
        }
        else if (Objects.equals(idNr, node.idNr)) {
            System.out.println(node.Name);
        }
        
        return null;
  
    }
    public void printSearchPath(Integer idNr){
        PrintSearchBinary(root, idNr);
    }
    boolean firstNode= true;            // to print first node.
    private AVLNode PrintSearchBinary( AVLNode node,Integer idNr){
      if (firstNode) {
            System.out.print(node.idNr);
            firstNode = false;
           PrintSearchBinary(node, idNr);

        } 
      else{  
        if (node == null) {
            System.out.println("NULL");
            return null;
        }
        
        if (idNr < node.idNr ) {
            System.out.print("-(Left)->" + node.left.idNr);
            PrintSearchBinary(node.left, idNr);
            
        }
        else if (idNr > node.idNr) {
            System.out.print("-(Right)->"+ node.right.idNr);
            PrintSearchBinary(node.right, idNr);
            
        }
        else if (Objects.equals(idNr, node.idNr)) {
            System.out.print("(FOUND).");
        }
      }
        return null;
  
    }
    
    public void deleteStudent(Integer idNr){
        
        this.root =Delete(root, idNr); 
          
    }
  
    private AVLNode Delete( AVLNode node,Integer idNr){
       
        if (node == null) {
            
            return null;
        }  
        if (idNr < node.idNr ) {
            node.left =Delete(node.left, idNr);
        }
        else if (idNr > node.idNr) {
             node.right= Delete(node.right, idNr);
        }
        else  {
            
            if (node.left == null && node.right == null) {
                node = null;
                return node;
            }
            if (node.left == null || node.right == null) {

                if (node.left == null ) {   // changes the node with its right child
                   
                   return node.right;
                }
                if (node.right == null) {   // changes the node with its left child
                   return node.left;
                }
            }
            else{                      
                if (this.root.left !=null) {            // always takes the left subtree of the largest element if it is null takes from right subtree

                    while (node.left.right != null) {      // maximum number of left subtree              
                        node.left = node.left.right;   
                    }
                    Integer max =node.left.idNr;
                    String Name = node.left.Name;
                    String Surname = node.left.Surname;


                    node.idNr = max;        // changes the idNr of the deleted element
                    node.Name = Name;
                    node.Surname= Surname;
                    node.left = Delete(node.left, max);    // finds the largest element in the left subtree and removes for prevent having two same node.

            } 
                else {                          // takes the smallest element of the right subtree
                   
                    while (node.right.left != null) {       // minimum numbe of left subtree             
                        node.right = node.right.left;   
                    }
                    Integer min =node.right.idNr;
                    String Name = node.right.Name;
                    String Surname = node.right.Surname;

                    node.idNr = min;            // changes the idNr of the deleted element
                    node.Name = Name;
                    node.Surname= Surname;
                    node.right = Delete(node.right, min);      // finds the smallest element in the right subtree and remove.
                }
               
            }

    }return BalanceTree(node, idNr);
    }

    private AVLNode Insert(AVLNode node, Integer idNr, String name, String surname){
        
       if (node == null) {
           return new AVLNode(idNr,name,surname);
       }
    
        if (idNr< node.idNr) {
            node.left = Insert(node.left,idNr, name, surname);
        }
        else if (idNr > node.idNr) {
           node.right = Insert(node.right, idNr, name, surname);
       }
        
        else return node;
       
     
        
        return  BalanceTree(node, idNr);
        
    }
   
   private AVLNode BalanceTree(AVLNode node, Integer idNr){
       
       node.height =  Height(node);
        
        int balance = getBalance(node);  // balance of node
        
        if (balance >1 ) {                  
            if (idNr < node.left.idNr) {        // Left Left case
                return rightRotate(node);
            }
            if (idNr > node.left.idNr) {            // left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
       }
        
        if (balance < -1 ) {  
            if (idNr > node.right.idNr) {        // right right case
                return leftRotate(node);
            }
            if (idNr< node.right.idNr) {        // right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            
       }
 
        return node;
   }
   int getBalance (AVLNode t){  //calculates balance
        
        if (t == null) {
           return 0;
        }
        return Height(t.left)- Height(t.right);
        
    }
   
   public void traversePreOrder(AVLNode t)
    {
        if( t!= null)
        {
            System.out.println(t.idNr + " "+ t.Name+ " " + t.Surname);
            traversePreOrder(t.left);
            traversePreOrder(t.right);
        }
    }
  
   
   public void processFile(String filename){
        Queue<Integer> IdQueue = new LinkedList<Integer>();
        Queue<String> NameQueue = new LinkedList<String>();
        Queue<String> SurnameQueue = new LinkedList<String>();
        int NumOfInsertion=0;
        int NumOfDeletion = 0;
        String[] values= new String[500];
        int arrSize=0;
     
       try {
            Scanner s = new Scanner(new File(filename));
            
           
            while (s.hasNextLine()) {
               String word = s.next(); 
               String[] tempArray = word.trim().split(" ");           // it takes each data with splitting the empty spaces  
               
               values[arrSize] =tempArray[0];
               arrSize++;     
            }
            NumOfInsertion = Integer.parseInt(values[0]);       // insertion number
            NumOfDeletion = Integer.parseInt(values[1]);        // deletion number
           
            for (int i = 2; i < arrSize-NumOfDeletion; i=i+3) {
                IdQueue.add(Integer.parseInt(values[i]));
                NameQueue.add(values[i+1]);
                SurnameQueue.add(values[i+2]);
               
           }
            System.out.println(values[arrSize-1]+ " " + values[arrSize-2]);
                 
            for (int i = 0; i < NumOfInsertion; i++) {          // insert the elements in right order
                insertStudent(IdQueue.remove(),NameQueue.remove(),SurnameQueue.remove());
           }
          /*  for (int i = 0; i < NumOfDeletion; i++) {           // delete the  pointed elements   // operation is unstable deleting root causes distortion 
                deleteStudent(Integer.parseInt(values[arrSize-i-1]));   // can be activated to delete larger size of trees
           }*/
          
            
            System.out.print("Please enter the id :");
            Scanner in = new Scanner(System.in);
            int id = in.nextInt();
            if (id==0) {
                System.out.println("Element is not in the tree");
           }
            else{
                try {
                printSearchPath(id);
            } catch (Exception e) {
                    System.out.println(" Element is not in the tree ");
            }
            }
 
            s.close();
            
        }  
        
        catch (FileNotFoundException ex) {
            System.out.println("Couldn't read the file");
        }
   }
   

   boolean firstNode1= true;        // to print all tree
    public void printTree(AVLNode node,  boolean isRight) {
       
        if (firstNode1) {
            System.out.print(node.idNr);
            firstNode1 = false;
            printTree(node.left,  false);
            printTree(node.right, true);

        } 
        else{
             if (node != null) {
                if (isRight) {
                  System.out.print("-(Right)->");

                } 
                else {
                  System.out.print("-(Left)-> ");
                }
                System.out.print(node.idNr);
                printTree(node.left,  false);
                printTree(node.right, true);
            }
            
        }
   
  }
}
    
   
    
    
    

