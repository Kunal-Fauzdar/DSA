package Tree;
import java.util.ArrayList;

public class MergeBST {
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

    public static ArrayList<Integer> mergeSorted(ArrayList<Integer> sorted1 , ArrayList<Integer> sorted2){
        ArrayList<Integer> finalSorted = new ArrayList<>();
        int i = 0 , j = 0;
        while((i <= sorted1.size()-1) && (j <= sorted2.size()-1)){
            if(sorted1.get(i) < sorted2.get(j)){
                finalSorted.add(sorted1.get(i));
                i++;
            }
            else{
                finalSorted.add(sorted2.get(j));
                j++;
            }
        }
        while(i <= sorted1.size()-1){
            finalSorted.add(sorted1.get(i));
            i++;
        }
        while(j <= sorted2.size()-1){
            finalSorted.add(sorted2.get(j));
            j++;
        }
        return finalSorted;
    }

    public static Node merge(ArrayList<Integer> sorted , int start , int end){
        if(start > end){
            return null;
        }
        int mid = (start+end)/2;
        Node root = new Node(sorted.get(mid));
        root.left = merge(sorted, start, mid-1);
        root.right = merge(sorted, mid+1, end);
        return root;

    }

    public static Node mergeBST(Node root1 , Node root2){
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> sort1 = new ArrayList<>();
        ArrayList<Integer> sort2 = new ArrayList<>();
        getInorder(root1, sort1);
        getInorder(root2, sort2);
        sorted = mergeSorted(sort1, sort2);
        return merge(sorted, 0, sorted.size()-1);
    }

    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        Node mergedRoot = mergeBST(root1, root2);
        System.out.println("Preorder traversal of the merged BST:");
        preorder(mergedRoot);
    }
}