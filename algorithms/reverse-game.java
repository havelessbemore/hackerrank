//https://www.hackerrank.com/challenges/reverse-game
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            final String[] input = br.readLine().split(" ");
            final int N = Integer.parseInt(input[0]);
            final int K = Integer.parseInt(input[1]);
            
            //SOLVE
            final int I = (K < (N >> 1)) ? 1 + (K << 1) : (N-1 - K) << 1;
            
            //OUTPUT
            sb.append(I + "\n");
        }
        System.out.print(sb);
    }
}
