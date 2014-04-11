//https://www.hackerrank.com/challenges/halloween-party
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            int K = Integer.parseInt(br.readLine());
            int horCuts = K/2;
            int vertCuts = K - horCuts;
            long numPieces = 1L*horCuts*vertCuts;
            sb.append(numPieces + "\n");
        }
        System.out.print(sb);
    }
}