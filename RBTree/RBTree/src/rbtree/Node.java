package rbtree;
/**
 *
 * @author k152881
 */
//Red=1
//Black=0
public class Node {
    int Value;
    int Color;
    Node Left,Right;
    public Node(int value){
        this.Value=value;
        Left=Right=null;
        Color =1;
    }
}



