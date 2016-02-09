//https://www.hackerrank.com/challenges/taum-and-bday
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get inputs
            String[] line = br.readLine().split(" ");
            final int B = Integer.parseInt(line[0]);
            final int W = Integer.parseInt(line[1]);
            line = br.readLine().split(" ");
            int X = Integer.parseInt(line[0]);
            int Y = Integer.parseInt(line[1]);
            final int Z = Integer.parseInt(line[2]);
            
            //Calculate minimum cost
            if(Y+Z < X){
                X = Y+Z;
            } else if(X+Z < Y){
                Y = X+Z;
            }
            long cost = (1L*B*X) + (1L*W*Y);
            
            //Print output
            sb.append(cost).append("\n");
        }
        System.out.print(sb);
    }
}
