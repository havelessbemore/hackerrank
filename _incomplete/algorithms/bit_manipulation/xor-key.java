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
                tree.add(i, ar[i]);
            }

            //For each query
            for(int i = 0; i < Q; i++){

                //Get input
                temp = br.readLine().split(" ");
                short a = Short.parseShort(temp[0]);
                int p = Integer.parseInt(temp[1]) - 1;
                int q = Integer.parseInt(temp[2]) - 1;

                //Get max xor value
                short max = (short)tree.maxXor(a, p, q);

                //Output
                sb.append(max + "\n");
            }
        }
        System.out.print(sb);
    }

    private static class XorTree{
        private Node root;
        private byte numBits;
        private long[] bitMasks;

        public XorTree(byte numBits){
            numBits = (numBits < 1) ? (byte)1 : (numBits > Long.SIZE) ? (byte)Long.SIZE : numBits;
            this.root = null;
            this.numBits = numBits;
            this.bitMasks = new long[numBits];
            this.bitMasks[0] = 1;
            for(byte i = 1; i < numBits; ++i){
                bitMasks[i] = bitMasks[i-1] << 1L;
            }
        }

        public void add(int index, long val){
            this.root = add(index, val, this.root, this.numBits);
        }

        private Node add(int index, long val, Node node, byte bit){
            if (node == null){
                node = new Node();
            }
            node.add(index);
            if (--bit >= 0){
                if ((val & this.bitMasks[bit]) == 0){
                    node.zero = add(index, val, node.zero, bit);
                } else {
                    node.one = add(index, val, node.one, bit);
                }
            }
            return node;
        }

        public long maxXor(long n, int minIndex, int maxIndex){
            return  this.root == null ||
                    !this.root.hasIndexInRange(minIndex, maxIndex) ?
                    -1L :
                    maxXor(n, minIndex, maxIndex, this.root, this.numBits, 0L);
        }

        private long maxXor(long n, int minIndex, int maxIndex, Node node, byte bit, long xor){
            if (--bit < 0){
                return xor;
            }
            long mask = this.bitMasks[bit];
            if ((n & mask) == 0){
                return node.one != null && node.one.hasIndexInRange(minIndex, maxIndex) ?
                        maxXor(n, minIndex, maxIndex, node.one, bit, xor + mask) :
                        maxXor(n, minIndex, maxIndex, node.zero, bit, xor);
            }
            return node.zero != null && node.zero.hasIndexInRange(minIndex, maxIndex) ?
                    maxXor(n, minIndex, maxIndex, node.zero, bit, xor + mask) :
                    maxXor(n, minIndex, maxIndex, node.one, bit, xor);
        }

        public static class Node{
            public Node one;
            public Node zero;
            private List<Integer> indices;
            public Node(){
                this.one = null;
                this.zero = null;
                this.indices = new ArrayList<Integer>();
            }
            public void add(int index){
                this.indices.add(index);
            }
            public boolean hasIndexInRange(int minIndex, int maxIndex){
                int size = indices.size();
                minIndex = binarySearch(this.indices, minIndex, 0, size);
                if (minIndex >= 0){
                    return true;
                }
                maxIndex = binarySearch(this.indices, maxIndex, -minIndex, size);
                if (maxIndex >= 0){
                    return true;
                }
                return minIndex != maxIndex;
            }
            private int binarySearch(List<Integer> list, int val, int min, int max){
                while (min < max){
                    int mid = min + (max - min)/2;
                    int midVal = list.get(mid);
                    if (val == midVal){
                        return mid;
                    }
                    if (val < midVal){
                        max = mid;
                    } else {
                        min = mid + 1;
                    }
                }
                return -min;
            }
        }
    }
}
/*
33 = 0100001
 5 = 0000101
 6 = 0000110
 7 = 0000111
 8 = 0001000
---
41 = 0101001
47 = 0101111 ?
------------
 99 = 1100011
  8 = 0001000
  9 = 0001001
---
107 = 1101011
111 = 1101111 ?
*/