//https://www.hackerrank.com/challenges/anagram
import java.io.*;

public class Solution {
    private static final byte ALPHABET_LENGTH = 26;
    private static final byte ASCII_ALPHABET_OFFSET = 97;
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            short numChanges = -1;
            char[] ab = br.readLine().toCharArray();
            short max = (short)ab.length;
            if((max & 1) == 0){
                numChanges = 0;
                short mid = (short)(max >> 1);
                short[] map = new short[ALPHABET_LENGTH];
                for(short i = mid; i < max; map[ab[i++] - ASCII_ALPHABET_OFFSET]++){}
                for(short i = 0; i < mid; numChanges += (map[ab[i++] - ASCII_ALPHABET_OFFSET]-- > 0) ? 0 : 1){}
            }
            sb.append(numChanges + "\n");
        }
        System.out.print(sb);
    }
}