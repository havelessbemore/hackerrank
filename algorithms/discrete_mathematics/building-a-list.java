//https://www.hackerrank.com/challenges/building-a-list
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            byte N = Byte.parseByte(br.readLine());
            char[] ar = br.readLine().toCharArray();
            Arrays.sort(ar);
            printCombos(ar, sb);
        }
        System.out.print(sb);
    }
    private static void printCombos(char[] ar, StringBuffer sb){
        int N = ar.length;
        for(int i = 0; i < N; printCombos(ar, i++, N, "", sb)){}
    }
    private static void printCombos(char[] ar, int i, int N, String str, StringBuffer sb){
        str += ar[i];
        sb.append(str + "\n");
        while (++i < N){
            printCombos(ar, i, N, str, sb);
        }
    }
}