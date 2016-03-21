//https://www.hackerrank.com/challenges/count-luck
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //For each test case...
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            
            //Get input
            String[] line = br.readLine().split(" ");
            final byte N = Byte.parseByte(line[0]);
            final byte M = Byte.parseByte(line[1]);
            final char[][] forest = new char[N][];
            for(byte i = 0; i < N; forest[i++] = br.readLine().toCharArray()){}
            final short K = Short.parseShort(br.readLine());
            
            //Find start point
            byte startY = 0;
            byte startX = 0;
            for(byte y = 0; y < N; ++y){
                for(byte x = 0; x < M; ++x){
                    if(forest[y][x] == 'M'){
                        startY = y;
                        startX = x;
                        y = N;
                        break;
                    }
                }
            }
            
            //Solve and print output
            sb.append(countWaves(forest, N, M, startY, startX) == K ? "Impressed\n" : "Oops!\n");
        }
        System.out.print(sb);
    }
    
    private static short countWaves(final char[][] forest, final byte Y, final byte X, final byte startY, final byte startX){
        
        //Initialize min waves
        final short[][] minWaves = new short[Y][X];
        for(short y = 0; y < Y; ++y){
            for(short x = 0; x < X; minWaves[y][x++] = -1){}
        }
        
        //Initialize stack
        Deque<Point> stack = new ArrayDeque<Point>();
        stack.push(new Point(startY, startX));
        minWaves[startY][startX] = 0;
        
        //DFS
        while(!stack.isEmpty()){
            Point p = stack.pop();
            short waves = minWaves[p.y][p.x];
            if(forest[p.y][p.x] == '*'){
                return waves;
            }
            ++waves;
            byte childCount = 0;
            if(p.y > 0 && forest[p.y-1][p.x] != 'X' && minWaves[p.y-1][p.x] < 0){
                ++childCount;
                minWaves[p.y-1][p.x] = waves;
                stack.push(new Point((byte)(p.y-1),p.x));
            }
            if(p.x > 0 && forest[p.y][p.x-1] != 'X' && minWaves[p.y][p.x-1] < 0){
                ++childCount;
                minWaves[p.y][p.x-1] = waves;
                stack.push(new Point(p.y,(byte)(p.x-1)));
            }
            if(p.y+1 < Y && forest[p.y+1][p.x] != 'X' && minWaves[p.y+1][p.x] < 0){
                ++childCount;
                minWaves[p.y+1][p.x] = waves;
                stack.push(new Point((byte)(p.y+1),p.x));
            }
            if(p.x+1 < X && forest[p.y][p.x+1] != 'X' && minWaves[p.y][p.x+1] < 0){
                ++childCount;
                minWaves[p.y][p.x+1] = waves;
                stack.push(new Point(p.y,(byte)(p.x+1)));
            }
            if(childCount == 1){
                p = stack.peek();
                --minWaves[p.y][p.x];
            }
        }
        
        //No path found (not possible given constraints)
        return (short) -1;
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
