/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kerem_sarı_hw3;

/**
 *
 * @author kerem
 */
public class SecondHashList {
    public Integer key;
    public String value;
    public SecondHashList next;
    public Integer frequency ;
    
    public SecondHashList (String value){
        this.value = value;
       this.frequency=frequency;
        //this.next = null;
    }
    public SecondHashList(Integer key, String value){
        
        this.key=key;
        this.value = value;
        //this.next = null;  // ilk oluştuğunda hash ilki boş olduğu için next null
    }
    public SecondHashList(){
       
    }
}
