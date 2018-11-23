package heaps;

/*
 * @author K152881
 */
public class MaxHeap {
    public int Size;
    public int [] maxHeap;
    public int Position;
    public MaxHeap(int HSize){
        Size=HSize;
        maxHeap= new int [HSize+1];
        Position=1;
    }
    public void Insert (int [] Array)
    {
        if (Array.length>0){
            for (int i=0;i<Array.length;i++){
                Insert (Array[i]);
            }
        }
    }
    public void Insert (int Value){
        maxHeap[Position++]=Value;
        maxHeapifyup();
    }
    public void maxHeapifyup()
    {
        int Position1=Position-1;
        while (Position1>0 && maxHeap[Position1/2]<maxHeap[Position1]){
            int Min=maxHeap[Position1/2];
            maxHeap[Position1/2]=maxHeap[Position1];
            maxHeap[Position1]=Min;
            Position1/=2;
        }
    }
    public void Display(){
        for (int I=0;I<Position;I++){
            System.out.print(maxHeap[I]+" ");
        }
    }
    public void Delete(){
        Position--;
        int Last=Position;
        maxHeap[0]=maxHeap[Last];
        maxHeapifydown(0,Position);
    }
    public void maxHeapifydown(int Position1,int Size){
        int Largest=Position1;
        if (2*Position1+1<Position && maxHeap[Position1]<maxHeap[Position1*2+1]){
            Largest=Position1*2+1;
        }
        if (2*Position1+2<Position && maxHeap[Position1]<maxHeap[Position1*2+2] && maxHeap[Largest]<maxHeap[Position1*2+2]){
            Largest=Position1*2+2;
        }
        if (Largest!=Position1){
            if (Largest<Size){
                Swap(Position1,Largest);
                maxHeapifydown(Largest,Size);
            }
        }
    }
    
    public void Swap(int P1,int P2){
        int Temp=maxHeap[P2];
        maxHeap[P2]=maxHeap[P1];
        maxHeap[P1]=Temp;

    }
    public boolean isMaxHeap (){
        int Index=0;
        while (Index<Position/2){
            if (Index*2+1<maxHeap.length){
                if (maxHeap[Index]<maxHeap[2*Index+1]){
                    return false;
                }
            }
            if (Index*2+2<maxHeap.length){
                if (maxHeap[Index]<maxHeap[2*Index+2]){
                    return false;
                }
            }
            Index++;
        }
        return true;
    }
    public boolean isCompleteBinaryTree()
    {
        int Index=0;
        while(Index<Position)
        {
            if (Index*2+1<Position&&Index*2+2<Position)
            {
                if (maxHeap[Index*2+1]==0&&maxHeap[Index*2+2]!=0)
                {
                    return false;
                }
            }
            Index++;
        }
        return true;
    }
    public void HeapSort(){
        int Index=Position-1;
        while (Index>=0){
            Swap(0,Index);
            maxHeapifydown(0,Index);
            Index--;
        }
    }
}


// K152881 Saad Ahmed Siddiqui