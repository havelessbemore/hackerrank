//https://www.hackerrank.com/contests/101sep14/challenges/jim-and-the-skyscrapers
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int[] H = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            H[i] = Integer.parseInt(input[i]);
        }
        
        //SOLVE
        long sum = 0;
        int size = 0;
        final int[] V = new int[N];
        final int[] M = new int[N];
        for(int i = 0; i < N; ++i){
            int h = H[i];
            while (size > 0 && V[size-1] < h){
                --size;
            }
            if (size < 1 || V[size-1] > h){
                V[size] = h;
                M[size++] = 0;
            }
            sum += M[size-1]++;
        }
        
        //OUTPUT
        System.out.print(sum << 1);
    }
}
