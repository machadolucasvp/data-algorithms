package sortingalgorithms;

public class Quicksort{

    public static <T extends Comparable<T>> void quickSort(T[] array){
        quickSort(array,0,array.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array,int left,int right){
        if(left<=right){
            return;
        }
        int pivot = left + (right-left)/2;
        int index = partition(array,left,right,pivot);

        quickSort(array,left,index);
        quickSort(array,index+1,right);

    }


    private static <T extends Comparable<T>> int partition(T[] array,int left,int right,int pivot){
        while(left<right){
            while(array[left].compareTo(array[pivot])<0){
                left++;
            }
            while(array[right].compareTo(array[pivot])>0){
                right--;
            }
            if(left<right){
                swap(array,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static <T extends Comparable<T>> void swap(T[] array,int left,int right){
        T leftItem = array[left];
        array[left]=array[right];
        array[right]=leftItem;
  
    }

    
    
}



class Test {
    public static void main(String[] args) {
        Integer[] array = {1,3,8,3,28,3,2,1,7,8,4};
        Quicksort.quickSort(array);
        System.out.println(java.util.Arrays.toString(array));
        System.out.println("okay");
    }

}