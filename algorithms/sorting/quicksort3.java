//https://www.hackerrank.com/challenges/quicksort3
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        
        //Get input
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final short N = Short.parseShort(br.readLine());
        final short[] A = toShortArray(br.readLine().split(" "));
        
        //Solve and print output
        quickSort(A, 0, N);
    }
    
    //Quicksort
    
    private static void quickSort(final short[] A, final int min, final int max){
        if(max - min > 1){
            final int mid = partition(A, min, max);
            printArray(A);
            quickSort(A, min, mid);
            quickSort(A, mid + 1, max);
        }
    }
    
    private static int partition(final short[] A, final int min, int max){
        int pivotI = min;
        final short pivotV = A[--max];
        for(int i = min; i < max; ++i){
            if(A[i] <= pivotV){
                final short t = A[i];
                A[i] = A[pivotI];
                A[pivotI++] = t;
            }
        }
        A[max] = A[pivotI];
        A[pivotI] = pivotV;
        return pivotI;
    }
    
    //HELPERS
    
    private static short[] toShortArray(final String[] A){
        final int N = A.length;
        final short[] B = new short[N];
        for(int i = 0; i < N; ++i){
            B[i] = Short.parseShort(A[i]);
        }
        return B;
    }
    
    private static void printArray(final short[] A){
        final StringBuffer sb = new StringBuffer();
        for(int i = 0, n = A.length; i < n; sb.append(A[i++] + " ")){}
        System.out.println(sb);
    }
}
