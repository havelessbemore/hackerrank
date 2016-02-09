//https://www.hackerrank.com/challenges/extra-long-factorials
import java.io.*;
import java.math.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Get input
        final byte N = Byte.parseByte(br.readLine());
        
        //Get factorial
        BigInteger factorial = BigInteger.ONE;
        for(byte i = 1; i < N; factorial = factorial.multiply(BigInteger.valueOf(++i))){}
        
        //Print factorial
        System.out.print(factorial);
    }
}
