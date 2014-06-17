//https://www.hackerrank.com/contests/w5/challenges/even-odd-query
import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Get input array A
        int N = Integer.parseInt(br.readLine());
        byte[] A = new byte[N];
        String[] T = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            A[i] = Byte.parseByte(T[i]);
        }
        
        //For each query
        for(int Q = Integer.parseInt(br.readLine()); Q > 0; --Q){
            
            //Get input
            T = br.readLine().split(" ");
            int X = Integer.parseInt(T[0]) - 1;
            int Y = Integer.parseInt(T[1]) - 1;
            
            //Solve
            //Explanation:
            //   even*even = even
            //   odd*odd = odd
            //   even*even*even... = even ^ Y = even
            //   odd*odd*odd...    = odd ^ Y  = odd
            //   X ^ Y ^ 0 = X ^ 1 = X
            //Exception: [even/odd] ^ 0 = 1 = odd
            
            //Get result
            //Odd iff power is zero or base is odd
            //Even iff power is not zero and base is even
            byte base = A[X];
            byte power = (X == Y) ? 1 : A[X+1];
            sb.append((power == 0 || (base & 1) == 1) ? "Odd\n" : "Even\n");
        }
        
        //Print
        System.out.print(sb);
    }
}