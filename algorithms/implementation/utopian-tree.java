//https://www.hackerrank.com/challenges/utopian-tree
import java.io.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            byte N = Byte.parseByte(br.readLine());
            byte R = (byte)(N & 1);
            long answer = (long)(Math.pow(2, (N+R+2)>>1) - (R+1));
            sb.append(answer + "\n");
        }
        System.out.print(sb);
    }
}