//https://www.hackerrank.com/challenges/quicksort1
import java.util.*;

public class Solution {
    static void partition(int[] ar) {
        int p = ar[0];
        List<Integer> below = new ArrayList<Integer>();
        List<Integer> above = new ArrayList<Integer>();
        for (int i = 1, N = ar.length; i < N; ++i) {
            int v = ar[i];
            if (v < p) {
                below.add(v);
            } else {
                above.add(v);
            }
        }
        int i = 0;
        for(Integer v : below){
            ar[i++] = v;
        }
        ar[i++] = p;
        for(Integer v : above){
            ar[i++] = v;
        }
        printArray(ar);
    }   
    static void printArray(int[] ar) {
    	StringBuffer sb = new StringBuffer();
        for(int n: ar){
            sb.append(n + " ");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;ar[i++]=in.nextInt()){}
        partition(ar);
    }    
}
