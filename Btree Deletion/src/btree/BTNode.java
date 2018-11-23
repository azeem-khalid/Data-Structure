package btree;

public class BTNode {
    BTNode Left,Right;
    Integer Value;
    BTNode(Integer Val){
        Value=Val;
        Left=null;
        Right=null;
    }
}
