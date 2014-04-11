//https://www.hackerrank.com/challenges/angry-children
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Get Input
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        for(int i = 0; i < N; ar[i++] = Integer.parseInt(br.readLine())){}
        //Sort
        Arrays.sort(ar);
        //Find Minimum Unfairness
        int min = ar[K-1] - ar[0];
        for(int i = K--; i < N; ++i){
            int cur = ar[i] - ar[i-K];
            min = cur < min ? cur : min;
        }
        System.out.print(min);
    }
}