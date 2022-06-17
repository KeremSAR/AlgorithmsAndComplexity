/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kerem_sarı_bonushw;

/**
 *
 * @author kerem
 */
public class Kerem_Sarı_BonusHW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        
        tree.processFile("C:\\Users\\kerem\\Desktop\\HWBonus.txt"); //please change current file folder according to your system
 
        
        System.out.println(" \n");
        System.out.println("Preorder traversal" + " of constructed tree is : ");
        tree.traversePreOrder(tree.root);
        
      
        System.out.println(" \nAll the tree printed ");
        tree.printTree(tree.root, true);
         
       
    }
    
}
