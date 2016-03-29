//https://www.hackerrank.com/challenges/library-query
import java.io.*;
import java.util.*;

public class Solution {
    
    final private static short MAX_N = 10000;
    final private static short MAX_BOOKS = 1000;
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INITIALIZE ORDER
        short[] sizes = new short[MAX_BOOKS];
        short[][] order = new short[MAX_BOOKS][MAX_N];
        short[] shelves = new short[MAX_N];
        
        //FOR EACH TEST
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //INPUT
            final short N = Short.parseShort(br.readLine());
            String[] input = br.readLine().split(" ");
            for(short i = 0; i < N; ++i){
                shelves[i] = (short)(Short.parseShort(input[i]) - 1);
            }
            
            //FOR EACH QUERY
            for(short Q = Short.parseShort(br.readLine()); Q > 0; --Q){
                input = br.readLine().split(" ");
                final short X = (short)(Short.parseShort(input[1]) - 1);
                
                //READ
                if ("0".equals(input[0])){
                    final short Y = (short)(Short.parseShort(input[2]) - 1);
                    final short K = (short)(Short.parseShort(input[3]) - 1);
                    
                    //SORT
                    for(short i = 0; i < MAX_BOOKS; sizes[i++] = 0){}
                    for(short i = X; i <= Y; ++i){
                        final short numBooks = shelves[i];
                        order[numBooks][sizes[numBooks]++] = i;
                    }
                    
                    //GET KTH
                    short x = 0;
                    for(short i = 0; i < MAX_BOOKS; ++i){
                        short s = sizes[i];
                        if ((x += s) > K){
                            x = order[i][K - (x - s)];
                            break;
                        }
                    }
                    
                    //OUTPUT
                    sb.append((shelves[x] + 1) + "\n");
                
                //UPDATE
                } else /*if("1".equals(input[0]))*/{
                    final short K = (short)(Short.parseShort(input[2]) - 1);
                    shelves[X] = K;
                }
            }
        }
        
        System.out.print(sb);
    }
}
