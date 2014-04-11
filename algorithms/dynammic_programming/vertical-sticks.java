//https://www.hackerrank.com/challenges/vertical-sticks
import java.io.*;
import java.util.*;
import java.text.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        DecimalFormat df = new DecimalFormat("##.00\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            //Get input
            byte N = Byte.parseByte(br.readLine());
            String[] temp = br.readLine().split(" ");
            short[] ar = new short[N];
            for(byte i = 0; i < N; ++i){
                ar[i] = Short.parseShort(temp[i]);
            }
            //Sort
            Arrays.sort(ar);
            //Rank
            byte[] r = new byte[N];
            for(byte i = r[0] = 1; i < N; ++i){
                r[i] = ar[i] > ar[i-1] ? (byte)(i+1) : r[i-1];
            }
            //Reverse Rank
            for(byte i = 0; i < N; ++i){
                r[i] = (byte)(N + 1 - r[i]);
            }
            //Get expectation
            float avg = 0.0f;
            for(byte i = 0; i < N; avg += 1.0f/(r[i++] + 1)){}
            avg *= N + 1;
            sb.append(df.format(avg));
        }
        System.out.print(sb);
    }
}