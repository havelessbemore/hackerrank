//https://www.hackerrank.com/challenges/game-of-rotation
import java.io.*;

public class Solution{
    
    public static void main(String[] args) throws IOException{
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        N = 0;
        for(String s : br.readLine().split(" ")){
            A[N++] = Integer.parseInt(s);
        }
        
        //Find sum
        long sum = 0;
        for(int v : A){
            sum += v;
        }
        
        //Find cur pmean
        long curPmean = 0;
        for(int i = 0; i < N; ++i){
            curPmean += ((long)A[i])*(i+1);
        }
        
        //Cycle through
        //Keep track of max pmean
        long maxPmean = curPmean;
        for(int i = 1; i < N; ++i){
            curPmean = curPmean - sum + ((long)A[i-1])*N;
            if (curPmean > maxPmean){
                maxPmean = curPmean;
            }
        }
        
        //Output
        System.out.print(maxPmean);
    }
}