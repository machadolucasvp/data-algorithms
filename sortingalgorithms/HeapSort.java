package sortingalgorithms;

public class HeapSort{

    public static void heapSort(int[] array){

        if(array==null)return;

        heapify(array);
        int lastLeaf = (array.length-1);

        for(int i=lastLeaf;i>0;i--){
            Integer ordenedValue = array[i];
            array[i]=array[0];
            array[0]=ordenedValue;
            orderHeap(array,0);
        }

    }

    private static void orderHeap(int [] array,int parentIndex){
        int leftChild = 2*parentIndex+1;
        int rightChild= 2*parentIndex+2;
        if(leftChild < array.length && rightChild<array.length){
            if(array[leftChild]<array[rightChild]){
                leftChild = rightChild;
            }
            if(array[parentIndex]<array[leftChild]){
                swap(array,parentIndex,leftChild);
                orderHeap(array,parentIndex);
            }
            
        }
       
    }

    private static void swap(int[] array,int parentIndex,int childIndex){
        Integer value = array[parentIndex];
        array[parentIndex]=array[childIndex];
        array[childIndex]=value;
    }

    private static void heapify(int[] array){
        int leaf = (array.length-1)/2;
        for(int i=leaf;i>=0;i--){
            orderHeap(array,i);
        }

    }
}


class Test {
    public static void main(String[] args) {
        int[] array = {1,9,3,20,30,2,1};
        HeapSort.heapSort(array);
        System.out.println(java.util.Arrays.toString(array));
        System.out.println("okay");
    }

}