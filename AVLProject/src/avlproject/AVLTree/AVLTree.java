package avlproject.AVLTree;

import java.util.LinkedList;

/**
 *
 * @author Saad Ahmed
 */
public class AVLTree <T extends Comparable<T>>{
    AVLNode <T> Root;
    public AVLTree (){
        Root=null;
    }
    
    public void Insert (T Key){
        Root=Insert (Key,Root);
    }
    
    private AVLNode Insert (T Key, AVLNode <T> Temp){
        if (Temp==null){
            return new AVLNode (Key);
        }
        else {
            int Compare= Key.compareTo(Temp.Key);
            if (Compare<0){
                Temp.Left=Insert(Key,Temp.Left);                
            }
            else if (Compare>0){
                Temp.Right=Insert(Key,Temp.Right);
            }
            int LHeight=Height(Temp.Left);
            int RHeight=Height(Temp.Right);
            if (LHeight-RHeight>1){
                int LLHeight=Height(Temp.Left.Left);
                int LRHeight=Height(Temp.Left.Right);
                if (LLHeight>=LRHeight){
                    return RotateRight(Temp);
                }
                else{
                    return LeftRightRotate(Temp);
                }
            }
            else if (RHeight-LHeight>1){
                int RLHeight=Height(Temp.Right.Left);
                int RRHeight=Height(Temp.Right.Right);
                if (RRHeight>=RLHeight){
                    return RotateLeft(Temp);
                }
                else {
                    return RightLeftRotate(Temp);
                }
            }
        }
        return Temp;
    }

    public int Height(){
        return Height(Root);
    }
    
    private int Height (AVLNode <T> toCHeight){
        if (toCHeight==null){
            return -1;
        }
        else {
            return 1+Math.max(Height(toCHeight.Left),Height(toCHeight.Right));
        }
    }
    
    public AVLNode RotateLeft (AVLNode <T> toRot){
        AVLNode toRC= toRot.Right;
        toRot.Right=toRC.Left;
        toRC.Left=toRot;
        return toRC;
    }
    
    public AVLNode RotateRight (AVLNode <T> toRot){
        AVLNode toRC= toRot.Left;
        toRot.Left=toRC.Right;
        toRC.Right=toRot;
        return toRC;
    }
    
    public AVLNode LeftRightRotate(AVLNode<T> toRot){
        toRot.Left=RotateLeft(toRot.Left);
        return RotateRight(toRot);
    }
    
    public AVLNode RightLeftRotate(AVLNode<T> toRot){
        toRot.Right=RotateRight(toRot.Right);
        return RotateLeft(toRot);
    }    
    
    public void InOrder(){
        InOrder(Root);
    }
    
    private void InOrder(AVLNode<T> A){
        if (A!=null){
            InOrder(A.Left);
            System.out.print(A.Key+" ");
            InOrder(A.Right);
        }
    }
    
    public void BreadthFirstTraversal(){
    if (Root==null){
        return;
    }
    else {
        LinkedList <AVLNode> NList = new LinkedList();
        NList.add(Root);
        while (!NList.isEmpty()){
                AVLNode A=NList.peek();
                NList.remove();
                System.out.print(A.Key+" ");
                if (A.Left!=null){
                    NList.add(A.Left);
                }
                if (A.Right!=null){
                    NList.add(A.Right);
                }
            }
        }
    }   
    public void Delete (T Key){
        Root=Delete (Key,Root);
    }
    public AVLNode Delete(T Key,AVLNode <T> toDel){
        if (toDel==null){
            return toDel;
        }
        else {
            int C=Key.compareTo(toDel.Key);
            if (C==0)
            {
                if(toDel.Right==null&&toDel.Left==null){
                    return null;
                }
                else if (toDel.Right==null||toDel.Left==null)
                {
                    if (toDel.Right==null){
                        return toDel.Left;
                    }
                    else 
                    {
                        return toDel.Right;
                    }
                }
                else if (toDel.Right==null&&toDel.Left==null)
                {
                    toDel.Key=(T)FindMin(toDel.Right);
                    return Delete(toDel.Key,toDel.Right);
                }
            }
            if (C<0){
                toDel.Left= Delete(Key,toDel.Left);
            }
            if (C>0){
                toDel.Right= Delete(Key,toDel.Right);
            }
            int LHeight=Height(toDel.Left);
            int RHeight=Height(toDel.Right);
            if (LHeight-RHeight>1){
                int LLHeight=Height(toDel.Left.Left);
                int LRHeight=Height(toDel.Left.Right);
                if (LLHeight>=LRHeight){
                    return RotateRight(toDel);
                }
                else{
                    return LeftRightRotate(toDel);
                }
            }
            if (RHeight-LHeight>1){
                int LLHeight=Height(toDel.Right.Left);
                int LRHeight=Height(toDel.Right.Right);
                if (LRHeight>=LLHeight){
                    return RotateLeft(toDel);
                }
                else {
                    return RightLeftRotate(toDel);
                }
            }
        }
        return toDel;
    }
    
    
    public T FindMin(){
        return FindMin(Root);
    }
    
    private T FindMin (AVLNode <T> AVLRoot){
        if (AVLRoot.Left==null){
            return AVLRoot.Key;
        }
        else {
            return(T) FindMin(AVLRoot.Left);
        }
    }
    
    
}
