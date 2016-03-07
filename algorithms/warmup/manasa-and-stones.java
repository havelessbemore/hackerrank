//https://www.hackerrank.com/challenges/manasa-and-stones
//See: https://www.hackerrank.com/contests/w2/challenges/manasa-and-stones
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get input
            short N = Short.parseShort(br.readLine());
            short A = Short.parseShort(br.readLine());
            short B = Short.parseShort(br.readLine());

            //Make sure A <= B
            if (A > B){
                A ^= B;
                B ^= A;
                A ^= B;
            }
            
            //Find the minimum value the last stone could be
            int val = (N - 1) * A;
            sb.append(val);
            
            //Find the other values the last stone could be in increasing order
            if(A != B){
                for(final short dval = (short)(B - A); --N > 0; sb.append(" " + (val += dval))){}
            }
            
            //Print output
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
