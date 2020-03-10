package dynamicprogramming;

/**
 * Challenge: A fixed point or magic index in a array is defined to be an index
 * such that a[i]=i. Write a method to return a magic index, if one exists, for
 * a sorted and not distinct array of integers. 
 * Time-Complexity of Solution Provided: O(log n) 
 * Space-Complexity of Solution Provided: O(1)
 */

public class MagicIndex {
    public static int getMagicIndex(int[] array) {
        return getMagicIndex(array, 0, array.length - 1);
    }

    private static int getMagicIndex(int[] array, int initial, int last) {
        if (initial > last) {
            return -1;
        }
        int half = initial + (last - initial) / 2;
        if (array[half] == half) {
            return half;
        }
        int leftMagic = getMagicIndex(array, initial, array[half]);
        if (leftMagic != -1) {
            return leftMagic;
        }
        int rightMagic = getMagicIndex(array, array[half], last);
        return rightMagic;
    }
}

class Test {
    public static void main(String[] args) {
        int[] array = new int[] { - 10 , 2 , 3, 3, 4, 9, 12 };
        System.out.println(MagicIndex.getMagicIndex(array));
    }
}
