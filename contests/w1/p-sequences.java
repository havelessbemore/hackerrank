//Week 1, Wednesday
//https://www.hackerrank.com/contests/w1/challenges/p-sequences
import java.io.*;
import java.util.*;

public class Solution {
    
    public final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short N = Short.parseShort(br.readLine());
        int P = Integer.parseInt(br.readLine());
        
        //Create list
        List<Integer> list = new ArrayList<Integer>();
        
        //Initialize list
        int dividend = P;
        int divisor = 1;
        int quotient = P;
        list.add(quotient);
        while (divisor < quotient){
            ++divisor;
            quotient = dividend / divisor;
            list.add(quotient);
        }
        while (--divisor > 0){
            list.add(divisor);
        }

        int length = list.size();

        //Create and initialize sums array
        int[] sums = new int[length+2];
        int i = 0;
        for(int v : list){
            sums[++i] = v;
        }
        list = null;

        //Create and initialize mults array
        int[] mults = new int[length+2];
        i = length;
        for(int j = 1; j <= length; ++j){
            mults[i--] = sums[j] - sums[j+1];
        }
        
        //Solve
        boolean isOdd = (--N & 1) == 1;
        N >>= 1;
        while (N-- > 0){
            for(i = 1; i <= length; ++i){
                sums[i] = (int)((((long)sums[i]) * mults[i]) % MOD);
                sums[i] = (sums[i] + sums[i-1]) % MOD;
            }
            i = length;
            for(int j = 0; i > 0; --i){
                sums[i] = (int)((((long)sums[i]) * mults[++j]) % MOD);
                sums[i] = (sums[i] + sums[i+1]) % MOD;
            }
        }
        if (isOdd){
            for(i = 1; i <= length; ++i){
                sums[i] = (int)((((long)sums[i]) * mults[i]) % MOD);
                sums[i] = (sums[i] + sums[i-1]) % MOD;
            }
            System.out.print(sums[length]);
        } else {
            System.out.print(sums[1]);
        }
    }
    /*
    private static void print(int[] ar){
        StringBuffer sb = new StringBuffer();
        for(int v : ar){
            sb.append(v + " ");
        }
        System.out.println(sb);
    }
    */
}