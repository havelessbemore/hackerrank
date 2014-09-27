//https://www.hackerrank.com/challenges/restaurant
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            String[] input = br.readLine().split(" ");
            final short L = Short.parseShort(input[0]);
            final short B = Short.parseShort(input[1]);
            
            //SOLVE
            final short factor = gcd(L, B);
            final int pieces = (1*L*B)/(1*factor*factor);
            
            //OUTPUT
            sb.append(pieces + "\n");
        }
        System.out.print(sb);
    }
    
    private static short gcd(short a, short b){
        while (b != 0){
            short c = a;
            a = b;
            b = (short)(c % b);
        }
        return a;
    }
}
