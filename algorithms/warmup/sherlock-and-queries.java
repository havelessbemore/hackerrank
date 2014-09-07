//https://www.hackerrank.com/challenges/sherlock-and-queries
import java.io.*;
import java.util.*;

public class Solution{
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        int[] A = getArr(br.readLine().split(" "));
        int[] B = getArr(br.readLine().split(" "));
        int[] C = getArr(br.readLine().split(" "));
        
        //SOLVE
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < M; ++i){
            int key = B[i];
            Integer j = map.get(key);
            map.put(key, (j == null) ? C[i] : (int)((((long)j) * C[i]) % MOD));
        }
        
        for(int divisor : map.keySet()){
            long multiplier = map.get(divisor);
            for(int j = divisor - 1; j < N; j += divisor){
                A[j] = (int)((A[j] * multiplier) % MOD);
            }
        }
        
        //OUTPUT
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; ++i){
            sb.append(A[i] + " ");
        }
        System.out.print(sb);
    }
    private static int[] getArr(String[] strs){
        final int N = strs.length;
        int[] arr = new int[N];
        for(int i = 0; i < N; ++i){
            arr[i] = Integer.parseInt(strs[i]);
        }
        return arr;
    }
}
