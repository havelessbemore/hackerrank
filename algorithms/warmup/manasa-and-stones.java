//https://www.hackerrank.com/challenges/manasa-and-stones
//See: https://www.hackerrank.com/contests/w2/challenges/manasa-and-stones
import java.io.*;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            short N = Short.parseShort(br.readLine());
            short A = Short.parseShort(br.readLine());
            short B = Short.parseShort(br.readLine());

            if (A > B){
                short temp = A;
                A = B;
                B = temp;
            }

            int val = ((int)--N)*A;
            short dval = (short)(B - A);

            sb.append(val);
            if (dval > 0){
                while(N-- > 0){
                    sb.append(" " + (val += dval));
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}