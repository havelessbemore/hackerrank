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
        private static byte NUM_BITS;
        private static long[] BIT_MASKS;
        
    	public XorTree(byte numBits){
            this.root = null;
            if (this.BIT_MASKS == null){
                this.NUM_BITS = numBits;
                this.BIT_MASKS = new long[numBits];
                for(byte i = 0; i <= numBits; ++i){
                    this.BIT_MASKS[i] = 1L << i;
                }
            }
    	}
        public void add(int index, int val){
            this.root = add(index, val, NUM_BITS);
        }
        public void add(int index, int val, int bit_mask){
            
        }
        
        
        
        /*
        public void add(int index, int val){
            for(int b = BITS; b >= 0)
        }
        */
    	private class Node{
            /*
    		public Node one;
    		public Node zero;
    		public List<Integer> indices;
    		public Node(){
    			this.one = null;
    			this.zero = null;
    			this.indices = new ArrayList<Integer>();
    		}
    		public boolean containsIndexInRange(int min, int max){
    			int length = indices.size();
    			int minIndex = binarySearch(indices, min, 0, length);
    			int maxIndex = binarySearch(indices, max, minIndex, length);
    			return minIndex < maxIndex;
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
    			return min;
    		}
            */
    	}
    }
}