//https://www.hackerrank.com/challenges/kaprekar-numbers
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Get inputs
        final int P = Integer.parseInt(br.readLine());
        final int Q = Integer.parseInt(br.readLine());
        
        //Create array to store Kaprekar Numbers
        ArrayList<Integer> kaprekars = new ArrayList<Integer>();
        
        //Find Kaprekar numbers between P and Q (inclusive)
        for(int i = P; i <= Q; ++i){
            long sqI = (1L*i)*i;
            int divisor = (int)Math.pow(10, Math.floor(Math.log10(i)) + 1);
            int left = (int)Math.floor(sqI / divisor);
            int right = (int)(sqI % divisor);
            if(left + right == i){
                kaprekars.add(i);
            }
        }
        
        //Output Kaprekar numbers
        if(kaprekars.size() < 1){
            System.out.print("INVALID RANGE");
        } else {
            StringBuffer sb = new StringBuffer();
            for(Integer k : kaprekars){
                sb.append(k).append(" ");
            }
            System.out.print(sb);
        }
    }
}
