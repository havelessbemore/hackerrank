//https://www.hackerrank.com/challenges/game-of-thrones
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(isPalindromePermutation(br.readLine()) ? "YES" : "NO");
        br.close();
    }
    
    // Check if input is permutation of a palindrome
    // For definition of a palindrome, see: https://en.wikipedia.org/wiki/Palindrome
    private static boolean isPalindromePermutation(String str){
        char[] chars = str.toCharArray();
        
        //Track even-ness of letters
        int bits = 0;
        
        //For every character in the input string
        //Get the character's ASCII code and update bits
        int strLen = chars.length;
        for(int i = 0; i < strLen; bits = bits ^ (1 << (chars[i++] - 'a'))){}
        
        //Check if palindrome:
        //   - Iff str length is even, no letter can appear an odd amount of times
        //   - Iff str length is odd, one letter must appear an odd amount of times
        return (bits & (bits - (strLen & 1))) == 0;
    }
}
