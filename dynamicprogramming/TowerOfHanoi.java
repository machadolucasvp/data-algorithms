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
 * Space-Complexity of Solution Provided: O(1)
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


class Test {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        TowerOfHanoi.moveDisks(stack1.size(), stack1, stack3, stack2);
        for (Integer object : stack3){
            System.out.println(object+"\n");
        }
    }
}
