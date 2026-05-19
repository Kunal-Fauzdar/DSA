package Tree;

import java.util.ArrayList;

public class convertBSTToBalanced {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
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

    public static void getInorder(Node root , ArrayList<Integer> sorted){
        if(root == null){
            return ;
        }
        getInorder(root.left, sorted);
        sorted.add(root.data);
        getInorder(root.right, sorted);
    }

    public static Node toBalancedBST(ArrayList<Integer> sorted , int start , int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(sorted.get(mid));
        root.left = toBalancedBST(sorted, start, mid-1);
        root.right = toBalancedBST(sorted, mid+1, end);
        return root;

    }

    public static Node BSTtoBalancedBST(Node root){
        ArrayList<Integer> sorted = new ArrayList<>();
        getInorder(root, sorted);
        return toBalancedBST(sorted, 0, sorted.size()-1);
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        root = BSTtoBalancedBST(root);
        preorder(root);
    }
}
