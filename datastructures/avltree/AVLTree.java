package datastructures.avltree;

public class AVLTree{

    private Node root; 
    
    public class Node{
        public int heigth;
        private Integer data;
        public Node left,right;
        private int balanceFactor;

        public Node(int data){
            this.data=data;
        }
        public Node(){}

        public int heigth(){
            if(root==null){
                return 0;
            }
            return root.heigth;    
        }
    }

    public void insert(int data){
        if(root==null){
            root = new Node(data);
            root.heigth=0;
        }else{
            insert(root,data);
            updateBalanceFactor(root);
            root=balanceTree(root);         
        }
    }

    public void insert(Node node, int data){
        if(data<=node.data){
            if(node.left==null){
                Node newNode = new Node(data);
                node.left=newNode;
            }else{
                insert(node.left,data);
            }
            updateBalanceFactor(node.left);
            node.left=balanceTree(node.left);
        }else{
            if(node.right==null){
                Node newNode = new Node(data);
                node.right=newNode;
            }else{
                insert(node.right,data);
            }
            updateBalanceFactor(node.right);
            node.right=balanceTree(node.right);
        }
    }

    public void updateBalanceFactor(Node node){
        int leftChildHeigth = node.left==null ? -1 : node.left.heigth;
        int rightChildHeigth = node.right==null ? -1 : node.right.heigth;

        node.heigth = 1 + Math.max(leftChildHeigth,rightChildHeigth);

        node.balanceFactor = rightChildHeigth - leftChildHeigth;
    }

    public Node balanceTree(Node node){
        if(node.balanceFactor<-1){
            if(node.left.balanceFactor<=0){
                return rightRotation(node);
            }else{
                node.left=leftRotation(node.left);
                return rightRotation(node);
            }
        }else if(node.balanceFactor>1){
            if(node.right.balanceFactor>=0){
                return leftRotation(node);
            }else {
                node.right=rightRotation(node.right);
                return leftRotation(node);
            }
        }
        return node;
    }

    public Node rightRotation(Node node){
        Node newParent = node.left;
        node.left=newParent.right;
        newParent.right=node;
        updateBalanceFactor(newParent);
        updateBalanceFactor(node);
        return newParent;
    }

    public Node leftRotation(Node node){
        Node newParent = node.right;
        node.right=newParent.left;
        newParent.left=node;
        updateBalanceFactor(newParent);
        updateBalanceFactor(node);
        return newParent;
    }

    public void remove(int data){
        if(root!=null){
            root=remove(root,data);
        }
    }

    public Node remove(Node node,int data){
        if(node.data==data){
            if(node.left==null){
                Node rightNode = node.right;
                node.right=null;
                node=null;
                return rightNode;
            }else if(node.right==null){
                Node leftNode = node.left;
                node.left=null;
                node=null;
                return leftNode;
            }else{
                Node maxNode = findMaxNode(node.left);
                node.data=maxNode.data;
                node.left=remove(node.left,maxNode.data);
            }
        }else{
            if(data<node.data){
                node.left=remove(node.left,data);
            }else{
                node.right=remove(node.right,data);
            }
        }
        updateBalanceFactor(node);
        return balanceTree(node); 
    }

    public Node findMaxNode(Node node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
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

    public Node getRoot(){
        return this.root;
    }

}



class Test {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(8);
        tree.insert(4);
        tree.insert(22);
        tree.remove(22);
        tree.remove(8);
        tree.postOrder(tree.getRoot());
        System.out.println(tree.getRoot().heigth);   
    }
}
