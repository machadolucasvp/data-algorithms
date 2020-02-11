package StackAndQueue;

import java.util.LinkedList;

public class Queue <T>{

    private LinkedList<T> queue;

    public Queue(){this.queue = new LinkedList<T>();}
    
    public Queue(T data){
        this.queue = new LinkedList<T>();
        queue.addFirst(data);
    }

    public int size(){
        return queue.size();
    }

    public void enqueue(T data){
        queue.addLast(data);
    }

    public T dequeue(){
        if(!queue.isEmpty()){
            return queue.removeFirst();
        } else {
            throw new RuntimeException("Queue Empty");
        }
    }

    public T peek(){
        if(!queue.isEmpty()){
            return queue.getFirst();
        } else {
            throw new RuntimeException("Queue Empty");
        }
    }

    public boolean isEmpty(){
        return queue.isEmpty() ? true : false;
    }

}