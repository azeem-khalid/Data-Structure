package heaps;

/**
 * @author K152881
 */
public class Heaps {
    public static void main(String[] args) {
        int [] Array;
        Array= new int [7];
        Array[0]=32;
        Array[1]=15;
        Array[2]=20;
        Array[3]=30;
        Array[4]=12;
        Array[5]=25; 
        Array[6]=16;
        MaxHeap Heap1= new MaxHeap(Array.length);
        Heap1.Insert(Array);
        System.out.println("Bonus Task 1: ");
        System.out.println("Heap After Insertion: ");
        Heap1.Display();
        System.out.println();        
        System.out.println("Ia a Max Heap ? : "+Heap1.isMaxHeap());
        System.out.println("Ia a Complete Binary Tree ? : "+Heap1.isCompleteBinaryTree());
        Heap1.Delete();
        System.out.println("Final Heap After Deletion: ");
        Heap1.Display();
        System.out.println();
        System.out.println();
        
        
        
        
        System.out.println("Bonus Task 2: ");
        System.out.println("After Sorting with Heapsort: ");
        Heap1.HeapSort();
        Heap1.Display();
        
        int [] Array1;
        Array1= new int [6];
        Array1[0]=1;
        Array1[1]=2;
        Array1[2]=3;
        Array1[3]=5;
        Array1[4]=8;
        Array1[5]=10;
        MinHeap Heap2= new MinHeap(Array1.length);
        System.out.println();
        System.out.println();
        
        
        
        System.out.println("Task 1: ");
        System.out.println("After Inserting in MinHeap: ");
        Heap2.Insert(Array1);
        Heap2.Display();
        System.out.println();
        System.out.println("After Inserting 1 in MinHeap Following Properties: ");
        Heap2.Insert(1);
        Heap2.Display();
        System.out.println();        
        System.out.println("After Inserting 7 in MinHeap Following Properties: ");
        Heap2.Insert(7);
        Heap2.Display();
        System.out.println();
        
        int [] Array3;
        Array3= new int [5];
        Array3[0]=21;
        Array3[1]=13;
        Array3[2]=10;
        Array3[3]=7;
        Array3[4]=11;
        MaxHeap Heap3= new MaxHeap(Array3.length);
        System.out.println();
        System.out.println();
        
        
        
        System.out.println("Task 2: ");
        for (int index=0;index<5;index++)
        {
            System.out.print("Insertion #"+(index+1)+" : ");
            Heap3.Insert(Array3[index]);
            Heap3.Display();
            System.out.println();
        }
        System.out.print("After Deletion : ");
        Heap3.Delete();
        Heap3.Display();
        System.out.println();    
        System.out.print("Insertion of 15 : ");
        Heap3.Insert(15);
        Heap3.Display();
        System.out.println();

    }
}
// K152881 Saad Ahmed Siddiqui