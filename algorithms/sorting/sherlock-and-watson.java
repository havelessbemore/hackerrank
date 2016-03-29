//https://www.hackerrank.com/challenges/sherlock-and-watson
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);
        final short Q = Short.parseShort(input[2]);
        final int[] A = new int[N];
        input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            A[i] = Integer.parseInt(input[i]);
        }
        
        int offset = N - K%N;
        StringBuffer sb = new StringBuffer();
        for(short q = 0; q < Q; ++q){
            final int X = Integer.parseInt(br.readLine());
            
            //SOLVE
            sb.append(A[(X + offset)%N] + "\n");
        }
        
        //OUTPUT
        System.out.print(sb);
    }
}
