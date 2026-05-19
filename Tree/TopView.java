package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
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


        static class Info{
            Node root;
            int horizontal_dist;
            Info(Node root , int horizontal_dist){
                this.root = root;
                this.horizontal_dist = horizontal_dist;
            }
        }
        public static void topview(Node root){
            //Level Order
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer , Node> hm = new HashMap<>();
            int min = 0, max = 0;
            q.add(new Info(root, 0));
            q.add(null);
            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null){
                    if(!q.isEmpty()){
                        q.add(null);
                    }
                    else{
                        break;
                    }
                }
                else{
                    if(!hm.containsKey(curr.horizontal_dist)){
                        hm.put(curr.horizontal_dist,curr.root);
                    }
                    if(curr.root.left != null){
                        q.add(new Info(curr.root.left,curr.horizontal_dist-1));
                        min = Math.min(min,curr.horizontal_dist-1);
                    }
                    if(curr.root.right != null){
                        q.add(new Info(curr.root.right,curr.horizontal_dist+1));
                        max = Math.max(max,curr.horizontal_dist+1);
                    }
                }
            }
            for (int i=min ; i<=max ; i++){
                System.out.print(hm.get(i).data+" ");
            }
        }
        public static void KLevel(Node root ,int level ,int k){
            if(root == null){
                return ;
            }
            if(level == k){
                System.out.print(root.data+" ");
                return;
            }
            KLevel(root.left, level+1, k);
            KLevel(root.right, level+1, k);
        }
        public static Node lca(Node root , int n1 , int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node leftlca = lca(root.left, n1, n2);
            Node rightlca = lca(root.right, n1, n2);

            if(leftlca == null){
                return rightlca;
            }
            if(rightlca == null){
                return leftlca;
            }
            
            return root;
        }
        public static int lcaDist(Node root , int k){
            if(root == null){
                return -1;
            }
            if(root.data == k){
                return 0;
            }
            int leftdist = lcaDist(root.left, k);
            int rightdist = lcaDist(root.right, k);
            if(leftdist == -1 && rightdist == -1){
                return -1;
            }
            if(leftdist == -1){
                return (rightdist+1) ;
            }
            return (leftdist+1) ;
            
        }
        public static int minDist(Node root , int n1 , int n2) {
            Node lca = lca(root, n1, n2);
            int distn1 = lcaDist(lca, n1);
            int distn2 = lcaDist(lca, n2);
            return distn1+distn2;
        }
        //n value and kth ancestor
        public static int KAncestor(Node root , int n , int k){
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 1;
            }
            int leftdist = KAncestor(root.left, n, k);
            int rightdist = KAncestor(root.right, n, k);
            if(leftdist == -1 && rightdist == -1){
                return -1;
            }
            if(leftdist == -1){
                if(rightdist == k){
                    System.out.println(root.data);
                }
                return rightdist+1;
            }
            if(leftdist == k){
                    System.out.println(root.data);
                }
                return leftdist+1;
        }
        //Sum tree
        //every node containing sum of its all children
        public static int transform(Node root){
            if(root == null){
                return 0;
            }
            int leftchild = transform(root.left);
            int rightchild = transform(root.right);

            int data = root.data;
            
            root.data = leftchild + (root.left == null ? 0 : root.left.data) + rightchild + (root.right == null ? 0 : root.right.data);
            
            //leftchild returns left node data and root.left.data contains sum of 
            //all children of left
            //at every node we change data to sum of all children and return data of current node
            return data;
        }
    }

    
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,7,-1,-1};
        Node root = BinaryTree.buildTree(nodes);
        BinaryTree.idx = -1;
        BinaryTree.levelorder(root);
        System.out.println();
        // BinaryTree.topview(root);
        int k = 3;
        // BinaryTree.KLevel(root,1,k);
        // System.out.println(BinaryTree.lca(root, 4, 5).data);
        int n1=4 , n2 = 6;
        // System.out.println(BinaryTree.minDist(root, n1, n2));
        // BinaryTree.KAncestor(root, 4, 1);
        BinaryTree.transform(root);
        BinaryTree.levelorder(root);
    }
}
