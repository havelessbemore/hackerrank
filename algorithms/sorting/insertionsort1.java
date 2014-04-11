//https://www.hackerrank.com/challenges/insertionsort1
import java.util.*;

public class Solution {
    static void insertionSort(int[] ar) {
        int i = ar.length-1;
        int V = ar[i];
        while (i > 0 && ar[i-1] > V) {
            ar[i] = ar[i-1];
            --i;
            printArray(ar);
        }
        ar[i] = V;
        printArray(ar);
    }
    static void printArray(int[] ar) {
    	StringBuffer sb = new StringBuffer();
        for(int n: ar){
            sb.append(n+" ");
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