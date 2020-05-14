package leetcode;

/**
 * Challenge: Write a function that reverses a string. You must do this with
 * O(1) extra memory. Time-Complexity of Solution Provided: O(N)
 * Space-Complexity of Solution Provided: O(1)
 */

public class ReverseString {
    public static char[] solution(char[] string) {
        if (string.length == 0)
            return string;
        int lastPointer = string.length - 1;
        int firstPointer = 0;
        while (firstPointer <= lastPointer) {
            char oldFirstPointerValue = string[firstPointer];
            string[firstPointer++] = string[lastPointer];
            string[lastPointer--] = oldFirstPointerValue;
        }
        return string;
    }
}