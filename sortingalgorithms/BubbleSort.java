package sortingalgorithms;



public class BubbleSort {

    public static <T extends Comparable<T>> void bubbleSort(T[] array){
        int lastPointer=array.length-1;
        boolean isSorted  = false;
        while(isSorted!=true){
            isSorted=true;
            for(int i=0;i<lastPointer;i++){
                if(array[i].compareTo(array[i+1])>0){
                    isSorted=false;
                    swap(i,i+1,array);
                }
            }
            lastPointer--;
        }
    }

    private static <T extends Comparable<T>> void swap(int greaterItem,int smallerItem,T[] array){
        T greater = array[greaterItem];
        array[greaterItem]=array[smallerItem];
        array[smallerItem]=greater;
    }


}

class Test {
    public static void main(String[] args) {
        Integer[] array = {1,3,8,3,28,3,2,1,7,8,4};
        BubbleSort.bubbleSort(array);
        System.out.println(java.util.Arrays.toString(array));
    }

}