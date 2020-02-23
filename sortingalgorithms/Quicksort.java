package sortingalgorithms;

public class Quicksort{

    public static <T extends Comparable<T>> void quickSort(T[] array){
        quickSort(array,0,array.length-1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array,int left,int right){
        if(left>=right){
            return;
        }
        int index = partition(array,left,right);
        quickSort(array,left,index);
        quickSort(array,index+1,right);
    }


    private static <T extends Comparable<T>> int partition(T[] array,int left,int right){
    int pivotIndex = left + (right-left)/2;
    T pivot = array[pivotIndex];
        while(left<right){
            while(array[left].compareTo(pivot)<0){
                left++;
            }
            while(array[right].compareTo(pivot)>0){
                right--;
            }
            if(left<right){
                swap(array,left,right);
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
        Integer[] array = {1,9,3,20,30,2,1};
        Quicksort.quickSort(array);
        System.out.println(java.util.Arrays.toString(array));
    }
}
