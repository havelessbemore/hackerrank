//https://www.hackerrank.com/challenges/little-gaurav-and-sequence
import java.io.*;

public class Solution {
    
    private final static byte MOD = 10;
    
    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            final long N = Long.parseLong(br.readLine());
            
            //BRUTE FORCE
            /*
            long S = 0;
            final byte I = binLog(N);
            for(byte i = 0; i <= I; ++i){
                for(long j = 0; j <= N; ++j){
                    S += Math.pow(2, Math.pow(2, i) + 2*j);
                    //System.out.println("("+i+","+j+"): "+S);
                }
            }
            S = S % MOD;
            */
            
            //REMOVE INNER LOOP
            /*
            long S = 0;
            final byte modN = mod(N);
            final byte I = binLog(N);
            final byte J = mod(1 + 5*modN - (modN & 1));
            for(byte i = 0; i <= I; ++i){
                S += Math.pow(2, Math.pow(2, i));
                //System.out.println("("+i+"): "+S);
            }
            S = (J*S) % MOD;
            */
            
            //REMOVE OUTER LOOP
            /*
            final byte logN = binLog(N);
            final byte modN = (byte)(N % MOD);
            final byte I = (byte)(((logN < 1) ? 2 : logN*6) % MOD);
            final byte J = (byte)((1 + 5*modN - (modN & 1)) % MOD);
            //System.out.println("("+I+","+J+")");
            final byte S = (byte)((I*J) % MOD);
            */
            
            //SOLVE
            final byte I = (N < 2) ? (byte)2 : (byte)(6*(binLog(N) % 5) % MOD);
            final byte J = ((N & 1) == 0) ? (byte)1 : (byte)5;
            final byte S = (byte)(I*J % MOD);
            
            //OUTPUT
            sb.append(S + "\n");
        }
        System.out.print(sb);
    }
    
    private static byte binLog(long n){
        byte power = -1;
        while (n > 0){
            ++power;
            n >>= 1;
        }
        return power;
    }
}
