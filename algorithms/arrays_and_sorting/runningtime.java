//https://www.hackerrank.com/challenges/runningtime
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for(int i = 0; i < N; ar[i++] = in.nextInt()){}
        int shifts = 0;
        for(int i = 1; i < N; ++i){
            int j = i;
            int val = ar[i];
            while (j > 0 && ar[j-1] > val){
                ar[j] = ar[j-1];
                --j;
                ++shifts;
            }
            ar[j] = val;
        }
        System.out.println(shifts);
    }
}