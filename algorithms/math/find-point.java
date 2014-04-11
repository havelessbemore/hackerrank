//https://www.hackerrank.com/challenges/find-point
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            int px = Integer.parseInt(temp[0]);
            int py = Integer.parseInt(temp[1]);
            int qx = Integer.parseInt(temp[2]);
            int qy = Integer.parseInt(temp[3]);
            int dx = qx - px;
            int dy = qy - py;
            int rx = qx + dx;
            int ry = qy + dy;
            sb.append(rx + " " + ry + "\n");
        }
        System.out.print(sb);
    }
}