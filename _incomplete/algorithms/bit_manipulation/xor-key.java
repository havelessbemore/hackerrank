//https://www.hackerrank.com/challenges/xor-key
import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //For each test
        XorTree tree = new XorTree((byte)Short.SIZE);
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){

            //Get input
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int Q = Integer.parseInt(temp[1]);
            short[] ar = new short[N]; 
            temp = br.readLine().split(" ");
            for(int i = 0; i < N; ++i){
                ar[i] = Short.parseShort(temp[i]);
            }

            //Initialize xor tree
            tree.clear();
            for(int i = 0; i < N; ++i){
                tree.add(i+1, ar[i]);
            }

            //For each query
            for(int i = 0; i < Q; ++i){

                //Get input
                temp = br.readLine().split(" ");
                short a = Short.parseShort(temp[0]);
                int p = Integer.parseInt(temp[1]);
                int q = Integer.parseInt(temp[2]);

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
            numBits = numBits < 1 ? (byte)1 : numBits;
            numBits = numBits > Long.SIZE ? (byte)Long.SIZE : numBits;
            this.root = null;
            this.numBits = numBits;
            this.bitMasks = new long[numBits];
            this.bitMasks[0] = 1;
            for(byte i = 1; i < numBits; ++i){
                bitMasks[i] = bitMasks[i-1] << 1L;
            }
        }

        public void add(int index, long val){
            this.root = this.root == null ? new Node() : this.root;
            this.root.add(index);
            
            Node node = this.root;
            byte bit = this.numBits;
            while (bit-- > 0){
                node = ((val & this.bitMasks[bit]) == 0) ?
                   (node.zero = (node.zero == null) ? new Node() : node.zero):
                   (node.one  = (node.one  == null) ? new Node() : node.one );
                node.add(index);
            }
        }
        
        private long maxXor(long n, int minIndex, int maxIndex){
            if (this.root == null || !this.root.hasIndexInRange(minIndex, maxIndex)){
                return -1L;
            }
            
            long xor = 0L;
            Node node = this.root;
            byte bit = this.numBits;
            while (bit-- > 0){
                long mask = this.bitMasks[bit];
                if ((n & mask) == 0){
                    if (node.one != null && node.one.hasIndexInRange(minIndex, maxIndex)){
                        xor += mask;
                        node = node.one;
                    } else {
                        node = node.zero;
                    }
                } else if (node.zero != null && node.zero.hasIndexInRange(minIndex, maxIndex)){
                    xor += mask;
                    node = node.zero;
                } else {
                    node = node.one;
                }
            }
            
            return xor;
        }

        public void clear(){
            this.root = null;
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
                int size = this.indices.size();
                if (size < 1 || this.indices.get(size-1) < index){
                    this.indices.add(index);
                } else {
                    int i = binarySearch(this.indices, index, 0, size);
                    if (i < 0){
                        this.indices.add(-i - 1, index);
                    }
                }
            }

            public boolean hasIndexInRange(int minIndex, int maxIndex){
                int size = indices.size();
                minIndex = binarySearch(this.indices, minIndex, 0, size);
                if (minIndex >= 0){
                    return true;
                }
                maxIndex = binarySearch(this.indices, maxIndex, -minIndex - 1, size);
                return (maxIndex < 0) ? minIndex != maxIndex : true;
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
                return -min - 1;
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

/*
1  | 0000001
2  | 0000010
3  | 0000011
4  | 0000100
5  | 0000101
6  | 0000110
7  | 0000111
8  | 0001000
9  | 0001001
10 | 0001010
11 | 0001011
12 | 0001100
13 | 0001101
14 | 0001110
15 | 0001111
*/