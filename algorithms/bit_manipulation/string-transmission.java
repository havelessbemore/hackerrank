//https://www.hackerrank.com/challenges/string-transmission
import java.io.*;
import java.util.*;
import java.math.*;
public class Solution {
    private final static short MAX_N = 1000;
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //For every test
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            //Get input
            String[] temp = br.readLine().split(" ");
            short N = Short.parseShort(temp[0]);
            short K = Short.parseShort(temp[1]);
            char[] STR = br.readLine().toCharArray();
            int X = solve(N, K, STR, MOD);
            sb.append(X + "\n");
        }
        System.out.print(sb);
    }
    private static int solve(short N, short K, char[] STR, int MOD){
        //Get number of possible strings when flipping 0-K bits out of N bits
        int total = SNCR(N, K, MOD);
        //Get all divisors of N
        short[] divisors = getDivisors(N);
        short numDivisors = (short)divisors.length;
        int[][] dp = new int[numDivisors][N + K + 1];
        boolean flag = false;
        //For all divisors
        for (short divisorIndex = 0; divisorIndex < numDivisors; ++divisorIndex) {
            short divisor = divisors[divisorIndex];
            short quotient = (short)(N / divisor);
            dp[divisorIndex][0] = 1;
            //From 0 to divisor i
            for (short i = 0; i < divisor; ++i) {
                //Count the zeros in the string for every index multiple of current disivor i and offset k from 0;
                int zero = 0;
                for (short j = i; j < N; j += divisor) {
                    zero += (STR[j] == '0') ? 1 : 0;
                }
                int[] prev = dp[divisorIndex];
                dp[divisorIndex] = new int[MAX_N];
                //From 0 to K ???
                for (short j = 0; j <= K; ++j) {
                    if (prev[j] > 0) {
                        dp[divisorIndex][j + zero] = mod(dp[divisorIndex][j + zero] + prev[j], MOD);
                        dp[divisorIndex][j + quotient - zero] = mod(dp[divisorIndex][j + quotient - zero] + prev[j], MOD);
                    }
                }
            }
            flag = (dp[divisorIndex][0] > 0) ? true : flag;
            //For every divisor up to current divisor
            for (short i = 0; i < divisorIndex; ++i) {
                //If smaller divisor also divides current divisor
                if (divisor % divisors[i] == 0) {
                    //Subtract previous palindromes found from current divisor to avoid double count
                    for (short j = 0; j <= K; ++j) {
                        dp[divisorIndex][j] = mod(dp[divisorIndex][j] - dp[i][j], MOD);
                    }
                }
            }
            //Subtract number of palindromes possible for this divisor
            for (short i = 1; i <= K; total = mod(total - dp[divisorIndex][i++], MOD)){}
        }        
        total = (flag) ? mod(total - 1, MOD) : total;
        return total;
    }
    private static short[] getDivisors(short N){
        List<Short> divisors = new ArrayList<Short>();
        for (short i = 1; i < N ; ++i) {
            if (N % i == 0) {
                divisors.add(i);
            }
        }
        short i = 0;
        short[] out = new short[divisors.size()];
        for(short v : divisors){
            out[i++] = v;
        }
        return out;
    }
    private static int mod(int n, int m){
        return (n%m + m)%m;
    }
    private static int SNCR(int N, int K, int MOD){
        // out = (nCr(N,0) + nCr(N,1) + ... + nCr(N, K))%MOD
        //We will use Pascal's triangle for this
        //Represents row of Pascal's triangle
        int[] row = new int[K+1];
        //Initialize to first row
        row[0] = 1;
        //Iterate through each row until row K
        for(int i = 1; i <= K; ++i){
            //Fills each row backwards
            row[i] = 1;
            for(int j = i-1; j > 0; --j){
                row[j] = (row[j] + row[j-1]) % MOD;
            }
        }
        //Keep iterating until row N but only columns 0-K
        for(int i = K+1; i <= N; ++i){
            //Fills each row backwards
            for(int j = K; j > 0; --j){
                row[j] = (row[j] + row[j-1]) % MOD;
            }
        }
        //Sum up the row from 0 to K
        int out = 0;
        for(int i = 0; i <= K; out = (out + row[i++])%MOD){}
        return out;
    }
}