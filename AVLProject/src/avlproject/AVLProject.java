package avlproject;

import avlproject.AVLTree.AVLTree;

/**
 *
 * @author Saad Ahmed
 */
public class AVLProject {


    public static void main(String[] args) {
        AVLTree <Integer> AB= new AVLTree();
        AB.Insert(5);
        AB.InOrder();
        AB.Insert(6);
        System.out.print("\n");
        AB.InOrder();
        AB.Insert(7);
        System.out.print("\n");
        AB.InOrder();
        System.out.print(AB.Height());
        System.out.print("\n");
        AB.BreadthFirstTraversal();
        AB.Insert(8);
        System.out.print("\n");
        AB.BreadthFirstTraversal();
        AB.Insert(9);
        System.out.print("\n");
        AB.BreadthFirstTraversal();
        AB.Insert(10);
        System.out.print("\n");
        AB.BreadthFirstTraversal();        
        AB.Delete(5);
        System.out.print("\n");
        AB.BreadthFirstTraversal();        
        AB.Delete(6);
        System.out.print("\n");
        AB.BreadthFirstTraversal();        
        
          AB.Insert(20);
          AB.Insert(10);
          AB.Insert(15);
          AB.BreadthFirstTraversal();
          
    }
    
}
