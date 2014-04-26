//https://www.hackerrank.com/contests/w1/challenges/bst-maintenance
import java.io.*;
import java.util.*;
 
public class Solution{
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        N = 0;
        for(String a : br.readLine().split(" ")){
            A[N++] = Integer.parseInt(a);
        }
        
        Tree tree = new Tree();
        for(int a : A){
            tree.add(a);
            sb.append(tree.getDistance() + "\n");
        }
        
        System.out.print(sb);
    }
    public static class Tree{
        //The root of the tree
        private Node root;
        //The sum of distances from each node to every other node
        private long treeDistance;
        
        public Tree(){
            this.root = null;
            this.treeDistance = 0L;
        }
        
        public void add(int value){
            //Hold path from direct parent to root node
            List<Node> parents = new ArrayList<Node>();
            //Hold siblings at each depth from same depth to depth 1
            List<Node> siblings = new ArrayList<Node>();
            
            //Add the new value
            this.root = add(this.root, value, parents, siblings);
            
            //For each depth
            int size = parents.size();
            for(int i = 0; i < size; ++i){
                Node parent = parents.get(i);
                Node sibling = siblings.get(i);
                int depth = i+1;
                
                //Update parent distance with distance to node
                parent.distance += depth;
                
                //Update tree distance with:
                //    Distance from node to parent
                //    Distance from node to sibling * the number of nodes in sibling subtree
                //    Sum of distance from sibling node to every subnode
                this.treeDistance += sibling == null ? depth : depth + ((long)(depth+1))*sibling.size + sibling.distance;
            }
        }
        
        private Node add(Node node, int value, List<Node> parents, List<Node> siblings){
            if (node == null){
                return new Node(value);
            }
            
            if (value < node.value){
                node.left = add(node.left, value, parents, siblings);
                siblings.add(node.right);
            } else {
                node.right = add(node.right, value, parents, siblings);
                siblings.add(node.left);
            }
            
            node.size++;
            parents.add(node);
            
            return node;
        }
        
        public long getDistance(){
            return this.treeDistance;
        }
        
        private class Node{
            //Nodes less than value
            public Node left;
            //Nodes greater than value
            public Node right;
            //The size of the subtree, including itself
            public int size;
            //The value for this node
            public int value;
            //The sum of distances from this node to all nodes in subtree 
            public long distance;
            
            public Node(int value){
                this.value = value;
                this.left = null;
                this.right = null;
                this.size = 1;
                this.distance = 0L;
            }
        }
    }
}