//https://www.hackerrank.com/contests/projecteuler/challenges/euler001
import java.io.*;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] N = new int[T];
        for(int t = 0; t < T; N[t++] = Integer.parseInt(br.readLine())){
        }
        br.close();
        br = null;
        
        //Solve
        long[] V = new long[T];
        for(int t = 0; t < T; ++t){
            int n = N[t] - 1;
            V[t] = 3*nSum(n/3) + 5*nSum(n/5) - 15*nSum(n/15);
        }
        
        //Print
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; sb.append(V[t++]).append("\n")){
        }
        System.out.print(sb);
    }
    
    public static long nSum(int n){
        long v = n;
        return (v*v + v) >> 1;
    }
}