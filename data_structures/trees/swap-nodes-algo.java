//https://www.hackerrank.com/challenges/swap-nodes-algo
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        
        //I/O
        final StringBuilder sb = new StringBuilder();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Get number of nodes
        final short N = Short.parseShort(br.readLine());
        
        //Create nodes
        final Node[] nodes = new Node[N];
        for(int i = 0; i < N; ++i){
            nodes[i] = new Node(i+1);
        }
        
        //Get children per node
        for(short i = 0; i < N; ++i){
            final String[] line = br.readLine().split(" ");
            final short A = (short)(Short.parseShort(line[0]) - 1);
            final short B = (short)(Short.parseShort(line[1]) - 1);
            nodes[i].left = (A < 0) ? null : nodes[A];
            nodes[i].right = (B < 0) ? null : nodes[B];
        };
        
        //For each swap operation...
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get swap interval
            final short K = Short.parseShort(br.readLine());
            swap(nodes[0], K);
            
            //Print output
            printInorder(nodes[0], sb);
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static void swap(final Node node, final short K){
        swap(node, K, (short)1);
    }
    
    private static void swap(final Node node, final short K, short depth){
        if(node == null){
            return;
        }
        if(depth == K){
            depth = 0;
            Node t = node.left;
            node.left = node.right;
            node.right = t;
        }
        swap(node.left, K, ++depth);
        swap(node.right, K, depth);
    }
    
    private static void printInorder(final Node node, final StringBuilder sb){
        if(node != null){
            printInorder(node.left, sb);
            sb.append(node.val + " ");
            printInorder(node.right, sb);
        }
    }
    
    private static class Node {
        public Node left;
        public Node right;
        public final int val;
        public Node(final int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
