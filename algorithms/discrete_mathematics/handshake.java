//https://www.hackerrank.com/challenges/handshake
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            long N = Integer.parseInt(br.readLine());
            long H = N*(N-1)/2;
            sb.append(H + "\n");
        }
        System.out.print(sb);
    }
}