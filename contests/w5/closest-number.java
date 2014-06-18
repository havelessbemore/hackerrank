//Week 5, Tuesday
//https://www.hackerrank.com/contests/w5/challenges/closest-number
import java.io.*;
import java.util.*;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case
        for (int T = Integer.parseInt(br.readLine()); T > 0; --T){
            
            //Get input
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            
            //Solve
            sb.append(solve(a, b, x) + "\n");
        }
        
        //Print
        System.out.print(sb);
    }
    
    private static int solve(int a, int b, int x){
        // Constraints:
        // 1 <= a <= 10^9
        // -10^9 <= b <= 10^9
        // 0 < a^b <= 10^9
        // 1 <= x <= 10^9

        //If a = 1 or b = 0, a^b = 1.
        //The only way x can be closer
        //to 1 than 0 is if x = 1
        if (a == 1 || b == 0){
            return (x == 1) ? 1 : 0;
        }
        
        //If a != 1 and b < 0, a^b is a fraction
        //The minimum closest value is always 0
        if (b < 0){
            return 0;
        }
        
        //Calculate
        int ab = pow(a, b);
        
        if (x == a || x == ab){
            return ab;
        }
        
        //Get remainder (mod) of ab/x.
        //If we're more than halway to
        //the next multiple of x, round up.
        //Otherwise, round down.
        int mod = ab % x;
        return (mod > x/2.0) ? ab + (x - mod) : ab - mod; 
    }
    
    //For practice, implemented pow method
    //that avoids casting (assumes int result)
    //and recursion. Assumes b > 0.
    private static int pow(int a, int b){
        //Get max bit set of b
        byte bit = (byte)Math.floor(Math.log(b)/Math.log(2));
        //Get product
        int prod = 1;
        for(int mask = 1 << bit; mask > 0; mask >>= 1){
            prod *= ((b & mask) == 0) ? prod : prod * a;
        }
        return prod;
    }
}