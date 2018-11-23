package avlproject.AVLTree;

/*
 * @author Saad Ahmed
 */
public class AVLNode <T extends Comparable<T>>{
    T Key;
    AVLNode Left,Right;
    
    public AVLNode (T _Key){
        Key=_Key;
        Right=Left=null;
    }
}
