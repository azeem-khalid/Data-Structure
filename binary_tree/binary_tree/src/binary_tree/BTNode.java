/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binary_tree;

/**
 *
 * @author anam.qureshi
 */
public class BTNode {
    BTNode left, right;
     int data;
 
     /* Constructor */
     public BTNode()
     {
         left = null;
         right = null;
         data = 0;
     }
     /* Constructor */
     public BTNode(int n)
     {
         left = null;
         right = null;
         data = n;
     }
     /* Function to set left node */
     public void setLeft(BTNode n)
     {
         left = n;
     }
     /* Function to set right node */ 
     public void setRight(BTNode n)
     {
         right = n;
     }
     /* Function to get left node */
     public BTNode getLeft()
     {
         return left;
     }
     /* Function to get right node */
     public BTNode getRight()
     {
         return right;
     }
     /* Function to set data to node */
     public void setData(int d)
     {
         data = d;
     }
     /* Function to get data from node */
     public int getData()
     {
         return data;
     }     
}
