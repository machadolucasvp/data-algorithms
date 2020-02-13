package BinarySearchTree;


public class BinarySearchTree{
    private Node root; 

    public class Node{
        private Integer data;
        private Node left,right;

        public Node(int data){
            this.data=data;
        }
        public Node(){}
    }

    public BinarySearchTree(int data){
        root = new Node(data);
    }

    public void insert(int data){
        if(root==null){
            root = new Node(data);
        }else {
            insert(data,root);
        }
     
    }

    public boolean contains(int data){
        if(root==null){
            return false;
        }else{
            return contains(data,root);
        }
       
    }

    public boolean contains(int data,Node node){
        if(data==node.data){
            return true;
        }
        if(data<node.data){
            if(node.left==null){
                return false;
            }else{
                return contains(data,node.left);
            }
        } else{
            if(node.right==null){
                return false;
            }else{
                return contains(data,node.right);
            }
        }
    }


    public void insert(int data,Node node){
        Node currentNode = node;
        if(data<=currentNode.data){
            if(currentNode.left==null){
                currentNode.left= new Node(data);
            }else {
                insert(data,currentNode.left);
            }
        }else{
            if(currentNode.right==null){
                currentNode.right=new Node(data);
            } else {
                insert(data,currentNode.right);
            }
        }
    }
    public Node getRoot(){
        return this.root;
    }

    public void inOrder(Node node){
        if(node.left!=null){
            inOrder(node.left);
        }
        visit(node);
        if(node.right!=null){
            inOrder(node.right);
        }
    }


    public void preOrder(Node node){
        visit(node);
        if(node.left!=null){
            preOrder(node.left);
        }
        if(node.right!=null){
            preOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node.left!=null){
            postOrder(node.left);
        }
        if(node.right!=null){
            postOrder(node.right);
        }
        visit(node);
    }

    public void visit(Node node){
        System.out.println(node.data);
    }
    

/* Alternative way

    public void preOrder(Node node){
        if(node!=null){
            visit(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            visit(Node);
        }
    }
*/
    

}


class Test {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(12);
        tree.insert(8);
        tree.insert(4);
        tree.insert(22);
        tree.preOrder(tree.getRoot());
    }
}