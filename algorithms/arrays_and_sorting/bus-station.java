//https://www.hackerrank.com/challenges/bus-station
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //Input
        int N = Integer.parseInt(br.readLine());
        short[] groups = new short[N];
        N = 0;
        for(String str : br.readLine().split(" ")){
            groups[N++] = Short.parseShort(str);
        }
        
        
        //Solve
        
        //Sum
        int[] sums = new int[N];
        sums[0] = groups[0];
        for(int i = 1; i < N; ++i){
            sums[i] = groups[i] + sums[i-1];
        }
        
        //Find
        List<Integer> sizes = new ArrayList<Integer>();
        for(int i = 0; i < N; ++i){
            if (sums[N-1] % sums[i] == 0){
                int j = i;
                for(int x = sums[i]; j >= 0; j = Arrays.binarySearch(sums, j, N, x += sums[i])){}
                if (~j == N){
                    sizes.add(sums[i]);
                }
            }
        }
        
        //Output
        StringBuffer sb = new StringBuffer();
        for(int size : sizes){
            sb.append(size + " ");
        }
        System.out.print(sb);
    }
}
