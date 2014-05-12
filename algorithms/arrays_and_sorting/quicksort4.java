//https://www.hackerrank.com/challenges/quicksort4
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] ar = new int[N];
        for(int i = 0; i < N; ar[i++] = in.nextInt()){}
        int insertionShifts = insertionSort(copyArray(ar));
        int quickSortShifts = quickSort(ar);
        int result = insertionShifts - quickSortShifts;
        System.out.println(result);
    }
    private static void printArray(int[] ar, int min, int max){
        while (min < max){
            System.out.print(ar[min++] + " ");
        }
        System.out.println("");
    }
    private static int[] copyArray(int[] ar){
        int N = ar.length;
        int[] copy = new int[N];
        while (N-- > 0){
            copy[N] = ar[N];
        }
        return copy;
    }
    private static int insertionSort(int[] ar){
        int shifts = 0;
        int N = ar.length;
        for(int i = 1; i < N; i++){
            int j = i;
            int val = ar[i];
            while (j > 0 && ar[j-1] > val){
                ar[j] = ar[j-1];
                j--;
                shifts++;
            }
            ar[j] = val;
        }
        return shifts;
    }
    private static int quickSort(int[] ar){
        return quickSort(ar, 0, ar.length);
    }
    private static int quickSort(int[] ar, int min, int max){
        int length = max - min;
        if (length < 2){
            return 0;
        }
        int count = partition(ar, min, max);
        int mid = min + count - 1;
        count += quickSort(ar, min, mid);
        count += quickSort(ar, mid+1, max);
        return count;
    }
    private static int partition(int[] ar, int min, int max){
        //Choose last element as pivot
        int pivot = ar[--max];
        
        int storeMax = min;
        for(int i = min; i < max; i++){
            if (ar[i] < pivot){
                int temp = ar[i];
                ar[i] = ar[storeMax];
                ar[storeMax++] = temp;
            }
        }
        
        //Move pivot to correct spot
        ar[max] = ar[storeMax];
        ar[storeMax] = pivot;
        
        //Return number of shifts
        return storeMax + 1 - min;
    }
}