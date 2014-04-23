//https://www.hackerrank.com/challenges/xor-key
import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //For each test
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){

            //Get input
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int Q = Integer.parseInt(temp[1]);
            short[] ar = new short[N]; 
            temp = br.readLine().split(" ");
            for(int i = 0; i < N; i++){
                ar[i] = Short.parseShort(temp[i]);
            }

            //Initialize xor tree
            XorTree tree = new XorTree((byte)Short.SIZE);
            for(int i = 0; i < N; ++i){
                //tree.add(i, ar[i]);
            }

            //For each query
            for(int i = 0; i < Q; i++){

            	//Get input
                temp = br.readLine().split(" ");
                short a = Short.parseShort(temp[0]);
                int p = Integer.parseInt(temp[1]) - 1;
                int q = Integer.parseInt(temp[2]) - 1;

                //Get max xor value
                //short max = (short)tree.maxXor(a, p, q);

                //Output
                //sb.append(max + "\n");
            }
        }
        System.out.print(sb);
    }

    private static class XorTree{
        private Node root;
        private byte numBits;

        public XorTree(byte numBits){
            this.root = null;
            this.numBits = numBits;
        }

        public void add(int index, int val){
            this.root = add(index, val, this.root, this.numBits);
        }

        private Node add(int index, int val, Node node, byte bit){
            if (node == null){
                node = new Node();
            }
            node.add(index);
            if (--bit >= 0){
                if (((val >> bit) & 1) == 1){
                    node.one = add(index, val, node.one, bit);
                } else {
                    node.zero = add(index, val, node.zero, bit);
                }
            }
            return node;
        }

        public int maxXorInRange(int n, int minIndex, int maxIndex){
            return  this.root == null ||
                    !this.root.hasIndexInRange(minIndex, maxIndex) ?
                    -1 :
                    maxXorInRange(n, minIndex, maxIndex, this.root, this.numBits, 0);
        }

        private int maxXorInRange(int n, int minIndex, int maxIndex, Node node, byte bit, int xor){
            if (--bit < 0){
                return xor;
            }
            if (((n >> bit) & 1) == 0){
                return node.one.hasIndexInRange(minIndex, maxIndex) ?
                    maxXorInRange(n, minIndex, maxIndex, node.one, bit, xor) :
                    maxXorInRange(n, minIndex, maxIndex, node.zero, bit, xor);
            } else {
                return node.zero.hasIndexInRange()
            }
                if (node.one.hasIndexInRange(minIndex, maxIndex)){
                    return maxXorInRange(n, minIndex, maxIndex, node.one, bit, xor);
                } else if (node.zero.hasIndexInRange(minIndex, maxIndex)){

                } else {
                    return -1;
                }
            } else if (node.zero.hasIndexInRange(minIndex, maxIndex)){

            } else if (node.one.hasIndexInRange(minIndex, maxIndex)){

            } else {
                return -1;
            }
        }
    }
}