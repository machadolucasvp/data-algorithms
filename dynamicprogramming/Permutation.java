package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Challenge: Given a collection of numbers that not contain duplicates, return
 * all possible unique permutations. 
 * Time-Complexity of Solution Provided: O(n*n!) 
 * Space-Complexity of Solution Provided: ?
 */

public class Permutation {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutations(new ArrayList<>(), array, result);
        return result;
    }

    private static void getPermutations(List<Integer> prefix, List<Integer> suffix, List<List<Integer>> result) {
        while (!suffix.isEmpty()) {
            for (int i = 0; i < suffix.size(); i++) {
                List<Integer> mergedPrefix = new ArrayList<>();
                mergedPrefix.addAll(prefix);
                mergedPrefix.add(suffix.get(i));
                List<Integer> mergedSuffix = new ArrayList<>();
                mergedSuffix.addAll(suffix.subList(0, i));
                mergedSuffix.addAll(suffix.subList(i + 1, suffix.size()));

                getPermutations(mergedPrefix, mergedSuffix, result);
            }
            return;
        }
        result.add(prefix);
    }
}

class Test {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.addAll(Arrays.asList(1, 2, 3));
        System.out.println(Permutation.getPermutations(array));
    }
}
