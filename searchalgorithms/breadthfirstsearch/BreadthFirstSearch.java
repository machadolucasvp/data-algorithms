package searchalgorithms.breadthfirstsearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch<T> {
    Node head;

    private class Node {
        private T data;
        List<Node> children;

        public Node(T data) {
            this.data = data;
        }
    }

    public void bfsTraversal() {
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.add(head);
        }
        while (queue.peek() != null) {
            Node current = queue.remove();
            visit(current);
            List<Node> childrens = current.children;
            for (int i = 0; i < childrens.size(); i++) {
                Node children = childrens.get(i);
                if (children != null) {
                    queue.add(children);
                }
            }

        }
    }

    public void visit(Node node) {
        System.out.println(node.data);
    }

}