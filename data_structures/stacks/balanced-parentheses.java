//https://www.hackerrank.com/challenges/balanced-parentheses
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case...
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            
            //Get input
            final char[] S = br.readLine().toCharArray();
            
            //Print output
            sb.append((isBalanced(S)) ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
    
    private static boolean isBalanced(final char[] A){
        final Deque<Character> stack = new ArrayDeque<Character>();
        
        //For each character...
        for(int i = 0, n = A.length; i < n; ++i){
            
            //Get character
            final char c = A[i];
            
            //Check if opening a parenthesis
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
                continue;
            }
            
            //Check if closing without any open parenthesis
            if(stack.isEmpty()){
                return false;
            }
            
            //Check if closing without matching open parenthesis
            //Remove parenthesis from stack if closed correctly
            final char p = stack.pop();
            if((c == '}' && p != '{') || 
               (c == ']' && p != '[') || 
               (c == ')' && p != '(')){
                return false;
            }
        }
        
        //Check if all parentheses closed correctly
        return stack.isEmpty();
    }
}
