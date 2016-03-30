//https://www.hackerrank.com/challenges/maximum-element
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        final StringBuffer sb = new StringBuffer();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each query...
        int max = 0;
        final Deque<StackEntry> stack = new ArrayDeque<StackEntry>();
        for(int N = Integer.parseInt(br.readLine()); N > 0; --N){
            
            //Get input
            final String[] line = br.readLine().split(" ");
            final byte type = Byte.parseByte(line[0]);
            
            //Push a new element onto the stack, keeping track of current max
            if(type == 1){
                final int x = Integer.parseInt(line[1]);
                stack.push(new StackEntry(x, (x > max) ? max = x : max));
            
            //Delete the top element of the stack
            } else if(type == 2){
                stack.pop();
                max = (stack.isEmpty()) ? 0 : stack.peek().max;
            
            //Print the maximum element in the stack
            } else if(type == 3){
                sb.append(max + "\n");
            }
        }
        System.out.print(sb);
    }
    
    private static class StackEntry{
        public final int val;
        public final int max;
        public StackEntry(final int val, final int max){
            this.val = val;
            this.max = max;
        }
    }
}
