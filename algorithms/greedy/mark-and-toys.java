//https://www.hackerrank.com/challenges/mark-and-toys
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] ar = new int[N];
        for(int i = 0; i < N; ar[i++] = in.nextInt()){}
        mergeSort(ar);
        int i = 0;
        while (i < N && ar[i] <= K) {
            K -= ar[i++];
        }
        System.out.println(i);
    }
    /*
    private static void printArray(int[] ar){
    	StringBuffer sb = new StringBuffer();
        for(int i : ar){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }
    */
    private static void mergeSort(int[] ar){
        mergeSort(ar, 0, ar.length, new int[ar.length]);
    }
    private static void mergeSort(int[] ar, int min, int max, int[] temp){
        int length = max - min;
        if (length < 2){
            return;
        }
        int mid = min + length/2;
        mergeSort(ar, min, mid, temp);
        mergeSort(ar, mid, max, temp);
        
        int i = min;
        int k = min;
        int j = mid;
        while(i < mid & j < max){
            temp[k++] = (ar[i] > ar[j]) ? ar[j++] : ar[i++];
        }
        while(mid-- > i){
            ar[--j] = ar[mid];
        }
        while (k-- > min){
            ar[k] = temp[k];
        }
    }
}