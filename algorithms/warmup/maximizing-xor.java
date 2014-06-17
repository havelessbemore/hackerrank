//https://www.hackerrank.com/challenges/maximizing-xor
//See: https://www.hackerrank.com/contests/w1/challenges/maximizing-xor
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short L = Short.parseShort(br.readLine());
        short R = Short.parseShort(br.readLine());
        short out = maxXor(L, R);
        System.out.print(out);
    }

    private static short maxXor(short L, short R) {
        short max = 0;
        while (L != R){
            L >>= 1;
            R >>= 1;
            max = (short)((max << 1) + 1);
        }
        return max;
    }
}