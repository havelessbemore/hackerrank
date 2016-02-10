//https://www.hackerrank.com/challenges/and-product
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //For each test
    for(short T = Short.parseShort(br.readLine()); T > 0; --T){

      //Get input
      String[] line = br.readLine().split(" ");
      final long A = Long.parseLong(line[0]);
      final long B = Long.parseLong(line[1]);
      
      //Get output
      long C = B - A;
      for(long t = C; (t = C & (C-1)) > 0; C = t){}
      C = A & B & -(C << 1);
      
      //Print output
      sb.append(C).append("\n");
    }
    System.out.print(sb);
  }
}
