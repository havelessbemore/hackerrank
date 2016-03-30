//https://www.hackerrank.com/challenges/arrays-ds
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        //Get input
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final short N = Short.parseShort(br.readLine());
        final short[] A = toShortArray(br.readLine().split(" "), N);
        
        //Print output
        for(int i = N; i > 0; System.out.print(A[--i] + " ")){}
    }
    
    private static short[] toShortArray(final String[] A, final int N){
        final short[] B = new short[N];
        for(int i = 0; i < N; ++i){
            B[i] = Short.parseShort(A[i]);
        }
        return B;
    }
}
