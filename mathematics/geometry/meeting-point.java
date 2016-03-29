//https://www.hackerrank.com/challenges/meeting-point
import java.io.*;
import java.math.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        
      	//INPUT
      	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      	int N = Integer.parseInt(br.readLine());
      	int[] X = new int[N];
      	int[] Y = new int[N];
      	for(int i = 0; i < N; ++i){
          	String[] temp = br.readLine().split(" ");
          	X[i] = Integer.parseInt(temp[0]);
          	Y[i] = Integer.parseInt(temp[1]);
        }
        
        //SOLVE
      	//Find center point
      	double cX = avg(X);
      	double cY = avg(Y);
      	
      	//Snap to nearest house (Euclidean distance)
      	int minI = -1;
      	double minD = Double.MAX_VALUE;
      	for(int i = 0; i < N; ++i){
          	double d = euclideanDistance(X[i], Y[i], cX, cY);
          	if (d < minD){
              	minD = d;
              	minI = i;
            }
        }
        
      	//Sum distances (Grid distances)
      	long sum = 0;
      	for(int i = 0; i < N; ++i){
          	sum += (long)gridDistance(X[i], Y[i], X[minI], Y[minI]);
        }
        
      	//OUTPUT
      	System.out.print(sum);
    }
    
  	private static double avg(int[] ar){
      	long A = 0;
      	for(int v : ar){
          	A += v;
        }
      	return ((double)A)/ar.length;
    }
    
  	private static double gridDistance(double x1, double y1, double x2, double y2){
      	return Math.max(Math.abs(x2-x1), Math.abs(y2-y1));
    }
    
  	private static double euclideanDistance(double x1, double y1, double x2, double y2){
      	return Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
    }
}
