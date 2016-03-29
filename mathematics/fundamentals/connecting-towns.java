//https://www.hackerrank.com/challenges/connecting-towns
import java.io.*;

public class Solution {
    private final static int MOD = 1234567;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            int N = Integer.parseInt(br.readLine()) - 1;
            String[] temp = br.readLine().split(" ");
            int R = 1;
            while (N-- > 0){
                R = (R*Integer.parseInt(temp[N]))%MOD;
            }
            sb.append(R + "\n");
        }
        System.out.print(sb);
    }
}