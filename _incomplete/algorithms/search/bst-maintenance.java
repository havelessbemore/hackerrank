//https://www.hackerrank.com/challenges/bst-maintenance
//See: https://www.hackerrank.com/contests/w1/challenges/bst-maintenance
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
        private Node root;
        private long treeDistance;
        
        public Tree(){
            this.root = null;
            this.treeDistance = 0L;
        }
        
        public void add(int value){
            
            if (this.root == null){
                this.root = new Node(value);
                return;
            }
            
            List<Node> parents = new ArrayList<Node>();
            
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
            
            int depth = 0;
            for(int i = parents.size() - 1; i >= 0; --i){
                Node parent = parents.get(i);
                
                parent.distance += ++depth;
                
                this.treeDistance += ((long)depth)*(parent.size - node.size) + (parent.distance - node.distance - node.size);
                
                node = parent;
            }
        }
        
        public long getDistance(){
            return this.treeDistance;
        }
        
        private class Node{
            public Node left;
            public Node right;
            public int size;
            public int value;
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