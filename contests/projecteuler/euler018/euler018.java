//https://www.hackerrank.com/contests/projecteuler/challenges/euler018
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //For each test case
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
        
      //Get triangle
      final byte N = Byte.parseByte(br.readLine());
      final byte[][] triangle = new byte[N][];
      for(byte n = 0; n < N; ++n){
        byte i = 0;
        triangle[n] = new byte[n+1];
        for(String s : br.readLine().split(" ")){
          triangle[n][i++] = Byte.parseByte(s);
        }
      }
      
      //Initialize max sums to last row
      final int[] sums = new int[N];
      for(int i = 0, n = N - 1; i <= n; ++i){
        sums[i] = triangle[n][i];
      }
      
      //Get max sums from bottom to top of triangle
      for(int y = N - 2; y >= 0; --y){
        for(int x = 0; x <= y; ++x){
          sums[x] = triangle[y][x] + Math.max(sums[x], sums[x+1]);
        }
      }
      
      //Output max sum
      sb.append(String.format("%d\n", sums[0]));
    }
    
    //Print output
    System.out.print(sb);
  }
}
