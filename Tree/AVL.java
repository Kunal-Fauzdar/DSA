package Tree;

public class AVL {
    static class Node{
        int data , height ;
        Node left , right ;
        Node(int data){
            this.data = data;
            this.height = 1;
        }
    }

    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }

    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node leftRotate(Node root){
        Node rightNode = root.right;
        root.right = rightNode.left;
        rightNode.left = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        rightNode.height = Math.max(height(rightNode.left), height(rightNode.right)) + 1;
        return rightNode;
    }

    public static Node rightRotate(Node root){
        Node leftNode = root.left;
        root.left = leftNode.right;
        leftNode.right = root;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        leftNode.height = Math.max(height(leftNode.left), height(leftNode.right)) + 1;
        return leftNode;
    }

    public static Node insert(Node root , int data){
        if(root == null){
            return new Node(data);
        }
        else if(data > root.data){
            root.right = insert(root.right, data);
        }
        else if(data < root.data){
            root.left = insert(root.left, data);
        }
        else{
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right))+1;

        int balance = getBalance(root);

        if(balance > 1  && root.left.data > data){
            return rightRotate(root);
        }

        else if(balance > 1  && root.left.data < data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        else if(balance < -1  && root.right.data < data){
            return leftRotate(root);   
        }

        else if(balance < -1  && root.right.data > data){
            root.right = rightRotate(root.right);
            return leftRotate(root);   
        }
        return root;
    }


    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public static Node delete(Node root , int key){
        if(root.data>key){
            root.left = delete(root.left, key);
        }
        if(root.data<key){
            root.right = delete(root.right, key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left == null){
                return root.right; 
            }
            else if(root.right == null){
                return root.left;
            }
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        root.height = Math.max(height(root.left), height(root.right))+1;

        int balance = getBalance(root);
        //LL
        if(balance > 1  && getBalance(root.right)>=0){
            return rightRotate(root);
        }
        //LR
        else if(balance > 1  && getBalance(root.left) < 0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RR
        else if(balance < -1  && getBalance(root.right) <= 0){
            return leftRotate(root);   
        }
        //RL
        else if(balance < -1  && getBalance(root.right) > 0){
            root.right = rightRotate(root.right);
            return leftRotate(root);   
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);
        System.out.println();
        System.out.println("after deletion : ");
        root = delete(root, 40);
        preorder(root);
    }
}
