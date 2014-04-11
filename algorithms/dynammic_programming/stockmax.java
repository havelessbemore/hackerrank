//https://www.hackerrank.com/challenges/stockmax
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            int N = Integer.parseInt(br.readLine());
            String[] temp = br.readLine().split(" ");
            int[] ar = new int[N];
            for(int i = 0; i < N; ++i){
                ar[i] = Integer.parseInt(temp[i]);
            }
            
            int max = 0;
            Deque<Integer> sellPoints = new ArrayDeque<Integer>();
            for(int i = N; i-- > 0;){
                if (ar[i] > max){
                    max = ar[i];
                    sellPoints.push(i);
                }
            }
            
            long profit = 0;
            int s = sellPoints.size();
            for(int i = 0; s > 0; --s){
                for(int j = sellPoints.pop(); i < j; profit += ar[j] - ar[i++]){}
                ++i;
            }
            
            sb.append(profit + "\n");
        }
        System.out.print(sb);
    }
}