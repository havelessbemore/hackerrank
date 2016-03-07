//https://www.hackerrank.com/contests/projecteuler/challenges/euler006
import java.io.*;

public class Solution {
  
  final private static short MAX = 10000;
  
  public static void main(String[] args) throws IOException {
    
    //Construct all possible outputs
    final long[] vals = new long[MAX + 1];
    for(short i = 2; i <= MAX; ++i){
      vals[i] = vals[i-1] + (i-1L)*i*i;
    }
    
    //For each test case
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for(short T = Short.parseShort(br.readLine()); T > 0; --T){
      
      //Get input
      final short N = Short.parseShort(br.readLine());
      
      //Print output
      sb.append(vals[N] + "\n");
    }
    System.out.print(sb);
  }
}
