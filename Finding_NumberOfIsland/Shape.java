/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerem_sarı_hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/**
 *
 * @author kerem
 */
public class Shape implements HW3_Interface{
    
    Queue<Position> stateQueue = new LinkedList<Position>();
    Queue<Integer> xDistanceQueue = new LinkedList<Integer>();
    Queue<Integer> yDistanceQueue = new LinkedList<Integer>();
    public int[][] M;
    int count= 0;
    String paths;
    int currentState=1;
    
    @Override
    public void ReadShapeFile(String path) {
        this.paths=path;        //It takes the given path to memory
        int Bounds =0;
        File inFile = new File(path); 

        try {

            Scanner input = new Scanner(inFile);                   // finding the how many elements in a row and split them and count them to find column
            String[] Length = input.nextLine().trim().split(" ");
                for (int i = 0; i < Length.length; i++) {
                Bounds++;
            }
            input.close();
            
            
            M = new int[Bounds][Bounds];
            input = new Scanner(inFile);
            
            int LineCount =0;
            while (input.hasNextLine()) {                                            
                String[] currentLine = input.nextLine().trim().split(" ");      // store them into the array the values every line
                for (int i = 0; i < currentLine.length; i++) {
                    M[LineCount][i] = Integer.parseInt(currentLine[i]);     // set the values to global matrix in order
                }
                LineCount++;
            }
                
        } catch (FileNotFoundException ex) {        //catch errors and print them
            System.out.println("cannot read the file ");
        }  
    }
   
  
    public void DFS(int i, int j,int row, int col ){
        if (i < 0 || j < 0 || i > (row - 1) || j > (col - 1) || M[i][j] != 1 ) {    // Borders  detection of 2D array
            return;
        }  
        Position here = new Position();
        if(M[i][j]== 1){
 
              M[i][j] =currentState;   
              here = new Position(i,j);
              stateQueue.add(here);    // adds position of currentState
             
            DFS( i + 1, j, row, col);     //right side traversal
            DFS( i - 1, j, row, col);     //left side traversal
            DFS(i, j + 1, row, col);     //upward side traversal
            DFS(i, j - 1, row, col);     //downward side traversal
            DFS(i + 1, j + 1, row, col); //upward-right side traversal
            DFS( i - 1, j - 1, row, col); //downward-left side traversal
            DFS( i + 1, j - 1, row, col); //downward-right side traversal
            DFS( i - 1, j + 1, row, col); //upward-left side traversal
            
        }   
    }
    
