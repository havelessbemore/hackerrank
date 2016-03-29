//https://www.hackerrank.com/challenges/median
import java.io.*;
import java.util.*;
import java.text.*;

class Solution{
    private static final String ADD = "a";
    private static final String REMOVE = "r";
    private static final DecimalFormat format = new DecimalFormat("###########.#");
    public static void main(String args[]) throws IOException {
        StringBuffer str = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = 0;
        int[] ar = new int[N];
        while(N-- > 0){
            String[] temp = br.readLine().split(" ");
            int X = Integer.parseInt(temp[1]);
            if (temp[0].equals(ADD)){
                add(ar, size++, X);
                printMedian(ar, size, str);
            } else if (remove(ar, size, X) && --size > 0){
                printMedian(ar, size, str);
            } else {
                str.append("Wrong!\n");
            }
        }
        System.out.print(str);
    }
    private static void printMedian(int[] ar, int size, StringBuffer str){
        int a = size>>1;
        int b = (size-1)>>1;
        double diff = (double)(ar[a]) - (double)(ar[b]);
        double median = (double)(ar[b]) + diff/2;
        str.append(format.format(median)+"\n");
    }
    private static void add(int[] ar, int size, int value){
        if (size < 1){
            ar[0] = value;
            return;
        }
        int index = binarySearch(ar, size, value);
        shiftRight(ar, index, size);
        ar[index] = value;
    }
    private static void shiftRight(int[] ar, int min, int max){
        for(int i = max; i > min; i--){
            ar[i] = ar[i - 1];
        }
    }
    private static void shiftLeft(int[] ar, int min, int max){
        for (int i = min + 1; i < max; i++){
            ar[i-1] = ar[i];
        }
    }
    private static int binarySearch(int[] ar, int size, int value){
        int min = 0;
        int max = size;
        for (int length = max - min; length > 1; length = max - min){
            int i = min + length/2;
            if (ar[i] == value){
                return i;
            } else if (ar[i] < value){
                min = i;
            } else {
                max = i;
            }
        }
        return ar[min] < value ? min + 1 : min;
    }
    private static boolean remove(int[] ar, int size, int value){
        if (size < 1){
            return false;
        }
        int index = binarySearch(ar, size, value);
        if (index >= size || ar[index] != value){
            return false;
        }
        shiftLeft(ar, index, size);
        return true;
    }
}