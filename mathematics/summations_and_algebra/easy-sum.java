//https://www.hackerrank.com/challenges/easy-sum
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            final String[] input = br.readLine().split(" ");
            final int N = Integer.parseInt(input[0]);
            final int M = Integer.parseInt(input[1]);
            
            //SOLVE
            final int Q = N/M;
            final int R = N%M;
            final long S = Q*((M*(M-1L)) >> 1) + ((R*(R+1L)) >> 1);
            
            //OUTPUT
            sb.append(S + "\n");
        }
        
        System.out.print(sb);
    }
}
