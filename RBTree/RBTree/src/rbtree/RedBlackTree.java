package rbtree;

/**
 * @author k152881
 */
public class RedBlackTree {
    Node Root;
    public RedBlackTree(){
        Root=null;
    }
    public void Insert (int Value)
    {
        Root=Put(Value,Root);
        Root.Color=0;
    }
    public Node Put (int Value,Node Root){
        if (Root ==null)
        {
            return new Node (Value);
        }
        else 
        {
            if (Value<Root.Value){
                Root.Left=Put(Value,Root.Left);
            }
            else if (Value>Root.Value){
                Root.Right=Put(Value,Root.Right);
            }
            if ((Root.Right!=null&&Root.Right.Color==1)&&(Root.Left!=null&&Root.Left.Color!=1))
            {
                    Root=RotateLeft(Root);
            }
            if ((Root.Left!=null&&Root.Left.Color==1)&&(Root.Left.Left!=null&&Root.Left.Left.Color==1))
            {
                    Root=RotateRight(Root);
            }
            if (Root.Left!=null&&Root.Right!=null)
            {
                if (Root.Left.Color==1&&Root.Right.Color==1)
                {
                    Root=FlipColor(Root);
                }
            }

        }
        return Root;
    }
    
    private Node RotateLeft(Node Root)
    {
        Node T=Root.Right;
        int Color=T.Color;
        int Color1=Root.Color;
        Root.Color=Color;
        Root.Right=T.Left;
        T.Left=Root;
        T.Color=Color1;
        return T;
    }
    
    private Node RotateRight(Node Root)
    {
        Node T=Root.Left;
        int Color=T.Color;
        int Color1=Root.Color;
        Root.Color=Color;
        Root.Left=T.Right;
        T.Right=Root;
        T.Color=Color1;
        return T;
    }
    
    private Node FlipColor(Node Root)
    {
        int Color=Root.Color;
        int Color1=Root.Right.Color;
        Root.Color=Color1;
        Root.Right.Color=Color;
        Root.Left.Color=Color;
        return Root;
    }
    
    public void InOrder(){
        System.out.println();
        System.out.print("InOrder: ");
        InOrder(Root);
        System.out.println();
    }
    public void InOrder(Node Root){
        if (Root!=null){
            InOrder(Root.Left);
            System.out.print(Root.Value+" ");
            InOrder(Root.Right);
        }
    }
    
    public int numNullPaths(){
        return numNullPaths(Root);
    }
    
    private int numNullPaths(Node Root){
        if (Root==null){
            return 0;
        }
        else {
            if (Root.Left==null&&Root.Right==null)
            {
                return 1+numNullPaths(Root.Left)+numNullPaths(Root.Right);
            }
            else if (Root.Left==null||Root.Right==null){
                if (Root.Left==null){
                    return 1+numNullPaths(Root.Right);
                }
                else{
                    return 1+numNullPaths(Root.Left);
                }
            }
            else if (Root.Left!=null&&Root.Right!=null){
                return 0+numNullPaths(Root.Left)+numNullPaths(Root.Right);
            }
        }
        return +0;
    }
    
    public int numBlackNodes (){
        return numBlackNodes(Root);
    }
    
    private int numBlackNodes(Node Root){
        if (Root==null){
            return 0;
        }
        else {
            if (Root.Color==0){
                return 1+numBlackNodes(Root.Right)+numBlackNodes(Root.Left);
            }
            else {
                return 0+numBlackNodes(Root.Right)+numBlackNodes(Root.Left);
            }
        }
    }
    
    private int FindMin(Node Root){
        if (Root.Left==null){
            return Root.Value;
        }
        else{
            return FindMin(Root.Left);
        }
    }
    
    public void Delete (int Value){
        Root=Delete(Value,Root);
    }
    
    private Node Delete(int Value,Node Root){
        if (Root==null){
            return Root;
        }
        else{
            if (Value==Root.Value){
                if (Root.Color==0){
                    if (Root.Left==null||Root.Right==null){
                        if (Root.Left!=null){
                            Root=Root.Left;
                            Root.Color=0;
                        }
                        else{
                            Root=Root.Right;
                            Root.Color=0;
                        }
                    }
                    else if (Root.Left!=null&&Root.Right!=null){
                        Root.Value=FindMin(Root.Right);
                        Root.Right=Delete(Root.Value,Root.Right);
                    }
                }
                else {
                    if (Root.Left==null&&Root.Right==null){
                        return null;
                    }
                    else if (Root.Left!=null||Root.Right!=null){
                        if (Root.Right!=null){
                            return Root.Right;
                        }
                        else {
                            return Root.Left;
                        }
                    }
                    else if (Root.Left!=null&&Root.Right!=null){
                        Root.Value=FindMin(Root.Right);
                        Root.Right=Delete(Root.Value,Root.Right);
                    }
                }
            }
            else if (Value<Root.Value){
                Root.Left=Delete(Value,Root.Left);
            }
            else if (Value>Root.Value){
                Root.Right=Delete(Value,Root.Right);
            }
        }
        return Root;
    }
}
