//https://www.hackerrank.com/challenges/substring-diff
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            short K = Short.parseShort(temp[0]);
            char[] P = temp[1].toCharArray();
            char[] Q = temp[2].toCharArray();
            int L = max(solve(P, Q, K), solve(Q, P, K));
            sb.append(L + "\n");
        }
        System.out.print(sb);
    }
    private static int max(int a, int b){
        return a > b ? a : b;
    }
    private static int min(int a, int b){
        return a < b ? a : b;
    }
    private static int solve(char[] str_a, char[] str_b, short max_misses){
        int max_len = 0;
        int str_a_len = str_a.length;
        int[] points = new int[str_a_len + 2];
        points[0] = -1;
        int str_a_max = str_a_len - max_misses;
        for(int i_a = 0; i_a < str_a_max; ++i_a){
            int num_points = 1;
            int str_b_max = str_a_len - i_a;
            for(int i_b = 0; i_b < str_b_max; ++i_b){
                if (str_a[i_a + i_b] != str_b[i_b]){
                    points[num_points++] = i_b;
                }
            }
            points[num_points++] = str_b_max;
            int offset = min(max_misses+1, num_points-1);
            for(int i_p = offset; i_p < num_points; ++i_p){
                int len = points[i_p] - points[i_p - offset] - 1;
                max_len = max(max_len, len);
            }
            str_a_max = str_a_len - max_len;
        }
        return max_len;
    }
}