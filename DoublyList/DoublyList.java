package DoublyList;

import java.util.Optional;

public class DoublyList<T> {
    private T data;
    private DoublyList<T> next;
    private DoublyList<T> prev;
    private DoublyList<T> head;

    public DoublyList(T data){
        this.data=data;
    }

    public void append (T data){
        if(head==null){
            head=new DoublyList<T>(data);
        }
        DoublyList<T> node = head;
        while(node.next!=null){
            node = node.next;
        }
        DoublyList<T> newNode = new DoublyList<T>(data);
        node.next=newNode;
        newNode.prev=node;
    }
    public void delete(T data){
        DoublyList<T> node = head;
        while(node.next.data!=data){
            node = node.next;
        }
        node.next.prev=null;
        node.next=node.next.next;
        node.next.prev=node;
    }
    public boolean contains(T data){
        DoublyList<T> node = head;
        while(node.next!=null || node.next.data!=data){
            node = node.next;
        }
        if(node.next.data!=null){
            return true;
        } else {
            return false;
        }
    }

    public Optional<DoublyList<T>> getNode(T data){
        DoublyList<T> node = head;
        while(node.next!=null || node.next.data!=data){
            node = node.next;
        }
        if(node.next.data!=null){
            return Optional.of(node.next);
        } else {
            return Optional.of(node.next);
        }
    }

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data=data;
    }
    

}