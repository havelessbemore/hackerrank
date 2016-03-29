//https://www.hackerrank.com/challenges/chocolate-feast
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int C = Integer.parseInt(temp[1]);
            int M = Integer.parseInt(temp[2]);
            int total = N/C;
            int wrappers = total;
            while (wrappers >= M){
                int free = wrappers/M;
                total += free;
                wrappers = free + wrappers%M;
            }
            sb.append(total + "\n");
        }
        System.out.print(sb);
    }
}