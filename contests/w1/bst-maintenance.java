//Week 1, Friday
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
            
            //Insert node if empty
            if (this.root == null){
                this.root = new Node(value);
                return;
            }
            
            //Hold path from root node to parent node
            List<Node> parents = new ArrayList<Node>();
            
            //Find where to place the node
            Node node = this.root;
            do {
                
                node.size++;
                parents.add(node);
                
                if (value < node.value){
                    if (node.left == null){
                        node = node.left = new Node(value);
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null){
                        node = node.right = new Node(value);
                        break;
                    }
                    node = node.right;
                }
                
            } while (true);
            
            //From parent node to root
            int depth = 0;
            for(int i = parents.size() - 1; i >= 0; --i){
                Node parent = parents.get(i);
                
                //Update parent distance with distance to node
                parent.distance += ++depth;
                
                //Update tree distance with:
                //    Distance from node to parent * the number of nodes in sibling subtree
                //    Sum of distance from sibling subtree
                this.treeDistance += ((long)depth)*(parent.size - node.size) + (parent.distance - node.distance - node.size);
                
                //Move up the tree
                node = parent;
            }
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