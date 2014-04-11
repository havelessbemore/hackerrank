//https://www.hackerrank.com/challenges/keyword-transposition-cipher
import java.io.*;
import java.util.*;
public class Solution {
    private final static byte ALPHABET_SIZE = 26;
    private final static char ALPHABET_ASCII_OFFSET = 'A';
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int N = Integer.parseInt(br.readLine()); N > 0; --N){
            //Get Input
            char[] keyword = br.readLine().toCharArray();
            char[] ciphertext = br.readLine().toCharArray();
            //Get Unique Characters
            byte numChars = 0;
            Map<Byte, Byte> map = new TreeMap<Byte, Byte>();
            for(char c : keyword){
                byte b = (byte)(c - ALPHABET_ASCII_OFFSET);
                if (!map.containsKey(b)){
                    map.put(b, numChars++);
                }
            }
            //Get Substitution Alphabet
            byte subLength = (byte)(ALPHABET_SIZE - numChars);
            byte[] subAlphabet = new byte[subLength];
            byte i = 0;
            byte k = 0;
            for(byte b : map.keySet()){
                while (k < b){
                    subAlphabet[i++] = k++;
                }
                ++k;
            }
            while (i < subLength){
                subAlphabet[i++] = k++;
            }
            //Reverse Cipher
            char j = ALPHABET_ASCII_OFFSET;
            char[] alphabet = new char[ALPHABET_SIZE];
            for(byte b : map.keySet()){
                alphabet[b] = j++;
                for(i = map.get(b); i < subLength; i += numChars){
                    alphabet[subAlphabet[i]] = j++;
                }
            }
            //Output original message
            for(char c : ciphertext){
                sb.append(c == ' ' ? ' ' : alphabet[c - ALPHABET_ASCII_OFFSET]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}