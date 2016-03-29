//https://www.hackerrank.com/challenges/saveprincess2
import java.io.*;

public class Solution {
    static void nextMove(int n, int m_y, int m_x, String [] grid){
        //Find Peach
        int p_y = -1;
        int p_x = -1;
        do {
            p_x = grid[++p_y].indexOf('p');
        } while (p_x < 0);
        int distance = p_y - m_y;
        if (distance != 0){
            System.out.println(distance < 0 ? "UP" : "DOWN");
        } else if((distance = p_x - m_x) != 0){
            System.out.println(distance < 0 ? "LEFT" : "RIGHT");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int R = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        String[] grid = new String[N];
        for(int i = 0; i < N; grid[i++] = br.readLine()){}
        nextMove(N, R, C, grid);
    }
}
