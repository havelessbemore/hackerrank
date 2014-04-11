//https://www.hackerrank.com/challenges/pairs
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        //Get and parse the first line
        String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]), K = Integer.parseInt(line[1]);
        
        //Get and parse the set of numbers
        line = reader.readLine().split(" ");
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        line = null;
        
        //Find the amount of valid pairs
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
        	count += Arrays.binarySearch(nums, i+1, nums.length, nums[i] + K) < 0 ? 0 : 1;
        }

        //Print answer
        System.out.print(count);
    }
}