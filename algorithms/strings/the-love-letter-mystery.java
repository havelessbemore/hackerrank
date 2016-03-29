//https://www.hackerrank.com/challenges/the-love-letter-mystery
//https://www.hackerrank.com/contests/w3/challenges/the-love-letter-mystery
import java.io.*;

public class Solution {

  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //For each test case
    for(byte t = Byte.parseByte(br.readLine()); t > 0; --t){
      
      //Get input
      final char[] str = br.readLine().toCharArray();
      
      //Solve
      int numOps = 0;
      for(short i = 0, j = (short)(str.length-1); i < j; numOps += Math.abs(str[i++] - str[j--])){}
      
      //Print output
      sb.append(numOps + "\n");
    }
    System.out.print(sb);
  }
}
