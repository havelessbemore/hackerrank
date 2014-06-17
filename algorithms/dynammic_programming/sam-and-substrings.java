//https://www.hackerrank.com/challenges/sam-and-substrings
//See: https://www.hackerrank.com/contests/w3/challenges/sam-and-substrings
import java.io.*;

public class Solution {
    
    private final static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        
        int[] balls = strNumToArr((new BufferedReader(new InputStreamReader(System.in))).readLine());
        
        int n = balls.length;
        for(int i = n - 2; i >= 0; --i){
            balls[i] = (int)((balls[i+1] + (((long)balls[i])*(n - i))%MOD)%MOD);
        }
        
        int pow = 1;
        int total = 0;
        for(int i = 0; i < n; ++i){
            total = (int)((total + (((long)balls[i])*pow)%MOD)%MOD);
            pow = (int)((pow*10L)%MOD);
        }
        
        System.out.print(total);
    }
    
    private static int[] strNumToArr(String str){
        int n = str.length();
        int[] ar = new int[n];
        for(char c : str.toCharArray()){
            ar[--n] = c - '0';
        }
        return ar;
    }    
}