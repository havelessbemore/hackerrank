//https://www.hackerrank.com/challenges/sherlock-and-squares
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //INPUT
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            
            //SOLVE
            int C = (int)(Math.floor(Math.sqrt(B)) - Math.ceil(Math.sqrt(A)) + 1);
            sb.append(C + "\n");
        }
        
        //OUTPUT
        System.out.print(sb);
    }
}
