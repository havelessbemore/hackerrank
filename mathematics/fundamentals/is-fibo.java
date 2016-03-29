//https://www.hackerrank.com/challenges/is-fibo
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //I/O
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Initialize fibs, an ordered set
        //to hold all Fibonacci numbers,
        //with the first two numbers.
        long prevFib, curFib;
        Set<Long> fibs = new TreeSet<Long>();
        fibs.add(prevFib = 0L);
        fibs.add(curFib = 1L);

        //For every test
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){

            //Get N, the potential Fibonacci number
            long N = Long.parseLong(br.readLine());

            //Make sure we've gotten all
            //Fibonacci numbers up to N
            while (curFib < N){
                long temp = curFib;
                fibs.add(curFib += prevFib);
                prevFib = temp;
            }

            //Check if the Fibonacci number is in the set
            sb.append(fibs.contains(N) ? "IsFibo\n" : "IsNotFibo\n");
        }

        //Print
        System.out.print(sb);
    }
}