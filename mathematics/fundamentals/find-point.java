//https://www.hackerrank.com/challenges/find-point
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            final int px = Integer.parseInt(temp[0]);
            final int py = Integer.parseInt(temp[1]);
            final int qx = Integer.parseInt(temp[2]);
            final int qy = Integer.parseInt(temp[3]);
            
            //SOLVE
            final int dx = qx - px;
            final int dy = qy - py;
            final int rx = qx + dx;
            final int ry = qy + dy;
            
            //OUTPUT
            sb.append(rx + " " + ry + "\n");
        }
        System.out.print(sb);
    }
}
