package sortingalgorithms;
@SuppressWarnings("unchecked")
public class MergeSort{

    public static <T extends Comparable<T>> void mergeSort(T[] array){
        T[] mergeArray = (T[]) new Comparable[array.length];
        mergeSort(0,array.length-1,mergeArray,array);
    } 

    private static <T extends Comparable<T>> void mergeSort(int left,int right,T[] mergeArray,T[] array){
        if(left >= right){
            return;
        }
        int middle=left+((right-left)/2);

        //Divide
        mergeSort(left,middle,mergeArray,array);
        mergeSort(middle+1,right,mergeArray,array);

        //Conquer
        merge(left,right,mergeArray,array);
    }

    private static<T extends Comparable<T>> void merge(int leftStart,int rightEnd,T[] mergeArray,T[] array){
        int middle = leftStart+((rightEnd-leftStart)/2);
        int leftEnd = middle;
        int rightStart = middle+1;
        int index=leftStart;

        while(leftStart<=leftEnd && rightStart<=rightEnd){
            if(array[leftStart].compareTo(array[rightStart])<=0){
                mergeArray[index]=array[leftStart++];
            }else{
                mergeArray[index]=array[rightStart++];
            }
            index++;
        }
        while(leftStart<=leftEnd){
            mergeArray[index++]=array[leftStart++];
        }
        while(rightStart<=rightEnd){
            mergeArray[index++]=array[rightStart++];
        }

        for(int i=0;i<rightEnd-leftStart+1;i++){
            array[i]=mergeArray[i];
        }
    }

    
}



class Test {
    public static void main(String[] args) {
        Integer[] array = {1,3,8,3,28,3,2,1,7,8,4};
        MergeSort.mergeSort(array);
        System.out.println(java.util.Arrays.toString(array));
    }

}