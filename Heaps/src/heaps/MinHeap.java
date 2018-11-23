package heaps;

/*
 * @author Saad Ahmed
 */
public class MinHeap 
{
    public int Size;
    public int [] minHeap;
    public int Position;
    public MinHeap(int HSize){
        Size=HSize;
        minHeap= new int [HSize+1];
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
    public void Insert (int Value)
    {
        if (Position+1<minHeap.length){
            minHeap[Position++]=Value;
            minHeapifyup();
        }
        else
        {
            int[]Temp=new int[Position+2];
            for(int i=0;i<Position;i++){
                Temp[i]=minHeap[i];
            }
            Temp[Position++]=Value;
            minHeap=null;
            minHeap=Temp;
            minHeapifyup();
        }
    }
    public void minHeapifyup(){
        int Position1=Position-1;
        while (Position1>0 && minHeap[Position1/2]>minHeap[Position1]){
            int Min=minHeap[Position1/2];
            minHeap[Position1/2]=minHeap[Position1];
            minHeap[Position1]=Min;
            Position1/=2;
        }
    }
    public void Display(){
        for (int I=1;I<Position;I++){
            System.out.print(minHeap[I]+" ");
        }
    }
    public void Delete(){
        Position--;
        int Last=Position;
        minHeap[0]=minHeap[Last];
        minHeapifydown(0,Position);
    }
    public void minHeapifydown(int Position1,int Size){
        int Largest=Position1;
        if (2*Position1+1<Position && minHeap[Position1]>minHeap[Position1*2+1]){
            Largest=Position1*2+1;
        }
        if (2*Position1+2<Position && minHeap[Position1]>minHeap[Position1*2+2] && minHeap[Largest]>minHeap[Position1*2+2]){
            Largest=Position1*2+2;
        }
        if (Largest!=Position1){
            if (Largest<Size){
                Swap(Position1,Largest);
                minHeapifydown(Largest,Size);
            }
        }
    }
    
    public void Swap(int P1,int P2){
        int Temp=minHeap[P2];
        minHeap[P2]=minHeap[P1];
        minHeap[P1]=Temp;
    }
    public boolean isMinHeap (){
        int Index=0;
        while (Index<Position/2){
            if (Index*2+1<minHeap.length){
                if (minHeap[Index]>minHeap[2*Index+1]){
                    return false;
                }
            }
            if (Index*2+2<minHeap.length){
                if (minHeap[Index]<minHeap[2*Index+2]){
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
            if (Index*2+1<Position && Index*2+2<Position){
                if (minHeap[Index*2+1]==0 && minHeap[Index*2+2]!=0){
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
            minHeapifydown(0,Index);
            Index--;
        }
    }
}
// K152881 Saad Ahmed Siddiqui