//https://www.hackerrank.com/challenges/sherlock-and-pairs
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            N = 0;
            for(String Ai : br.readLine().split(" ")){
                A[N++] = Integer.parseInt(Ai);
            }
            
            //SOLVE
            Arrays.sort(A);
            
            long sum = 0L;
            for(int i = 0; i < N;){
                int j = i;
                while(++j < N && A[j-1] == A[j]){}
                int count = j - i;
                sum += count * (count - 1L);
                i = j;
            }
            
            //OUTPUT
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}
