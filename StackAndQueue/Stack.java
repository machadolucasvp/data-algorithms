package StackAndQueue;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T>{

    private LinkedList<T> stack;

    public Stack(){
        this.stack=new LinkedList<T>();
    }

    public void push(T data){
        stack.addFirst(data);
    }

    public T pop(){
        if (!isEmpty()){
            return stack.removeFirst();
        } else {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty(){
        return stack.isEmpty() ? true : false;
    }

    public int size(){
        return stack.size();
    }

    public T peek(){
        if(!isEmpty()){
            return stack.getFirst();
        } else {
            throw new EmptyStackException();
        }
    }
    
}
