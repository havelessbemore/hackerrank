//https://www.hackerrank.com/challenges/board-cutting
import java.io.*;
import java.util.*;

public class Solution {
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] input = br.readLine().split(" ");
            final int M = Integer.parseInt(input[0]) - 1;
            final int N = Integer.parseInt(input[1]) - 1;
            final int[] Ys = strToArr(M, br.readLine());
            final int[] Xs = strToArr(N, br.readLine());
            
            //SOLVE
            Arrays.sort(Xs);
            Arrays.sort(Ys);
            
            int vSegs = 1;
            int hSegs = 1;
            int y = M - 1;
            int x = N - 1;
            long cost = 0L;
            
            while (x >= 0 && y >= 0){
                if (Xs[x] > Ys[y]){
                    ++vSegs;
                    cost = (cost + ((long)Xs[x--])*hSegs)%MOD;
                } else {
                    ++hSegs;
                    cost = (cost + ((long)Ys[y--])*vSegs)%MOD;
                }
                
            }
            while (x >= 0){
                cost = (cost + ((long)Xs[x--])*hSegs)%MOD;
            }
            while (y >= 0){
                cost = (cost + ((long)Ys[y--])*vSegs)%MOD;
            }
            
            //OUTPUT
            sb.append(cost + "\n");
        }
        System.out.print(sb);
    }
    private static int[] strToArr(int n, String line){
        int[] arr = new int[n];
        String[] Vs = line.split(" ");
        while (n-- > 0){
            arr[n] = Integer.parseInt(Vs[n]);
        }
        return arr;
    }
}
