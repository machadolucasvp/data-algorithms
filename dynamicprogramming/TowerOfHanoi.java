package dynamicprogramming;

import java.util.Stack;

/**
 * Challenge: You have 3 towers and N disks of different sizes which can slide
 * onto any tower. The puzzle starts with disks sorted in ascending order of
 * size from top to bottom (i.e., each disk sits on top of an even larger one).
 * You have the following constraints: Only one disk can be moved at a time. A
 * disk is slid off the top of one tower onto another tower. A disk cannot be
 * placed on top of a smaller disk. Write a program to move the disks from the
 * first tower to the last using Stacks. 
 * Time-Complexity of Solution Provided: O(2^n) 
 * Space-Complexity of Solution Provided: O(n)
 */

public class TowerOfHanoi {
    public static void moveDisks(int n, Stack<Integer> source, Stack<Integer> destination, Stack<Integer> auxiliar){
        if(n==0){return;}

        moveDisks(n-1,source,auxiliar,destination);

        moveTop(source,destination);

        moveDisks(n-1,auxiliar,destination,source);       
    }

    private static void moveTop(Stack<Integer> source, Stack<Integer> destination){
        destination.push(source.pop());
    }

}


