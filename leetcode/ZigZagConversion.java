package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Challenge: The string "PAYPALISHIRING" is written in a zigzag pattern on a
 * given number of rows like this: 
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR". Write the code that will
 * take a string and make this conversion given a number of rows
 * Time-Complexity of Solution Provided: O(N)
 * Space-Complexity of Solution Provided: O(n)
 */

public class ZigZagConversion {

    public static String convert(String s, int numRows) {

        if (numRows >= s.length() || numRows == 1)
            return s;
        char[] stringAsArray = s.toCharArray();
        int row = 0;
        int step = 0;
        Map<Integer, StringBuilder> mapOfRows = new HashMap<Integer, StringBuilder>();
        for (int index = 0; index < s.length(); index++) {
            if (!mapOfRows.containsKey(row)) {
                mapOfRows.put(row, new StringBuilder());
            }
            StringBuilder rowString = mapOfRows.get(row);
            rowString.append(stringAsArray[index]);
            if (row == 0) {
                step = 1;
            } else if (row == numRows - 1) {
                step = -1;
            }
            row += step;
        }
        StringBuilder result = new StringBuilder();
        mapOfRows.values().forEach(string -> result.append(string));
        return result.toString();
    }

}
