//https://www.hackerrank.com/challenges/diwali-lights
import java.io.*;

public class Solution {
    private static final int MAX = 10000;
    private static final int MOD = 100000;
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cache = initCache();
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            int N = Integer.parseInt(br.readLine());
            int P = cache[N-1];
            sb.append(P + "\n");
        }
        System.out.print(sb);
    }
    private static int[] initCache(){
        int prev = 1;
        int[] ar = new int[MAX];
        for(int i = 0; i < MAX; i++){
            int cur = (prev<<1)%MOD;
            ar[i] = cur == 0 ? MOD - 1 : cur - 1;
            prev = cur;
        }
        return ar;
    }
}