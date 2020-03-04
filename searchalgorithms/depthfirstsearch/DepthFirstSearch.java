package searchalgorithms.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch<T> {

    Node root;

    public class Node {
        private T data;
        List<Node> children = new ArrayList<>();

        public Node(T data) {
            this.data = data;
        }
        public Node addChildren(T data){
            Node node = new Node(data);
            children.add(node);
            return node;
        }
    }

    public DepthFirstSearch(T data){
        root= new Node(data);
    }

    public void dfsTraversal(){
        Stack<Node> stack = new Stack<>();
        if(root!=null){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            Node current = stack.pop();
            visit(current);
            for(int i=current.children.size()-1;i>=0;i--){
                stack.push(current.children.get(i));
            }
        }
    }

    public void visit(Node node) {
        System.out.println(node.data);
    }

    
}

class Test {
    public static void main(String[] args) {
        /*      1
               / \
              3   9
             / \   \
            4   5   11
        */
        DepthFirstSearch<Integer> treeSearch = new DepthFirstSearch<Integer>(1);
        DepthFirstSearch<Integer>.Node firstRootChild = treeSearch.root.addChildren(3);
        DepthFirstSearch<Integer>.Node firstFirst = firstRootChild.addChildren(4);
        DepthFirstSearch<Integer>.Node secondFirst = firstFirst.addChildren(5);
        DepthFirstSearch<Integer>.Node secondRootChild=treeSearch.root.addChildren(9);
        DepthFirstSearch<Integer>.Node firstSecond=secondRootChild.addChildren(11);

        treeSearch.dfsTraversal();
    }
}