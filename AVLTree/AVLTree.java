package AVLTree;

public class AVLTree{

    private Node root; 
    
    public class Node{
        private int heigth;
        private Integer data;
        private Node left,right;
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
                balanceTree(node.right);
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
        return newParent;
    }
    public Node leftRotation(Node node){
        Node newParent = node.right;
        node.right=newParent.left;
        newParent.left=node;
        return newParent;
    }

}


/* Alternative Way
    public void insertOPT(int data){
        root=insertOPT(root,data);
    }

    public Node insertOPT(Node node,int data){
        if(node==null){
            node=new Node(data);
        }else{
            if(data<=node.data){
                node.left = insertOPT(node.left,data);
            }else{
                node.right = insertOPT(node.right,data);
            }
        }
        return node;
    }
*/
