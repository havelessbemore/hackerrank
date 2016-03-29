//https://www.hackerrank.com/challenges/encryption
import java.io.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ar = br.readLine().toCharArray();
        int N = ar.length;
        int cols = (int)Math.ceil(Math.sqrt(N));
        for(int c = 0; c < cols; c++){
            for(int i = c; i < N; i += cols){
                sb.append(ar[i]);
            }
            sb.append(" ");
        }
        System.out.print(sb);
    }
}