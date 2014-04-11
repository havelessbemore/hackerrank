//https://www.hackerrank.com/challenges/changing-bits
import java.io.*;

public class Solution {
    private static final byte BITS_PER_INDEX = 63;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Get numbers
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int Q = Integer.parseInt(temp[1]);
        int I = (N + BITS_PER_INDEX)/BITS_PER_INDEX;
        long[] A, B, C;
        strToNum(A = new long[I], br.readLine());
        strToNum(B = new long[I], br.readLine());
        C = new long[I];
        //Process queries
        for(boolean isDirty = true; Q > 0; --Q){
            temp = br.readLine().split(" ");
            String command = temp[0];
            int idx = Integer.parseInt(temp[1]);
            if ("get_c".equals(command)){
                if (isDirty){
                    add(A, B, C, I);
                    isDirty = false;
                }
                sb.append(get(C, idx));
            } else {
                byte x = Byte.parseByte(temp[2]);
                set("set_a".equals(command) ? A : B, idx, x);
                isDirty = true;
            }
        }
        System.out.print(sb);
    }
    private static void add(long[] A, long[] B, long[] C, int I){
        byte remainder = 0;
        for(int i = 0; i < I; i++){
            C[i] = A[i] + B[i] + remainder;
            remainder = (byte)((C[i] >> BITS_PER_INDEX) & 1L);
        }
    }
    private static void strToNum(long[] ar, String str){
        int i = 0;
        int N = str.length();
        for(int c = N; N >= BITS_PER_INDEX; N -= BITS_PER_INDEX){
            ar[i++] = Long.parseLong(str.substring(N - BITS_PER_INDEX, N), 2);
        }
        if (N > 0){
            ar[i] = Long.parseLong(str.substring(0, N), 2);
        }
    }
    private static byte get(long[] ar, int bit){
        int i = bit/BITS_PER_INDEX;
        bit = bit % BITS_PER_INDEX;
        return (byte)((ar[i] >> bit) & 1L);
    }
    private static void set(long[] ar, int bit, byte val){
        int i = bit/BITS_PER_INDEX;
        bit = bit % BITS_PER_INDEX;
        ar[i] = (val == 0) ? ar[i] & ~(1L << bit) : ar[i] | (1L << bit);
    }
    /*
    private static void print(long[] ar, StringBuffer sb){
        for(int i = ar.length; i > 0; sb.append(Long.toString(ar[--i], 2) + " ")){}
        sb.append("\n");
    }
    */
}