//https://www.hackerrank.com/challenges/special-multiple
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            long v;
            final short N = Short.parseShort(br.readLine());
            for(long i = 1; (v = to9ary(i)) % N != 0; ++i){}
            sb.append(v + "\n");
        }
        System.out.print(sb);
    }
    private static long to9ary(long n){
        long v = 0;
        long m = 9;
        while (n > 0){
            if ((n & 1) == 1){
                v += m;
            }
            n >>= 1;
            m *= 10;
        }
        return v;
    }
}
