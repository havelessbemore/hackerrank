//https://www.hackerrank.com/challenges/grid-challenge
import java.io.*;
import java.util.Arrays;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //For each test case
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){

      //Get input
      final byte N = Byte.parseByte(br.readLine());
      final char[][] G = new char[N][];
      for(int y = 0; y < N; G[y++] = br.readLine().toCharArray());
      
      //Sort rows
      for(int y = 0; y < N; Arrays.sort(G[y++])){}
      
      //Check if columns are sorted
      boolean isSorted = true;
      for(int x = 0; x < N; ++x){
        for(int y = 1; y < N; ++y){
          if(G[y][x] < G[y-1][x]){
            x = N;
            isSorted = false;
            break;
          }
        }
      }
      
      //Print output
      sb.append(isSorted ? "YES\n" : "NO\n");
    }
    System.out.print(sb);
  }
}
