//https://www.hackerrank.com/challenges/countingsort2
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int SIZE = 100;
        int[] ar = new int[SIZE];
        for(int i = 0; i < SIZE; ar[i++] = 0){}
        for(int N = in.nextInt(); N-- > 0; ar[in.nextInt()]++){}
        for(int i = 0; i < SIZE; ++i){
            int count = ar[i];
            for(int j = 0; j < count; ++j) {
                System.out.print(i + " ");
            }
        }
    }
}