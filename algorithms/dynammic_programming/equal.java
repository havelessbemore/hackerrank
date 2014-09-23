//https://www.hackerrank.com/challenges/equal
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            final short N = Short.parseShort(br.readLine());
            final short[] A = new short[N];
            String[] input = br.readLine().split(" ");
            for(short i = 0; i < N; ++i){
                A[i] = Short.parseShort(input[i]);
            }
            input = null;
            
            //SOLVE
            if(N < 2){
                sb.append("0\n");
                continue;
            }
            
            int minVal = A[0];
            for(int i = 1; i < N; ++i){
                if (A[i] < minVal){
                    minVal = A[i];
                }
            }
            
            int minCount = Integer.MAX_VALUE;
            for(int i = 0; i <= 5; ++i){
                int count = 0;
                for(short j = 0; j < N; ++j){
                    short V = (short)(A[j] - (minVal - i));
                    count += V/5 + (V %= 5)/2 + (V & 1);
                }
                if (count < minCount){
                    minCount = count;
                }
            }
            
            //OUTPUT
            sb.append(minCount+ "\n");
        }
        System.out.print(sb);
    }
}
