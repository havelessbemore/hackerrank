//https://www.hackerrank.com/challenges/countingsort3
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Initialize array
        int SIZE = 100;
        int[] ar = new int[SIZE];
        for(int i = 0; i < SIZE; ar[i++] = 0){}
        //Count the number of times an index occurs
        for(int N = in.nextInt(); N > 0; --N){
            int i = in.nextInt();
            String text = in.nextLine();
            ar[i]++;
        }
        //Combine each count with the counts before it
        for(int i = 1; i < SIZE; ++i){
            ar[i] += ar[i-1];
        }
        //Print
        for(int i = 0; i < SIZE; System.out.print(ar[i++] + " ")){}
    }
}