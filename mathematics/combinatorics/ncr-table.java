//https://www.hackerrank.com/challenges/ncr-table
import java.io.*;
import java.util.*;

public class Solution {
	private final static int MOD = 1000000000;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short T = Short.parseShort(br.readLine());
        
        //Store N's
        short[] Ns = new short[T];
        for(short t = 0; t < T; Ns[t++] = Short.parseShort(br.readLine())){}
        
        //Create map
        Map<Short, int[]> map = new TreeMap<Short, int[]>();
        for(short t = 0; t < T; map.put(Ns[t++], null)){}
        
        //Create cache
        short curN = 1;
        int[] curC = new int[]{1, 1};
        for(short n : map.keySet()){
            while (curN < n){
                curN++;
                short length = (short)(curN + 1);
                int[] C = new int[length];
                C[0] = C[curN] = 1;
                for(short i = 1; i < curN; i++){
                    C[i] = (curC[i] + curC[i-1])%MOD;
                }
                curC = C;
            }
            map.put(n, curC);
        }
        
        //Print
        StringBuffer sb = new StringBuffer();
        for(short t = 0; t < T; t++){
            int[] C = map.get(Ns[t]);
            int length = C.length;
            for(short i = 0; i < length; sb.append(C[i++] + " ")){}
            sb.append("\n");
        }
        System.out.print(sb);
    }
}