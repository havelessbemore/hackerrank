//https://www.hackerrank.com/challenges/crush
//http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        SegmentTree tree = new SegmentTree(new int[N]);
        for(int m = 0; m < M; ++m){
            input = br.readLine().split(" ");
            final int A = Integer.parseInt(input[0]);
            final int B = Integer.parseInt(input[1]);
            final int K = Integer.parseInt(input[2]);
            
            //SOLVE
            tree.update(A-1, B-1, K);
        }
        
        //OUTPUT
        System.out.print(tree.max());
    }
    
    private static class SegmentTree {
        private int length;
        private long[] data;
        private long[] lazy;
        
        public SegmentTree(final int[] arr){
			init(arr);
		}
        
        ////////////////////////
        //       BUILD        //
        ////////////////////////
        
        private void init(final int[] arr){
            this.length = arr.length;
			int height = (int)Math.ceil(Math.log(this.length)/Math.log(2));
			int size = (1 << (height + 1)) - 1;
			this.data = new long[size];
            this.lazy = new long[size];
            build(this.data, arr, 0, this.length - 1, 0);
        }
        
        private static long build(final long[] data, final int[] arr, int min, int max, int i){
            if (min == max){
                return data[i] = arr[min];
            }
            int mid = getMid(min, max);
            return data[i] = getMax(build(data, arr, min, mid, getLeft(i)),
                                    build(data, arr, mid+1, max, getRight(i)));
        }
        
        ////////////////////////
        //         MAX        //
        ////////////////////////
        
        public long max(){
            return max(0, this.length - 1);
        }
        
        public long max(final int ql, final int qr){
            return max(this.data, this.lazy, ql, qr, 0, this.length - 1, 0);
        }
        
        private static long max(final long[] arr, final long[] lazy, final int ql, final int qr, int min, int max, int i){
            
            //Unlazy
            if (lazy[i] != 0L){
                arr[i] += lazy[i];
                if (min != max){
                    lazy[getLeft(i)] += lazy[i];
                    lazy[getRight(i)] += lazy[i];
                }
                lazy[i] = 0L;
            }
            
            //If not in range
            if (max < ql || min > qr){
                return 0L;
            }
            
            //If completely in range
            if (min >= ql && max <= qr){
                return arr[i];
            }
            
            //Get max value
            int mid = getMid(min, max);
            return getMax(max(arr, lazy, ql, qr, min, mid, getLeft(i)), 
                          max(arr, lazy, ql, qr, mid+1, max, getRight(i)));
        }
        ////////////////////////
        //       UPDATE       //
        ////////////////////////
        
        public void update(final int ql, final int qr, final int val){
            update(this.data, this.lazy, ql, qr, 0, this.length - 1, val, 0);
        }
        
        public long update(final long[] arr, final long[] lazy, final int ql, final int qr, int min, int max, final int val, int i){
            
            //Unlazy
            if (lazy[i] != 0L){
                arr[i] += lazy[i];
                if (min != max){
                    lazy[getLeft(i)] += lazy[i];
                    lazy[getRight(i)] += lazy[i];
                }
                lazy[i] = 0L;
            }
            
            //If not in range
            if (max < ql || min > qr){
                return arr[i];
            }
            
            //If completely in range
            if (min >= ql && max <= qr){
                if (min != max){
                    lazy[getLeft(i)] += val;
                    lazy[getRight(i)] += val;
                }
                return arr[i] += val;
            }
            
            int mid = getMid(min, max);
            return arr[i] = getMax(update(arr, lazy, ql, qr, min, mid, val, getLeft(i)), 
                                   update(arr, lazy, ql, qr, mid+1, max, val, getRight(i)));
        }
        
        ////////////////////////
        //      HELPERS       //
        ////////////////////////
        
        private static long getMax(final long a, final long b){
            return (a > b) ? a : b;
        }
        
        private static int getMid(final int min, final int max){
            return min + ((max - min) >> 1);
        }
        
        private static int getLeft(final int i){
            return (i << 1) + 1;
        }
        
        private static int getRight(final int i){
            return (i+1) << 1;
        }
        
        public String toString(){
            return Arrays.toString(this.data);
        }
    }
}
