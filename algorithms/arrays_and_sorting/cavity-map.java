//https://www.hackerrank.com/challenges/cavity-map
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final byte N = Byte.parseByte(br.readLine());
        final char[][] matrix = new char[N][N];
        for(byte y = 0; y < N; matrix[y++] = br.readLine().toCharArray()){}
        br.close();
        br = null;
        
        //SOLVE
        
        //No cavity can be on the edge of
        //the matrix, so start at index 1
        //and end at index N-1 for y and x
        final byte MAX = (byte)(N-1);
        for(byte y = 1; y < MAX; ++y){
            for(byte x = 1; x < MAX; ++x){
                final char cur = matrix[y][x];
                if (cur > matrix[y-1][x] 
                 && cur > matrix[y][x+1]
                 && cur > matrix[y+1][x]
                 && cur > matrix[y][x-1]
                ){
                    //Take advantage that numbers
                    //come before alphabet; 'X' > '9'
                    matrix[y][x] = 'X';
                }
            }
        }
        
        //OUTPUT
        final StringBuffer sb = new StringBuffer();
        for(byte y = 0; y < N;){
            sb.append(matrix[y]);
            if (++y < N){
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
