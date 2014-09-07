//https://www.hackerrank.com/challenges/cavity-map
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Input
        byte N = Byte.parseByte(br.readLine());
        char[][] matrix = new char[N][];
        for(byte i = 0; i < N; ++i){
            matrix[i] = br.readLine().toCharArray();
        }
        
        //Solve
        
        //Find cavities
        int max = N-1;
        List<Byte> cavX = new ArrayList<Byte>();
        List<Byte> cavY = new ArrayList<Byte>();
        for(byte y = 1; y < max; ++y){
            for(byte x = 1; x < max; ++x){
                char depth = matrix[y][x];
                if (depth > matrix[y-1][x]
                    && depth > matrix[y+1][x]
                    && depth > matrix[y][x-1]
                    && depth > matrix[y][x+1]
                ){
                    cavY.add(y);
                    cavX.add(x);
                }
            }
        }
        
        //Mark cavities
        int size = cavY.size();
        for(int i = 0; i < size; ++i){
            matrix[cavY.get(i)][cavX.get(i)] = 'X';
        }
        
        //Output
        StringBuffer sb = new StringBuffer();
        for(byte i = 0; i < N; ++i){
            sb.append(new String(matrix[i]));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
