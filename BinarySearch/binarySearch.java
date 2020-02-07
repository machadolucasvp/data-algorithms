package BinarySearch;

public class binarySearch{

    public static int search(int value,int[] array,int low, int high){
       int mean=low+(high-low)/2;
       if(low>high){
           return -1;
       }  else if (value==array[mean]){
           return value;
        } else if(value<array[mean]) {
            return search(value,array,low,mean-1);
       } else {
           return search(value,array,mean+1,high);
       }
    }
}

class Test{
    public static void main(String[] args){
        int[] array = new int[]{1,3,4,9,12};
        System.out.println(binarySearch.search(15,array,0,array.length-1));

    }
}
