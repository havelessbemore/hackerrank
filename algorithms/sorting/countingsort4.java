//https://www.hackerrank.com/challenges/countingsort4
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Initialize arrays
        int KEY_MAX = 100;
        int[] count = new int[KEY_MAX];
        //for(int i = 0; i < KEY_MAX; count[i++] = 0){}
        
        int N = Integer.parseInt(br.readLine());
        int[] keys = new int[N];
        String[] vals = new String[N];
        String[] out = new String[N];
        
        //Count the number of times a key occurs
        for(int i = 0; i < N; i++){
            String[] temp = br.readLine().split(" ");
            int key = Integer.parseInt(temp[0]);
            String val = temp[1];
            keys[i] = key;
            vals[i] = val;
            count[key] += 1;
        }
        
        //Combine each count with previous counts to get starting positions
        int total = 0;
        for(int i = 0; i < KEY_MAX; i++){
            int temp = count[i];
            count[i] = total;
            total += temp;
        }
        
        //Move vals to out array in stable order
        //Replace val with "-" if from first half of input
        int HALF = N/2;
        for(int i = 0; i < N; i++){
            int key = keys[i];
            String val = (i < HALF) ? "-" : vals[i];
            int j = count[key]++;
            out[j] = val;
        }
        
        //Print
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < N; str.append(out[i++] + " ")){}
        System.out.print(str);
    }
}