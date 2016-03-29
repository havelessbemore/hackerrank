//https://www.hackerrank.com/challenges/picking-cards
import java.io.*;
import java.util.*;

public class Solution {
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            int N = Integer.parseInt(br.readLine());
            int[] ar = strToInt(br.readLine().split(" "));
            Arrays.sort(ar);
            long ways = 1L;
            int cardCount = 0;
            for(int min = 0; cardCount < N; cardCount++){
                int max = binarySearch(ar, cardCount, min, N);
                if (cardCount > max){
                    ways = 0;
                    break;
                }
                ways = (ways * ((long)(max - cardCount + 1)))%MOD;
                min = max;
            }
            sb.append(ways + "\n");                
        }
        System.out.print(sb);
    }
    /*
    private static void printArray(int[] ar){
        StringBuffer sb = new StringBuffer();
        for(int v : ar){
            sb.append(v + " ");
        }
        System.out.println(sb);
    }
    */
    private static int binarySearch(int[] ar, int val, int min, int max){
        for(int length = max - min; length > 1; length = max - min){
            int mid = min + length/2;
            if (val < ar[mid]){
                max = mid;
            } else {
                min = mid;
            }
        }
        return min;
    }
    private static int[] strToInt(String[] temp){
        int N = temp.length;
        int[] ar = new int[N];
        while (N-- > 0){
            ar[N] = Integer.parseInt(temp[N]);
        }
        return ar;
    }
}