//https://www.hackerrank.com/challenges/make-it-anagram
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();
        
        //SOLVE
        int[] diffs = new int['z' - 'a' + 1];
        for(char c : A){
            diffs[c - 'a']++;
        }
        for(char c : B){
            diffs[c - 'a']--;
        }
        int sum = 0;
        for(int diff : diffs){
            sum += (diff < 0) ? -diff : diff;
        }
        
        //OUTPUT
        System.out.print(sum);
    }
}
