package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class questions {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes ){
            idx ++;
            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes );
            newNode.right = buildTree(nodes );

            return newNode;
        }
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void levelorder(Node root){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }
        //q1 check if a tree is univalued ?
        static int value = 0;
        public static boolean univalued(Node root){
            if(root == null){
                return true;
            }
            boolean leftcheck = univalued(root.left);
            boolean rigthcheck = univalued(root.right);
            if(leftcheck && rigthcheck && root.data == value){
                return true;
            }
            return false;
        }
        public static void invert(Node root ){
            if(root == null){
                return;
            }
            invert(root.left);
            invert(root.right);
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        public static Node deleteLeafNode(Node root , int k){
            if(root == null){
                return null;
            }
            root.left = deleteLeafNode(root.left, k);
            root.right = deleteLeafNode(root.right, k);
            if(root.left == null && root.right == null && root.data == k){
                return null;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.idx = -1;
        BinaryTree.value = root.data; 
        System.out.println(BinaryTree.univalued(root));
        BinaryTree.levelorder(root);
        // BinaryTree.invert(root);
        // BinaryTree.levelorder(root);
        BinaryTree.deleteLeafNode(root, 4);
        BinaryTree.levelorder(root);

    }
}

