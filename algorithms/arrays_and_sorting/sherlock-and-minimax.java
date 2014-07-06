//https://www.hackerrank.com/challenges/sherlock-and-minimax
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Get N
        byte N = Byte.parseByte(br.readLine());
        
        //Get A
        final int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for(byte i = 0; i < N; ++i){
            A[i] = Integer.parseInt(input[i]);
        }
        
        //Get P and Q
        input = br.readLine().split(" ");
        final int P = Integer.parseInt(input[0]);
        final int Q = Integer.parseInt(input[1]);
        
        //Solve
        int maxMin = solve(A, N, P, Q);
        
        //Print
        System.out.print(maxMin);
    }
    
    private static int solve(int[] A, byte N, int P, int Q){
        
        //If P = Q
        if (P == Q){
            return P;
        }
        
        //Sort A
        Arrays.sort(A);
        
        //Remove duplicates
        N = (byte)unDup(A);
        
        //Look for start and end index
        int i = Arrays.binarySearch(A, 0, N, P);
        int j = Arrays.binarySearch(A, 0, N, Q);
        
        //If range between two indices
        if (i == j){
            i = ~i;

            //If range before A
            if (i == 0){
                return P;
            }

            //If range after A
            if (i == N){
                return Q;
            }

            //If range between A[i-1] and A[i]
            int mid = A[i-1] + ((A[i] - A[i-1]) >> 1);
            return (P > mid) ? P : (Q < mid) ? Q : mid;
        }
        
        int curMaxMin;
        int maxMin = 0;
        int maxMinVal = 0;
        
        if (i < 0){
            if(((i = ~i) == 0 || P > A[i-1] + ((A[i] - A[i - 1]) >> 1))){
                maxMin = A[i] - P;
                maxMinVal = P;
            } else {
                --i;
            }
        }
        
        if (j < 0 && ((j = ~j) == N || Q < A[j-1] + ((A[j] - A[j - 1]) >> 1))){
            curMaxMin = Q - A[j-1];
            if (curMaxMin > maxMin){
                maxMin = curMaxMin;
                maxMinVal = Q;
            }
            --j;
        }
        
        //Look for max min
        while (i < j){
            curMaxMin = (A[i+1] - A[i]) >> 1;
            if (curMaxMin > maxMin || (curMaxMin == maxMin && maxMinVal == Q)){
                maxMin = curMaxMin;
                maxMinVal = A[i] + curMaxMin;
            }
            ++i;
        }
        
        //Return minimum value with maximum minimum
        return maxMinVal;
    }
    
    private static int unDup(int[] A){
        //Assumes sorted A
        
        //Get length of A
        int N = A.length;
        
        //If no duplicate values possible
        if (N < 2){
            return N;
        }
        
        //Pack unique values into start of A
        int numUniqs = 1;
        for(int i = 1; i < N; ++i){
            if (A[i] != A[i - 1]){
                A[numUniqs++] = A[i];
            }
        }
        
        //Return number of unique values in A
        return numUniqs;
    }
}
