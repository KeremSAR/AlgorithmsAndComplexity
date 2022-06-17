/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerem_sarı_bonushw;

/**
 *
 * @author kerem
 */
public class AVLNode {
    Integer idNr;
    String Name;
    String Surname;
    
    Integer height;
    
    AVLNode left;
    AVLNode right;

    
    public  AVLNode(Integer idNr, String name, String surname){
        this.Name = name;
        this.Surname = surname;
        this.idNr = idNr;
        height = 1;
        
               
    }

    void setName(String n, String s){
        this.Name =n;
        this.Surname =s;
        
    } 
}
