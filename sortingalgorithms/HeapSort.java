package sortingalgorithms;

public class HeapSort{

    public static void heapSort(int[] array){

        if(array==null)return;

        heapify(array);
        int lastLeaf = (array.length-1);
        int unordenedHeapLength = array.length;

        for(int i=lastLeaf;i>0;i--){
            Integer ordenedValue = array[i];
            array[i]=array[0];
            array[0]=ordenedValue;
            orderHeap(array,0,--unordenedHeapLength);
        }

    }

    private static void orderHeap(int [] array,int parentIndex,int unordenedHeapLength){
        int leftChild = 2*parentIndex+1;
        int rightChild= 2*parentIndex+2;
        if(leftChild < unordenedHeapLength && rightChild<unordenedHeapLength){
            if(array[leftChild]<array[rightChild]){
                leftChild = rightChild;
            }
            if(array[parentIndex]<array[leftChild]){
                swap(array,parentIndex,leftChild);
                orderHeap(array,leftChild,unordenedHeapLength);
            }

        }
       
    }

    private static void swap(int[] array,int parentIndex,int childIndex){
        Integer value = array[parentIndex];
        array[parentIndex]=array[childIndex];
        array[childIndex]=value;
    }

    private static void heapify(int[] array){
        int leaf = (array.length-2)/2;
        for(int i=leaf;i>=0;i--){
            orderHeap(array,i,array.length);
        }

    }
}


class Test {
    public static void main(String[] args) {
        //int[] array = {1,9,3,20,30,2,1};
        int[] array={0,2,1,3,9,4};
        HeapSort.heapSort(array);
        System.out.println(java.util.Arrays.toString(array));
        //Was storing the index of pivot and not the object of pivot element, so after a swap the algorithm was comparing a new pivot element.
    }

}