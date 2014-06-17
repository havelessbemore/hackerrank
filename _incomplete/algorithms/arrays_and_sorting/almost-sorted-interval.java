//NOT COMPLETE
//https://www.hackerrank.com/challenges/almost-sorted-interval
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Get input
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] T = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            A[i] = Integer.parseInt(T[i]);
        }
        T = null;
        
        long count = 0L;
        
        //Go through array
        //Get length of longest sorted subarray
        //Add number of permutations of subarray to sum ( n*(n+1)/2 )
        int i = 0;
        while (i < N){
            long j = i;
            while (++i < N && A[i] > A[j]){
            }
            j = i - j;
            count += (j * (j+1)) / 2;
        }
        
        System.out.print(count);
    }
}