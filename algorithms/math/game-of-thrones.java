//https://www.hackerrank.com/challenges/game-of-thrones
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        int N = 26;
        int OFFSET = 97;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[N];
        
        //Count character occurrences
        char[] chars = br.readLine().toCharArray();
        for(char c : chars){
            count[c - OFFSET]++;
        }
        
        //Make sure each character occurs an even number of times
        //Except for one if the string's length is odd
        boolean isPalindrome = true;
        boolean isOddCharFound = false;
        boolean isEvenLength = (chars.length & 1) == 0;
        for(int v : count){
            if ((v&1) == 1){
                if (isEvenLength || isOddCharFound){
                    isPalindrome = false;
                    break;
                }
                isOddCharFound = true;
            }
        }
        System.out.print(isPalindrome ? "YES" : "NO");
    }
}