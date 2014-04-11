//https://www.hackerrank.com/challenges/triangle-numbers
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte[] indices = new byte[]{3, 2, 4, 2};
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            int N = Integer.parseInt(br.readLine());
            sb.append(N < 3 ? "-1\n" : indices[N%4] + "\n");
        }
        System.out.print(sb);
    }
}