//https://www.hackerrank.com/challenges/game-of-rotation
import java.io.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Input
        int N = Integer.parseInt(br.readLine());
        int[] blocks = new int[N];
        N = 0;
        for(String s : br.readLine().split(" ")){
            blocks[N++] = Integer.parseInt(s);
        }
        //Solve
    }
}