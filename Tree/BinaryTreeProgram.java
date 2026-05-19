package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeProgram {
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
        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        public static void postorder(Node root){
            if(root == null){
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
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

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }
        public static int count(Node root){
            if(root == null){
                return 0;
            }
            int left_count = count(root.left);
            int right_count = count(root.right);
            return left_count + right_count + 1;
        }
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int left_sum = sumOfNodes(root.left);
            int right_sum = sumOfNodes(root.right);
            return left_sum + right_sum + root.data;
        }

        //Diameter :- longest path between 2 nodes in a tree 
        //approach-1 O(n^2)
        public static int diameterFirst(Node root){
            if(root == null){
                return 0;
            }
            int left_diameter = diameterFirst(root.left);
            int right_diameter = diameterFirst(root.right);
            int left_height = height(root.left);
            int right_height = height(root.right);
            int current_diameter = left_height+right_height+1;
            return Math.max(current_diameter , Math.max(left_diameter,right_diameter));
        }
        //approach-2 O(n)
        static class Info{
            int diameter;
            int height;
            Info(int diameter,int height){
                this.diameter = diameter;
                this.height = height;
            }
        }
        public static Info diameterSecond(Node root ){
            if(root == null){
                return new Info(0,0);
            }
            Info leftInfo = diameterSecond(root.left);
            Info rightInfo = diameterSecond(root.right);
            int myDiameter = Math.max(Math.max(leftInfo.diameter,rightInfo.diameter),(leftInfo.height+rightInfo.height+1));
            return new Info(myDiameter, Math.max(leftInfo.height,rightInfo.height)+1);
        }
        public static boolean isIdentical(Node matchedNode,Node subroot){
            if(matchedNode== null && subroot == null ){
                return true;
            }
            else if(matchedNode == null || subroot == null || matchedNode.data != subroot.data){
                return false;
            }
            return isIdentical(matchedNode.left, subroot.left) && isIdentical(matchedNode.right, subroot.right);
        }
        public static boolean subtree(Node root , Node subroot){
            if(root == null){
                return false;
            }
            if(root.data == subroot.data){
                if(isIdentical(root,subroot)){
                    return true;
                }
            }
            return subtree(root.left, subroot) || subtree(root.right, subroot);
        }

    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.idx = -1;
        System.out.println(root.data);
        // Binarytree.preorder(root);
        // Binarytree.inorder(root);
        // BinaryTree.postorder(root);
        BinaryTree.levelorder(root);
        System.out.println(BinaryTree.height(root));
        System.out.println(BinaryTree.count(root));
        System.out.println("Sum is : "+BinaryTree.sumOfNodes(root));
        //System.out.println("Diameter is : "+BinaryTree.diameterFirst(root));
        System.out.println("Diameter is : "+BinaryTree.diameterSecond(root).diameter);
        int[] subtree_nodes = {3,-1,6,-1,7,-1,-1};
        Node subroot = BinaryTree.buildTree(subtree_nodes);
        System.out.println("is Subtree : "+BinaryTree.subtree(root, subroot));

    }
}
