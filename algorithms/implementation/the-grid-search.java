//https://www.hackerrank.com/challenges/the-grid-search
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //For each test
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      
      //Get grid
      String[] s = br.readLine().split(" ");
      short Y = Short.parseShort(s[0]);
      short X = Short.parseShort(s[1]);
      final char[][] grid = new char[Y][];
      for(short y = 0; y < Y; grid[y++] = br.readLine().toCharArray()){}
      
      //Get pattern
      s = br.readLine().split(" ");
      final short pY = Short.parseShort(s[0]);
      final short pX = Short.parseShort(s[1]);
      final char[][] pattern = new char[pY][];
      for(short y = 0; y < pY; pattern[y++] = br.readLine().toCharArray()){}
      
      //Check if pattern in grid
      sb.append((hasPattern(grid, Y, X, pattern, pY, pX)) ? "YES\n" : "NO\n");
    }
    
    //Print output
    System.out.print(sb);
  }

  //Check if pattern in grid
  private static boolean hasPattern(char[][] grid, short Y, short X, char[][] pattern, short pY, short pX){
    Y -= pY - 1;
    X -= pX - 1;
    for(short y = 0; y < Y; ++y){
      for(short x = 0; x < X; ++x){
        for(short py = 0; py < pY;){
          short px;
          for(px = 0; px < pX && grid[y + py][x + px] == pattern[py][px]; ++px){}
          if(px < pX){
            break;
          }
          if(++py == pY){
            return true;
          }
        }
      }
    }
    return false;
  }
}
