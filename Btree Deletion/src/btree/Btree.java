/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package btree;

/**
 *
 * @author student16
 */
public class Btree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BSTree A=new BSTree();
        A.Insert(50);
        A.Insert(70);
        A.Insert(10);
        A.Insert(30);
        A.Insert(20);
        A.Insert(60);
        A.Insert(40);
        
     //  A.Insert(25);
        A.inOrder();
        System.out.println();
      //  A.Delete(10);
        //A.Delete(60);
   //     A.inOrder();
   System.out.println(A.search(1000));
   
        
    }
    
}
