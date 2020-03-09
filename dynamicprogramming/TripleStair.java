package dynamicprogramming;

/**
 * Challenge: You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1, 2 or 3 steps. 
 * In how many distinct ways can you climb to the top?
 * Time-Complexity of Solution Provided: O(n)
 * Space-Complexity of Solution Provided: O(n)
 */

public class TripleStair {
    public static int SolveStaircase(int n) {
        return topDownStair(n, new int[n + 1]);
    }

    private static int topDownStair(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        } else if (n == 0) {
            return n;
        } else if (n == 1) {
            return n;
        } else if (n == 2) {
            return n;
        }
        memo[n] = topDownStair(n - 1, memo) + topDownStair(n - 2, memo) + topDownStair(n - 3, memo);
        return memo[n];
    }
}