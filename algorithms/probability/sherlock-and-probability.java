//https://www.hackerrank.com/challenges/sherlock-and-probability
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            String[] input = br.readLine().split(" ");
            final int N = Integer.parseInt(input[0]);
            final int K = Integer.parseInt(input[1]);
            char[] str = br.readLine().toCharArray();
            input = null;
            
            //INIT
            final byte[] B = new byte[N];
            for(int i = 0; i < N; ++i){
                B[i] = (byte)(str[i] - '0');
            }
            str = null;
            
            //SOLVE
            long num = 0;
            long den = 1L * N * N;
            
            int sum = 0;
            for(int i = 0; i < K; sum += B[i++]){}
            
            for(int i = 0; i < N-K; ++i){
                sum += B[i+K];
                if (B[i] == 1){
                    num += 1 + (--sum << 1);
                }
            }
            
            for(int i = N-K; i < N; ++i){
                if (B[i] == 1){
                    num += 1 + (--sum << 1);
                }
            }
            
            final long factor = gcd(num, den);
            num /= factor;
            den /= factor;
            
            //OUTPUT
            sb.append(num + "/" + den + "\n");
        }
        System.out.print(sb);
    }
    
    private static long gcd(long a, long b){
        while (b != 0){
            long c = a;
            a = b;
            b = c%b;
        }
        return a;
    }
}
