//https://www.hackerrank.com/challenges/insertionsort2
import java.util.*;

public class Solution {
    public static void insertionSort(int[] ar){
        int N = ar.length;
        for (int i = 1; i < N; ++i) {
            int V = ar[i];
            int j = i;
            while (j > 0 && ar[j-1] > V) {
                ar[j] = ar[j-1];
                --j;
            }
            ar[j] = V;
            printArray(ar);
        }
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
        insertionSort(ar);
    }    
}