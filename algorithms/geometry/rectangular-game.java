//https://www.hackerrank.com/challenges/rectangular-game
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte N = Byte.parseByte(br.readLine());
        int[] Ys = new int[N];
        int[] Xs = new int[N];
        for(byte i = 0; i < N; ++i){
            String[] input = br.readLine().split(" ");
            Ys[i] = Integer.parseInt(input[0]);
            Xs[i] = Integer.parseInt(input[1]);
        }
        
        //SOLVE
        long numXs = ((long)min(Ys))*min(Xs);
        
        //OUTPUT
        System.out.print(numXs);
    }
    
    private static int min(int[] arr){
        int min = arr[0];
        int n = arr.length;
        for(int i = 1; i < n; ++i){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
}
