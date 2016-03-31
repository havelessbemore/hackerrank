//https://www.hackerrank.com/challenges/simple-text-editor
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        //I/O
        final StringBuilder sb = new StringBuilder();
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each query...
        final StringBuilder S = new StringBuilder();
        final Deque<Query> stack = new ArrayDeque<Query>();
        for(int Q = Integer.parseInt(br.readLine()); Q > 0; --Q){
            
            //Get query
            final String[] line = br.readLine().split(" ");
            final byte T = Byte.parseByte(line[0]);
            
            //Perform Get
            if(T == 3){
                final int k = Integer.parseInt(line[1]) - 1;
                sb.append(S.charAt(k) + "\n");
            
            //Perform Undo
            } else if(T == 4){
                stack.pop().undo().perform(S);
                
            //Perform Append / Erase
            } else {
                final Query q = (T == 1) ? 
                    new Append(line[1]) : 
                    new Erase(S.substring(S.length() - Integer.parseInt(line[1])));
                q.perform(S);
                stack.push(q);
            }
        }
        
        //Print output
        System.out.print(sb);
    }
    
    private static abstract class Query {
        protected final String w;
        public Query(final String w){
            this.w = w;
        }
        public abstract void perform(final StringBuilder S);
        public abstract Query undo();
    }
    
    private static class Append extends Query {
        public Append(final String w){
            super(w);
        }
        public void perform(final StringBuilder S){
            S.append(this.w);
        }
        public Erase undo(){
            return new Erase(this.w);
        }
    }
    
    private static class Erase extends Query {
        public Erase(final String w){
            super(w);
        }
        public void perform(final StringBuilder S){
            final int len = S.length();
            S.delete(len - this.w.length(), len);
        }
        public Append undo(){
            return new Append(this.w);
        }
    }
}
