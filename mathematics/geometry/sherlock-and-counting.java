//https://www.hackerrank.com/challenges/sherlock-and-counting
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
            
            //SOLVE
            final long max = 1L * N * K;
            final long maxPos = (N >> 1L)*((N+1L) >> 1L);
            if (maxPos <= max){
                final int count = ((N >> 1) << 1) - ((N-1) & 1);
                sb.append(count + "\n");
                continue;
            }
            
            final long X = maxPos - max;
            final int Y = (((N-1) & 1) == 0) ? (int)Math.ceil(Math.sqrt(X + 0.25) - 0.5) : (int)Math.ceil(Math.sqrt(X + 1) - 1);
            final int I = (N >> 1) - Y;
            final int count = (1L*I*(N-I) > max) ? (I-1) << 1 : I << 1;
            
            //DEBUG
            //sb.append("X: " + X + ", Y: " + Y + ", I: " + I + ", COUNT: " + count + "\n");
            
            //OUTPUT
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}
