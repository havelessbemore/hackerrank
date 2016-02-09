//https://www.hackerrank.com/challenges/matrix-rotation-algo
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Get input
    String[] line = br.readLine().split(" ");
    final short Y = Short.parseShort(line[0]);
    final short X = Short.parseShort(line[1]);
    final int R = Integer.parseInt(line[2]);

    //Get matrix
    final int[][] matrix = new int[Y][X];
    for(short y = 0; y < Y; ++y){
      line = br.readLine().split(" ");
      for(short x = 0; x < X; ++x){
        matrix[y][x] = Integer.parseInt(line[x]);
      }
    }

    //For each ring
    for(short ringNum = 0, numRings = (short)(Math.min(Y, X) >> 1); ringNum < numRings; ++ringNum){
      short maxY = (short)(Y - ringNum - 1);
      short maxX = (short)(X - ringNum - 1);
      short ringLen = (short)((maxY + maxX - (ringNum << 1)) << 1);
      int[] ring = new int[ringLen];
      
      //Unwrap ring
      short i = 0;
      for(int x = ringNum; x <= maxX; ring[i++] = matrix[ringNum][x++]){}
      for(int y = ringNum; y < maxY; ring[i++] = matrix[++y][maxX]){}
      for(int x = maxX; x > ringNum; ring[i++] = matrix[maxY][--x]){}
      for(int y = maxY; --y > ringNum; ring[i++] = matrix[y][ringNum]){}

      //Rotate ring
      ring = rotate(ring, ringLen, R);

      //Wrap ring
      i = 0;
      for(int x = ringNum; x <= maxX; matrix[ringNum][x++] = ring[i++]){}
      for(int y = ringNum; y < maxY; matrix[++y][maxX] = ring[i++]){}
      for(int x = maxX; x > ringNum; matrix[maxY][--x] = ring[i++]){}
      for(int y = maxY; --y > ringNum; matrix[y][ringNum] = ring[i++]){}
    }

    //Print matrix
    System.out.print(matrixToStringBuffer(matrix, Y, X));
  }

  private static int[] rotate(int[] A, int len, int rotations){
    int i = 0;
    rotations %= len;
    int[] B = new int[len];
    for(int j = rotations; j < len; B[i++] = A[j++]){}
    for(int j = 0; i < len; B[i++] = A[j++]){}
    return B;
  }
  
  private static StringBuffer matrixToStringBuffer(int[][] matrix, int Y, int X){
    StringBuffer sb = new StringBuffer();
    for(int y = 0; y < Y; ++y){
      for(int x = 0; x < X; sb.append(matrix[y][x++]).append(" ")){}
      sb.append("\n");
    }
    return sb;
  }
}
