//https://www.hackerrank.com/challenges/power-of-large-numbers
import java.io.*;

public class Solution {
    private final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(Byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            byte[] A = strToBigInt(temp[0]);
            byte[] B = strToBigInt(temp[1]);
            temp = null;
            int Am = bigIntModInt(A, MOD);
            int Bm = bigIntModInt(B, MOD - 1);
            int C = pow(Am, Bm, MOD);
            sb.append(C + "\n");
        }
        System.out.print(sb);
    }
    private static byte[] strToBigInt(String s){
        char[] chars = s.toCharArray();
        int n = chars.length;
        byte[] bytes = new byte[n];
        for(int i = 0; i < n; ++i){
            bytes[i] = (byte)(chars[i] - '0');
        }
        return bytes;
    }
    private static int bigIntModInt(byte[] ar, int mod){
        int n = ar.length;
        long r = ar[0] % mod;
        for(int i = 1; i < n; r = (10*r + ar[i++]) % mod){}
        return (int)r;
    }
    private static int pow(int A, int B, int M){
        if (B < 2){
            return (B < 1) ? 1 : A % M;
        }
        long C = pow(A, B>>1, M);
        C = (C*C) % M;
        return ((B&1) == 0) ? (int)C : (int)((C*A)%M);
    }
}
