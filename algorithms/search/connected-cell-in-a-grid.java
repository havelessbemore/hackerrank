//https://www.hackerrank.com/challenges/connected-cell-in-a-grid
import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
  
    //Get input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final byte Y = Byte.parseByte(br.readLine());
    final byte X = Byte.parseByte(br.readLine());
    final byte[][] M = new byte[Y][X];
    for(byte y = 0; y < Y; ++y){
      final String[] line = br.readLine().split(" ");
      for(byte x = 0; x < X; ++x){
        M[y][x] = Byte.parseByte(line[x]);
      }
    }
    br.close();
    
    //Go through the matrix
    byte maxRegionSize = 0;
    for(byte y = 0; y < Y; ++y){
      for(byte x = 0; x < X; ++x){
      
        //Find regions and keep track of largest size
        if(M[y][x] > 0){
          maxRegionSize = (byte)Math.max(maxRegionSize, getRegionSize(M, y, x, Y, X));
        }
      }
    }

    //Print output
    System.out.print(maxRegionSize);
  }

  private static byte getRegionSize(final byte[][] M, final byte y, final byte x, final byte Y, final byte X){
    byte count = 0;

    M[y][x] = 0;
    final Queue<Point> Q = new LinkedList<Point>();
    Q.add(new Point(y, x));

    do{
      ++count;
      Point p = Q.poll();
      if(p.y > 0){
        if(p.x > 0 && M[p.y-1][p.x-1] > 0){
          Q.add(new Point((byte)(p.y-1), (byte)(p.x-1)));
          M[p.y-1][p.x-1] = 0;
        }
        if(M[p.y-1][p.x] > 0){
          Q.add(new Point((byte)(p.y-1), (byte)(p.x)));
          M[p.y-1][p.x] = 0;
        }
        if(p.x+1 < X && M[p.y-1][p.x+1] > 0){
          Q.add(new Point((byte)(p.y-1), (byte)(p.x+1)));
          M[p.y-1][p.x+1] = 0;
        }
      }

      if(p.x > 0 && M[p.y][p.x-1] > 0){
        Q.add(new Point((byte)(p.y), (byte)(p.x-1)));
        M[p.y][p.x-1] = 0;
      }
      if(p.x+1 < X && M[p.y][p.x+1] > 0){
        Q.add(new Point((byte)(p.y), (byte)(p.x+1)));
        M[p.y][p.x+1] = 0;
      }

      if(p.y+1 < Y){
        if(p.x > 0 && M[p.y+1][p.x-1] > 0){
          Q.add(new Point((byte)(p.y+1), (byte)(p.x-1)));
          M[p.y+1][p.x-1] = 0;
        }
        if(M[p.y+1][p.x] > 0){
          Q.add(new Point((byte)(p.y+1), (byte)(p.x)));
          M[p.y+1][p.x] = 0;
        }
        if(p.x+1 < X && M[p.y+1][p.x+1] > 0){
          Q.add(new Point((byte)(p.y+1), (byte)(p.x+1)));
          M[p.y+1][p.x+1] = 0;
        }
      }
    } while (!Q.isEmpty());
    
    return count;
  }
  
  private static class Point{
    public final byte y;
    public final byte x;
    public Point(final byte y, final byte x){
      this.y = y;
      this.x = x;
    }
  }
}
