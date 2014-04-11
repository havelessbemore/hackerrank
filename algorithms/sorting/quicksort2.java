//https://www.hackerrank.com/challenges/quicksort2
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short N = Short.parseShort(br.readLine());
        short[] ar = new short[N];
        String[] temp = br.readLine().split(" ");
        for(short i=0;i<N;++i){
          ar[i] = Short.parseShort(temp[i]); 
        }
        StringBuffer str = new StringBuffer();
        quickSort(ar, str);
        System.out.print(str);
    }
    public static void print(short[] ar, short min, short max, StringBuffer str){
        while (min < max){
            str.append(ar[min++] + " ");
        }
        str.append("\n");
    }
    public static void quickSort(short[] ar, StringBuffer str){
        quickSort(ar, (short)0, (short)ar.length, str);
    }
    public static void quickSort(short[] ar, short min, short max, StringBuffer str){
        if (max - min < 2){
            return;
        }
        short p = partition(ar, min, max);
        quickSort(ar, min, p, str);
        quickSort(ar, ++p, max, str);
        print(ar, min, max, str);
    }
    public static short partition(short[] ar, short min, short max){
        short length = (short)(max - min);
        short[] ltar = new short[length];
        short[] gtar = new short[length];
        short pivotValue = ar[min];
        //Partition
        short lti = 0;
        short gti = 0;
        for(short i = (short)(min + 1); i < max; ++i){
            if (ar[i] < pivotValue){
                ltar[lti++] = ar[i];
            } else {
                gtar[gti++] = ar[i];
            }
        }
        for(short i = 0; i < lti; ++i){
            ar[min + i] = ltar[i];
        }
        lti += min;
        ar[lti] = pivotValue;
        for(short i = 0; i < gti; ++i){
            ar[lti + i + 1] = gtar[i];
        }
        return lti;
    }
}