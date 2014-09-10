//https://www.hackerrank.com/challenges/sherlock-and-planes
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        
        //INPUT
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            Point3D a = getPoint(br.readLine());
            Point3D b = getPoint(br.readLine());
            Point3D c = getPoint(br.readLine());
            Point3D d = getPoint(br.readLine());
            
            //SOLVE
            boolean isCoplanar = 0 == dotProduct(
                normal(a, b, c), 
                vector(a, d)
            );
            
            //OUTPUT
            sb.append((isCoplanar)? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
    
    private static Point3D getPoint(String str){
        String[] coords = str.split(" ");
        return new Point3D(
            Short.parseShort(coords[0]),
            Short.parseShort(coords[1]),
            Short.parseShort(coords[2])
        );
    }
    
    private static int dotProduct(Point3D v1, Point3D v2){
        return v1.x*v2.x + v1.y*v2.y + v1.z*v2.z;
    }
    
    private static Point3D normal(Point3D p1, Point3D p2, Point3D p3){
        final Point3D a = vector(p1, p2);
        final Point3D b = vector(p1, p3);
        return new Point3D(
            a.y*b.z - a.z*b.y,
            a.z*b.x - a.x*b.z,
            a.x*b.y - a.y*b.x
        );
    }
    
    private static Point3D vector(Point3D p1, Point3D p2){
        return new Point3D(
            p2.x - p1.x,
            p2.y - p1.y,
            p2.z - p1.z
        );
    }
    
    public static class Point3D{
        int x, y, z;
        public Point3D(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
