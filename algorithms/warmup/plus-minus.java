//https://www.hackerrank.com/challenges/plus-minus
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
    //Get array size
    final int N = Integer.parseInt(br.readLine());
    
    //Get integers and analyze
    int numPos = 0;
    int numZero = 0;
    int numNeg = 0;
    for(String s : br.readLine().split(" ")){
      int v = Integer.parseInt(s);
      if(v > 0){
        ++numPos;
      } else if (v < 0){
        ++numNeg;
      } else {
        ++numZero;
      }
    }
    
    //Print fractions
    System.out.println(1.0*numPos / N);
    System.out.println(1.0*numNeg / N);
    System.out.println(1.0*numZero / N);
  }
}
