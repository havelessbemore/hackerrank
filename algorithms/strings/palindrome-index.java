//https://www.hackerrank.com/challenges/palindrome-index
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            final char[] C = br.readLine().toCharArray();
            final int N = C.length;
            int c = -1;
            for(int i = 0, j = N-1; i < j; ++i, --j){
                if (C[i] != C[j]){
                    c = isPalindrome(C, i+1, j+1) ? i : j;
                    break;
                }
            }
            sb.append(c + "\n");
        }
        System.out.print(sb);
    }
    
    private static boolean isPalindrome(final char[] C, final int A, final int B){
        for(int i = A, j = B-1; i < j; ++i, --j){
            if (C[i] != C[j]){
                return false;
            }
        }
        return true;
    }
}
