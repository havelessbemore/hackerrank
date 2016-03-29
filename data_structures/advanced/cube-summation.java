//https://www.hackerrank.com/challenges/cube-summation
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] input = br.readLine().split(" ");
            final byte N = Byte.parseByte(input[0]);
            final short M = Short.parseShort(input[1]);
            
            short numPoints = 0;
            final Point3D[] points = new Point3D[M];
            for(short m = 0; m < M; ++m){
                input = br.readLine().split(" ");
                
                //UPDATE
                if (input.length == 5){
                    final byte X = (byte)(Byte.parseByte(input[1]) - 1);
                    final byte Y = (byte)(Byte.parseByte(input[2]) - 1);
                    final byte Z = (byte)(Byte.parseByte(input[3]) - 1);
                    final int W = Integer.parseInt(input[4]);
                    
                    Point3D point = null;
                    for(short i = 0; i < numPoints && point == null; ++i){
                        Point3D p = points[i];
                        if (p.x == X && p.y == Y && p.z == Z){
                            point = p;
                        }
                    }
                    if (point == null){
                        points[numPoints++] = point = new Point3D(X, Y, Z, W);
                    } else {
                        point.w = W;
                    }
                    
                //QUERY
                } else {
                    final byte X1 = (byte)(Byte.parseByte(input[1]) - 1);
                    final byte Y1 = (byte)(Byte.parseByte(input[2]) - 1);
                    final byte Z1 = (byte)(Byte.parseByte(input[3]) - 1);
                    final byte X2 = (byte)(Byte.parseByte(input[4]) - 1);
                    final byte Y2 = (byte)(Byte.parseByte(input[5]) - 1);
                    final byte Z2 = (byte)(Byte.parseByte(input[6]) - 1);
                    long W = 0L;
                    for(short i = 0; i < numPoints; ++i){
                        Point3D p = points[i];
                        if (p.x >= X1 && p.x <= X2
                           && p.y >= Y1 && p.y <= Y2
                           && p.z >= Z1 && p.z <= Z2
                        ){
                            W += p.w;
                        }
                    }
                    
                    //OUTPUT
                    sb.append(W + "\n");
                }
            }
        }
        System.out.print(sb);
    }
    
    public static class Point3D{
        public long w;
        public byte x, y, z;
        public Point3D(byte x, byte y, byte z, long w){
            this.x = x;
            this.y = y;
            this.z = z;
            this.w = w;
        }
    }
}