    @Override
    public void OutputShapes(){
         int row = M.length;
         int col = M[0].length;
         int count =0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {        // searching 1's in 2d array
                if (M[i][j]==1) {
                currentState++;         // increase current state for other shape
                DFS( i , j, row, col);    // if 1 founds goes  depth to find other neigbours
                count++;             //  detect number of shapes
                System.out.println("Shape " + count);
                
                PrintShape();       // printShape function
                    
                  M[i][j] =0;       // after printing the shapes turn its states to 0
                }
                else M[i][j] =0;     // to turning the states of printed shapes to 0
            }   
        }
       System.out.print("Number of shape is:" + count +" ");   
    }
    void PrintShape(){
        int row =0 ;
        int col=0 ;
        Position next = new Position();
        int xDistances =0;
        int xDistanceArr[];
        int temp,temp1;
        int removefromXaxis ;
        int removefromXaxisCounter=0;
        int yDistanceArr[];
        int removefromYaxis;
        int removefromYaxisCounter=0;
        int yDistancesCounter = 0; 
        int yDistances = 0;
      
        while (!(stateQueue.isEmpty())) {      //  set the bounds of shape  
            next = stateQueue.remove();
            if (row <= next.row) {
               row = next.row;
            }
            if (col <=next.col) {
               col = next.col;
            }
        }
      
       
       if(stateQueue.isEmpty()){        // Finding the distances between 2D matrix border and shape border
        for (int i = 0; i < row+1; i++) {        
            for (int j = 0; j < col+1; j++) {                   
                if (M[i][j]==currentState){
                    yDistancesCounter++;        
                    xDistances=j;
                    xDistanceQueue.add(xDistances);  // distance of x values adding to different queue
                   }                 
            }
            if (yDistancesCounter==0) {        
                yDistances=i;  
            }

            yDistanceQueue.add(yDistances);    // distance of y values adding to diffrent queue
        }
       }
        int ySize = yDistanceQueue.size();  
        yDistanceArr = new int[ySize];
       
        while(!(yDistanceQueue.isEmpty())){            // put in a array the Y distances of shape elements
             removefromYaxis = yDistanceQueue.remove();
            yDistanceArr[removefromYaxisCounter]=removefromYaxis;
            removefromYaxisCounter++; 
        }
        
        for(int i = 0; i<ySize; i++ ){                   // search highest number of y  array with bubble sort
            for(int j = i+1; j<ySize; j++){
                if(yDistanceArr[i]<yDistanceArr[j]){
                   temp1 = yDistanceArr[i];
                   yDistanceArr[i] = yDistanceArr[j];
                   yDistanceArr[j] = temp1;
                }
             }
          }
        
        
        int xSize = xDistanceQueue.size();  
        xDistanceArr = new int[xSize];
       
        while(!(xDistanceQueue.isEmpty())){            // put in a array the X distances of shape elements
             removefromXaxis = xDistanceQueue.remove();
            xDistanceArr[removefromXaxisCounter]=removefromXaxis;
            removefromXaxisCounter++; 
        }
        
        for(int i = 0; i<xSize; i++ ){           // search least number of x  array with bubble sort
            for(int j = i+1; j<xSize; j++){
                if(xDistanceArr[i]>xDistanceArr[j]){
                   temp = xDistanceArr[i];
                   xDistanceArr[i] = xDistanceArr[j];
                   xDistanceArr[j] = temp;
                    }
                 }
              }
       
       if(stateQueue.isEmpty() && !(yDistanceArr[0]==0)&&xDistanceQueue.isEmpty()&&yDistanceQueue.isEmpty()){      // shifting the elements of shape on Y axis
        for (int i = 0; i < row+1; i++) {
            for (int j = 0; j < col+1; j++) {                   
                
                if (M[i][j]==currentState){                         
                    M[i-(yDistanceArr[0]+1)][j]=currentState;       // shifting all elements to up on Y axis
                    M[i][j] =0;   
                    }        
            }             
        }
   
        }
       if(stateQueue.isEmpty() && !(xDistanceArr[0]==0)&&xDistanceQueue.isEmpty()&&yDistanceQueue.isEmpty()){          // shifting the elements of shape on X axis
        for (int i = 0; i < row+1; i++) {
            for (int j = 0; j < col+1; j++) {                   
                
                if (M[i][j]==currentState){
                    M[i][j -(xDistanceArr[0]-1)]=currentState;    // shifting all element to left on X axis
                    M[i][j] =0;   
                    }
            }             
        }
        }
        if(!(xDistanceArr[0]==0) && yDistanceArr[0]==0 && xDistanceQueue.isEmpty()&&yDistanceQueue.isEmpty()){  //  if there is no need to shift stay at same pos.
            for (int i = 0; i < row+1; i++) {
                for (int j = 0; j < col+1; j++) {                   
                
                if (M[i][j]==currentState){
                    M[i][j]=currentState;      
                }
        }}}
        
        for (int k = 0; k < (row+1)-(yDistanceArr[0]); k++) {           // prints the elements of shape
            for (int m = 0; m < (col+1)-(xDistanceArr[0]-1); m++) {
                if(M[k][m]==currentState){
                    System.out.print("*");
                    M[k][m] =0;
                }
                else System.out.print(" ");
                //M[k][m] = 0; 
            }System.out.println("");  
             
       }
          
    
}
      @Override
    public void OutputShapeToFile(String path) {
        ReadShapeFile(paths);       // reads the matrix for multiple call
        PrintStream printStream;
        try {
            printStream = new PrintStream(path);        // prints method to in given path file
            System.setOut(printStream);         // set the system.out to given stream
            OutputShapes();
            
        } catch (FileNotFoundException ex) {
            System.out.println("cannot read the shape");
        }
       
    }
        
}  


