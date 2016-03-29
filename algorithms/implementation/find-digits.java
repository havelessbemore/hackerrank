//https://www.hackerrank.com/challenges/find-digits
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            int count = 0;
            String str = br.readLine().trim();
            int length = str.length();
            int N = Integer.parseInt(str);
            for(int i = 0; i < length; i++){
                int digit = str.charAt(i) - 48;
                count += (digit != 0 && (N%digit) == 0) ? 1 : 0;
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}