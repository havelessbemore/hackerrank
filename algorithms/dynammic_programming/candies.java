//https://www.hackerrank.com/challenges/candies
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        for(int i = 0; i < N; ar[i++] = Integer.parseInt(br.readLine())){}
        br.close();
        
        int[] cc = new int[N];
        cc[0] = 1;
        for(int i = 1; i < N; i++){
            cc[i] = 1;
            if (ar[i] > ar[i-1]){
                cc[i] += cc[i-1];
            } else {
                for(int j = i; j > 0 && ar[j] < ar[j-1] && cc[j] == cc[j-1]; cc[--j] += 1){}
            }
        }
        
        long sum = 0;
        for(int i = 0; i < N; sum += cc[i++]){}
        System.out.print(sum);
    }
}