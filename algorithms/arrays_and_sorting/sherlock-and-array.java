//https://www.hackerrank.com/challenges/sherlock-and-array
import java.io.*;
import java.util.*;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get input
            int N = Integer.parseInt(br.readLine());
            short[] A = new short[N];
            int i = 0;
            for(String s : br.readLine().split(" ")){
                A[i++] = Short.parseShort(s);
            }
            
            //Solve
            int sum;
            int[] S = new int[N];
            
            //Get left to right sums
            sum = 0;
            for(i = 0; i < N; ++i){
                S[i] = sum += A[i];
            }
            
            //Subtract right to left sums
            sum = 0;
            for(i = N - 1; i >= 0; --i){
                S[i] -= sum += A[i];
            }
            
            //When equal, left-to-right - right-to-left = 0
            sb.append((Arrays.binarySearch(S, 0) < 0) ? "NO\n" : "YES\n");
        }
        
        //Print
        System.out.print(sb);
    }
}