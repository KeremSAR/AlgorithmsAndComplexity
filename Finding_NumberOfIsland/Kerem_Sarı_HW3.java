/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kerem_sarı_hw3;

/**
 *
 * @author kerem
 */
public class Kerem_Sarı_HW3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Shape myshape = new Shape(); 
       myshape.ReadShapeFile("C:\\Users\\kerem\\Desktop\\HW3Q2.txt");       //please change current file folder for stabile system
       myshape.OutputShapes();
       myshape.OutputShapeToFile("C:\\Users\\kerem\\Desktop\\Output.txt");    //please change current file folder for stabile system
       
    }
}
    

