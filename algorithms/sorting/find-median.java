//https://www.hackerrank.com/challenges/find-median
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Create array
        int N = Integer.parseInt(br.readLine());
        int[] ar = new int[N];
        String[] temp = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            ar[i] = Integer.parseInt(temp[i]);
        }
        //Keep going until the median is found
        int min = 0;
        int max = N;
        int mid = N/2;
        while (max-min > 1){
            int index = partition(ar, min, max);
            if (index < mid){
                min = index+1;
            } else if (index > mid){
                max = index;
            } else {
                break;
            }
        }
        System.out.println(ar[mid]);
    }
    private static int partition(int[] ar, int min, int max){
        //Use the middle element as the pivot
        int length = max - min;
        int mid = min + length/2;
        int pivotValue = ar[mid];
        //Move the pivot to the right
        ar[mid] = ar[--max];
        ar[max] = pivotValue;
        //Order on the pivot
        int storeMax = min;
        for(int i = min; i < max; i++){
            if (ar[i] < pivotValue){
                int temp = ar[i];
                ar[i] = ar[storeMax];
                ar[storeMax++] = temp;
            }
        }
        //Put pivot back
        ar[max] = ar[storeMax];
        ar[storeMax] = pivotValue;
        //Return the index
        return storeMax;
    }
}