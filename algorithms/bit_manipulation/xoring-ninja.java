//https://www.hackerrank.com/challenges/xoring-ninja
import java.io.*;

public class Solution {
    
    final static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get input set
            final int[] A = new int[Integer.parseInt(br.readLine())];
            int N = 0;
            for(String a : br.readLine().split(" ")){
                A[N++] = Integer.parseInt(a);
            }
            
            //Get set bits
            int bits = 0;
            for(int i = 0; i < N; bits |= A[i++]){}
            
            //Get xorSum
            int xorSum = 0;
            final int x = powMod(2, N-1, MOD);
            for(byte i = 0; bits > 0; ++i){
                if((bits & 1) == 1){
                    xorSum = (int)((xorSum + (((long)x) << i)) % MOD);
                }
                bits >>= 1;
            }
            
            //Print output
            sb.append(xorSum + "\n");
        }
        System.out.print(sb);
    }
    
    private static int powMod(int b, int p, final int m){
        int v = 1;
        while(p > 0){
            if ((p & 1) == 1){
                v = (int)((1L*v*b) % m);
            }
            p >>= 1;
            b = (int)((1L*b*b) % m);
        }
        return v;
    }
}
