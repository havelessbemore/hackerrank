//https://www.hackerrank.com/challenges/red-john-is-back
import java.io.*;
import java.util.*;

public class Solution {
    
    private final static byte MAX_N = 40;
    private final static int MAX_WAYS = 217286;
    
    public static void main(String[] args) throws IOException {
        
        //INIT
        final StringBuffer sb = new StringBuffer();
        final int[] mem = new int[MAX_N+1];
        for(byte i = 0; i < 4; mem[i++] = 1){}
        int curMax = 3;
        final int[] primes = getPrimes(MAX_WAYS);
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            final byte N = Byte.parseByte(br.readLine());
            
            //SOLVE
            while (curMax < N){
                mem[curMax+1] = mem[curMax] + mem[curMax - 3];
                ++curMax;
            }
            
            int i = Arrays.binarySearch(primes, mem[N]);
            i = (i < 0) ? ~i : i+1;
            
            //OUTPUT
            sb.append(i + "\n");
        }
        System.out.print(sb);
    }
    
    private static int[] getPrimes(int N){
        final int sqrtN = (int)Math.ceil(Math.sqrt(N));
        boolean[] isComposite = new boolean[N];
        isComposite[0] = true;
        
        int count = 0;
        for(int i = 0; i < sqrtN; ++i){
            if (!isComposite[i]){
                ++count;
                final int prime = i+1;
                for(int j = prime*prime - 1; j < N; j += prime){
                    isComposite[j] = true;
                }
            }
        }
        
        for(int i = sqrtN; i < N; ++i){
            if (!isComposite[i]){
                ++count;
            }
        }
        
        int[] primes = new int[count];
        count = 0;
        for(int i = 0; i < N; ++i){
            if (!isComposite[i]){
                primes[count++] = i+1;
            }
        }
        
        return primes;
    }
}
