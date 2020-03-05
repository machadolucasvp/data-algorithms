package dynamicprogramming;

public class Fibonnaci {

    public static int topDown(int n){
        return topDown(n,new Integer[n+1]);
    }

    private static int topDown(int n, Integer[] memo) {
        if (memo[n] != null) {
            return memo[n];
        } else if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            memo[n] = topDown(n - 1, memo) + topDown(n - 2, memo);
        }
        return memo[n];
    }

    public static int bottomUp(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        } else {
            Integer[] bottomUp = new Integer[n];
            bottomUp[0] = 0;
            bottomUp[1] = 1;
            for (int i = 2; i < n; i++) {
                bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
            }
            return bottomUp[n - 1] + bottomUp[n - 2];

        }

    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Fibonnaci.topDown(20));
        System.out.println(Fibonnaci.bottomUp(20));

    }
}
