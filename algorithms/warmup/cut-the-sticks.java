//https://www.hackerrank.com/challenges/cut-the-sticks
import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //INPUT
        short N = Short.parseShort(br.readLine());
        short[] A = new short[N];
        N = 0;
        for(String str : br.readLine().split(" ")){
            A[N++] = Short.parseShort(str);
        }
        
        //SOLVE
        Arrays.sort(A);
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N;){
            sb.append((N - i) + "\n");
            while (++i < N && A[i-1] == A[i]){}
        }
        
        //OUTPUT
        System.out.print(sb);
    }
}
