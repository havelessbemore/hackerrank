//https://www.hackerrank.com/challenges/flipping-bits
import java.io.*;

public class Solution {
  private static final long MASK = (1L << 32L) - 1L;
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //For each test
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      
      //Get input
      long N = Long.parseLong(br.readLine());
      
      //Print output
      sb.append(N ^ MASK).append("\n");
    }
    System.out.print(sb);
  }
}
