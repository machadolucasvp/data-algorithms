package BinarySearch;

public class binarySearchString{

    public static int search(String word,String[] array,int low, int high){
       int mean=low+(high-low)/2;
       if(low>high){
           return -1;
       }  else if (word.compareTo(array[mean])==0){
           return mean;
        } else if(word.compareTo(array[mean])<0) {
            return search(word,array,low,mean-1);
       } else {
           return search(word,array,mean+1,high);
       }
    }
}

class Main{
    public static void main(String[] args){
        String[] array = {"aaaa","ab","abc","bbb","","bdd", "dddd", "hhh", "jjj","","oo"};
        System.out.println(binarySearchString.search("oo",array,0,array.length-1));

    }
}
