package Tree;

import java.util.ArrayList;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root , int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data>val){
            root.left = insert(root.left, val);
        }
        else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root , int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left, key);
        }
        return search(root.right, key);
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
        return root;
    }
    //printing in range
    //like for 6-18
    public static void printInRange(Node root , int k1 , int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if(root.data < k1){
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (Integer integer : path) {
            System.out.print(integer+"->");
        }
        System.out.println("Null");
    }

    //print root to leaf path
    public static void printRootToLeaf(Node root , ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);
        path.remove(path.size()-1);
    }

    //validate BST Tree 
    public static Boolean validateBST(Node root, Node min , Node max){
        if(root == null){
            return true;
        }
        else if(min != null && root.data > min.data){
            return false;
        }
        else if(max != null && root.data > max.data){
            return false;
        }

        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }
    
    // mirror a BST Tree
    public static Node mirrorBST(Node root ){
        if(root == null){
            return null;
        }
        Node left = mirrorBST(root.left);
        Node right = mirrorBST(root.right);
        root.left = right;
        root.right = left;
        return root;

    }

    //create a balanced BST(basically with minimum height) from sorted array
    public static Node balancedBST(int[] sortedElements , int start , int end) {
        if(start > end){
            return null;
        }
        int mid = (start+end) / 2;
        Node root = new Node(sortedElements[mid]);
        root.left = balancedBST(sortedElements, start, mid-1);
        root.right = balancedBST(sortedElements, mid+1, end);
        return root;
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] values = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0 ; i<values.length ; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println(search(root, 4));

        delete(root, 8);
        System.out.println();
        inorder(root);

        System.out.println();

        printInRange(root, 9, 10);
        System.err.println();

        printRootToLeaf(root , new ArrayList<Integer>());

        mirrorBST(root);
        inorder(root);
        System.out.println();

        int[] sortedValues = {3,5,7,8,9,10,12,15};
        Node balancedBSTRoot = balancedBST(sortedValues, 0, sortedValues.length-1);
        preorder(balancedBSTRoot);
        System.out.println();
    }
}
