package DoublyList;

import java.util.Optional;

public class DoublyList<T> {
    private Node<T> head;
    private Node<T> tail;

    private class Node<E>{
        Node<E> next;
        Node<E> prev;
        E data;
        public Node(E data){
            this.data=data;
        }
    }

    public DoublyList(T data){
        head = new Node<T>(data);
        tail=head;
    }

    public void append (T data){
        if(head==null){
            head=new Node<T>(data);
            tail=head;
        }
        Node<T> node = head;
        while(node.next!=null){
            node = node.next;
        }
        Node<T> newNode = new Node<T>(data);
        node.next=newNode;
        newNode.prev=node;
        tail=newNode;
    }

    public void delete(T data){
        Node<T> node = head;
        while(node.next.data!=data){
            if(node.next.next==null){
                break;
            }
            node = node.next;
        }
        if(node.next.data==data){
            node.next.prev=null;
            node.next=node.next.next;
            node.next.prev=node;
            if(node.next.next==null){
                tail=node.next.next;
            }
        }
    }

    public boolean contains(T data){
        Node<T> node = head;
        while(node.next.data!=data){
            if(node.next.next==null){
                break;
            }
            node = node.next;
        }
        if(node.next.data==data){
            return true;
        } else {
            return false;
        }
    }

    public Optional<Node<T>> getNode(T data){
        Node<T> node = head;
        while(node.next.data!=data){
            node = node.next;
            if(node.next==null){
                break;
            }
        }
        return Optional.of(node.next);
    }

    public T getHead(){
        return this.head.data;

    }

    public T getTail(){
        return this.tail.data;
    }


}


class Test {
    public static void main(String[] args) {
        DoublyList<Integer> list = new DoublyList<Integer>(24);
        list.append(25);
        list.append(26);
        System.out.println(list.contains(25));
 
    }
}