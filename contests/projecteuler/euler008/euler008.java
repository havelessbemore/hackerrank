//https://www.hackerrank.com/contests/projecteuler/challenges/euler008
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get input
            String[] line = br.readLine().split(" ");
            final short N = Short.parseShort(line[0]);
            final byte K = Byte.parseByte(line[1]);
            final byte[] A = toByteArray(br.readLine().toCharArray());
            
            //Initialize 'product' to product of first K values
            //Do not multiply by zero but keep track of how many encountered
            int product = 1;
            short numZeros = 0;
            int maxProduct = 0;
            for(short i = 0; i < K; ++i){
                if(A[i] == 0){
                    ++numZeros;
                } else {
                    product *= A[i];
                }
            }
            
            //If the product is valid (there are no zeros in it), it's our current max product
            if(numZeros < 1){
                maxProduct = product;
            }
            
            //Go through the remainder of A...
            for(short i = K; i < N; ++i){
                final short j = (short)(i-K);
                
                //Divide from product the value now outside the current subset
                if(A[j] == 0){
                    --numZeros;
                } else {
                    product /= A[j];
                }
                
                //Multiply into product the value now inside the current subset
                if(A[i] == 0){
                    ++numZeros;
                } else {
                    product *= A[i];
                }
                
                //Update maxProduct if the current product is valid and the biggest so far
                if(product > maxProduct && numZeros < 1){
                    maxProduct = product;
                }
            }
            
            //Print output
            sb.append(maxProduct + "\n");
        }
        System.out.print(sb);
    }
    
    private static byte[] toByteArray(final char[] A){
        final int N = A.length;
        final byte[] B = new byte[N];
        for(int i = 0; i < N; ++i){
            B[i] = (byte)(A[i] - '0');
        }
        return B;
    }
}
