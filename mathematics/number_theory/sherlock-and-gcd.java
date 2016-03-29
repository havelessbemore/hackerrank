//https://www.hackerrank.com/challenges/sherlock-and-gcd
import java.io.*;
import java.util.*;

public class Solution {
    private final static String NO = "NO\n";
    private final static String YES = "YES\n";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test
        StringBuffer sb = new StringBuffer();
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //INPUT
            byte N = Byte.parseByte(br.readLine());
            int[] A = new int[N];
            N = 0;
            for(String s : br.readLine().split(" ")){
                A[N++] = Integer.parseInt(s);
            }
            
            sb.append(solve(A, N) ? YES : NO);
        }
        System.out.print(sb);
    }
    
    private static boolean solve(int[] A, byte N){
        //If array size < 2
        if (N < 2){
            return false;
        }
        
        //Find GCD
        int curGcd = A[0];
        for(int i = 1; curGcd > 1 && i < N; ++i){
            curGcd = gcd(curGcd, A[i]);
        }
        
        return curGcd < 2;
    }
    
    private static int gcd(int a, int b){
        while (b != 0){
            int c = b;
            b = a % b;
            a = c;
        }
        return a;
    }
}
