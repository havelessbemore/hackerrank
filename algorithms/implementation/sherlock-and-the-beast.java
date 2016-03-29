//https://www.hackerrank.com/challenges/sherlock-and-the-beast
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        byte[] mults = new byte[]{0, 2, 4, 1, 3, 0, 2, 4, 1, 3};
        for(int T = Integer.parseInt(br.readLine()); T > 0; T--){
            String S = br.readLine();
            int N = Integer.parseInt(S);
            
            //See how many groups of 5 to remove
            int G = mults[S.charAt(S.length()-1) - 48];
            N -= 3*G;
            
            //If number too small
            if (N < 0){
                sb.append("-1\n");
                continue;
            }
            
            //Append groups of 5
            for(G += 5*(N/15); G > 0; G--){
                sb.append("555");
            }
            
            //Append groups of 3
            for(G = (N%15)/5; G > 0; G--){
                sb.append("33333");
            }
            
            //Append newline
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}