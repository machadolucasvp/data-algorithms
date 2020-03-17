package sortingalgorithms;

public class InsertionSort {

    public static void sort(int[] array){
        for(int i=0; i<array.length; i++){
            int j=i;
            while((j>0 && array[j-1]>array[i])){
                array[j]=array[j-1];
                j--;
            }
            array[j]=array[i];
        }
    }

}


class Test {
    public static void main(String[] args) {
        int[] array = {1,9,3,20,30,2,1};
        InsertionSort.sort(array);
        System.out.println(array);
    }
}
