package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Challenge: Write a method to return all subsets of a set
 * Time-Complexity of Solution Provided: O(n*2^n)
 * Space-Complexity of Solution Provided: O(n*2^n)
 */

public class PowerSet {
    public static List<List<Integer>> powerSetOf(int[] array) {
        List<List<Integer>> subsets = findAllSubsets(array, 0);
        return subsets;
    }

    private static List<List<Integer>> findAllSubsets(int[] set, int index) {
        List<List<Integer>> subsets = new ArrayList<>();

        if (set.length == index) {
            subsets.add(new ArrayList<Integer>());
        } else {
            subsets = findAllSubsets(set, index + 1);
            Integer currentValue = set[index];
            List<List<Integer>> iterableArray = new ArrayList<>();

            for (List<Integer> subset : subsets) {
                List<Integer> newSubset = new ArrayList<Integer>();
                newSubset.add(currentValue);
                newSubset.addAll(subset);
                iterableArray.add(newSubset);
            }
            subsets.addAll(iterableArray);

        }
        return subsets;

    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 7, 5, 3 };
        System.out.println(PowerSet.powerSetOf(nums));
    }
}
