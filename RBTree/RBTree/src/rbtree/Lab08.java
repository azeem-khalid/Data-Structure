package rbtree;

/**
 *
 * @author k152881
 */
public class Lab08 {
    public static void main(String[] args) {
        RedBlackTree T1=new RedBlackTree();
        T1.Insert(1);
        T1.Insert(-1);
        T1.Insert(2);
        T1.Insert(3);
        T1.Insert(5);
        T1.InOrder();
        System.out.println();
        System.out.print("Number of Null Paths: "+T1.numNullPaths());
        System.out.println();
        System.out.print("Number of Black Nodes: "+T1.numBlackNodes());
        System.out.println();
    }
}
