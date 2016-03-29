//https://www.hackerrank.com/challenges/bigger-is-greater
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        
        //INPUT
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            final char[] W = br.readLine().toCharArray();
            final int N = W.length;
            
            //SOLVE
            
            //Find first index i whose character can be 
            //swapped to form a lexographically greater string
            int i;
            for(i = N - 2; i >= 0 && W[i] >= W[i+1]; --i){}
            
            //Return if no such index
            if (i < 0){
                sb.append("no answer\n");
                continue;
            }
            
            //Find the index minI whose character is 
            //the smallest character greater than W[i]
            int minI = i+1;
            for(int j = i+2; j < N; ++j){
                if (W[j] > W[i] && W[j] < W[minI]){
                    minI = j;
                }
            }
            
            //Swap W[i] and W[minI]
            char t = W[minI];
            W[minI] = W[i];
            W[i] = t;
            
            //Sort W[i+1, N-1]
            Arrays.sort(W, i+1, N);
            
            //OUTPUT
            sb.append(W).append("\n");
        }
        System.out.println(sb);
    }
}
