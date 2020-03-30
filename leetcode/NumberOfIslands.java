package leetcode;

/**
 * Challenge: Given a 2d grid map of '1's (land) and '0's (water), count the
 * number of islands. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four
 * edges of the grid are all surrounded by water. 
 * For complexity analysis: M is amount of rows and N of columns
 * Time-Complexity of Solution Provided: O(MxN) 
 * Space-Complexity of Solution Provided: O(MxN)
 */

public class NumberOfIslands {

    public static int solution(char[][] matrix) {
        if (matrix.length == 0 || matrix == null)
            return 0;
        int numberOfIslands = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    numberOfIslands += dfs(matrix, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private static int dfs(char[][] matrix, int x, int y) {
        if (x >= matrix.length || x < 0 || y >= matrix[x].length || y < 0)
            return 0;
        if (matrix[x][y] == '0')
            return 0;

        matrix[x][y] = '0';
        dfs(matrix, x + 1, y);
        dfs(matrix, x - 1, y);
        dfs(matrix, x, y + 1);
        dfs(matrix, x, y - 1);

        return 1;
    }
}

class Test {
    public static void main(String[] args) {
        char[][] matrix = { { '1' }, { '1' } };
        int number = NumberOfIslands.solution(matrix);
        System.out.println(number);
    }
}
