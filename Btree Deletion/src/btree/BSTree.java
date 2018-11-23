


package btree;

import java.util.LinkedList;

/**
 *
 * @author K152881
 */
public class BSTree {
    BTNode Root;
    public BSTree(){
        Root=null;
    }
    public boolean search(int value)
    {
        return search(Root,value);
    }
    public boolean search(BTNode temp,int Value)
    {
        if(temp.Value==Value)
        {
            return true;
        }
        else
        {
            while(temp.Left!=null&&temp.Right!=null)
            {
                if(Value>temp.Value)
                {
                    temp=temp.Right;
                }
                else if(Value<temp.Value)
                {
                    temp=temp.Left;
                }
                if(temp.Value==Value)
                {
                    return true;
                } 
            }
            return false;
            
        }
    }
    
    public void Insert(Integer A)
    {
        BTNode Y=null;
        BTNode X= Root;
        while(X!=null){
            Y=X;
            if (A<X.Value){
                X=X.Left;
            }
            else{
                X=X.Right;
            }
        }
        BTNode D=new BTNode(A);
        if (Y==null){
            Root = D;
        }
        else{
            if (D.Value<Y.Value){
                Y.Left=D;
            }
            else{
                Y.Right=D;
            }
        }
    }
    public void inOrder(){
        inOrder(Root);
    }
    public void inOrder(BTNode Root){
        if (Root!=null){
            inOrder(Root.Left);
            System.out.print(Root.Value+" ");
            inOrder(Root.Right);
        }
    }
    public int Height(){
        return Height(Root);
    }
    
    private int Height(BTNode Node){
    if (Node == null){
        return 0;
    }
    else{
        return 1 +Math.max(Height(Node.Left),Height(Node.Right));
    }
}
    int Max (Integer A,Integer B){
        if (A<B){
            return A;
        }
        else {
            return B;
        }
    }
    
    public BTNode FindSuccessor(BTNode Root,BTNode A){
        BTNode Y=null;    
        if (A.Right!=null){
            Y=A.Right;
            while(Y.Left!=null){
                Y=Y.Left;
            }
            return Y;
        }        
        else {
            while(Root!=null){
                if (A.Value<Root.Value){
                    Y=Root;
                    Root = Root.Left;
		}
		else if (A.Value>Root.Value) {
                    Root = Root.Right;
		}
		else {
                    break;
		}
            }
        }
        return Y;
    }
    
    
    
    
    
    
    /*int treeHeight(BTNode Node) {
        if (node == null)
        return 0;
        
        LinkedList<BTNode> q = new LinkedList();
  
        q.add(node);
        int height = 0;
        while (1 == 1){
            int nodeCount = q.size();
            if (nodeCount == 0)
                return height;
            height++;
            while (nodeCount > 0){
                BTNode newnode = q.peek();
                q.remove();
                if (newnode.Left != null)
                    q.add(newnode.Left);
                if (newnode.Right != null)
                    q.add(newnode.Right);
                nodeCount--;
            }
        }
    }*/
    
  /*  public void Delete (BTNode Root,Integer Value){
        BTNode Parent=Root;
        while(Root.Value!=Value){
            Parent=Root;
            if (Value < Root.Value){
                Root=Root.Left;
            }
            if (Value > Root.Value){
                Root=Root.Right;
            }
        }
        if (Root.Right==null&&Root.Left==null){
            if (Parent.Right==Root){
                Parent.Right=null;
            }
            else{
                Parent.Left=null;
            }
        }
        if ((Root.Left!=null&&Root.Right==null) || (Root.Right!=null&&Root.Left==null))
        {
            if (Root.Left!=null){
                if (Parent.Left==Root){
                    Parent.Left=Root.Left;
                    Root=null;
                }
                else {
                    Parent.Right=Root.Left;
                    Root=null;
                }
            }
            else{
                if (Parent.Left==Root){
                    Parent.Left=Root.Right;
                    Root=null;
                }
                else {
                    Parent.Right=Root.Right;
                    Root=null;
                }
            }
        }
    }*/
    public void Delete(BTNode temp,Integer Value)
    {
        BTNode parent=temp;
        BTNode temp2=null;
        while(temp.Value!=Value)
        {
            parent=temp;
            if(Value<temp.Value)
            {
                temp=temp.Left;
            }
            else
            {
                temp=temp.Right;
            }
        }
        
        if(temp.Right==null&&temp.Left==null)
        {
            if(parent.Right==temp)
            {
                parent.Right=null;
            }
            else
            {
                parent.Left=null;
            }
        }
        if(temp.Right!=null||temp.Left!=null)
        {
            if(temp.Right!=null)
            {
                if(parent.Right==temp)
                {
                    parent.Right=temp.Right;
                }
                else
                {
                    parent.Left=temp.Right;
                }
                
            }
            if(temp.Left!=null)
            {
                if(parent.Right==temp)
                {
                    parent.Right=temp.Left;
                }
                else
                {
                    parent.Left=temp.Left;
                }
            }
        }
        
    }
    
    public void inorder()
    {
        inorder(Root);
    }
    public void inorder(BTNode r)
    {
        if(r!=null)
        {
            inorder(r.Left);
            System.out.println(r.Value);
            inorder(r.Right);
        }
    }
}