//https://www.hackerrank.com/challenges/is-fibo
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long prevFib, curFib;
        Set<Long> fibs = new TreeSet<Long>();
        fibs.add(prevFib = 0L);
        fibs.add(curFib = 1L);
        for(int T = Integer.parseInt(br.readLine()); T > 0; --T){
            long N = Long.parseLong(br.readLine());
            while (curFib < N){
                long temp = curFib;
                fibs.add(curFib += prevFib);
                prevFib = temp;
            }
            sb.append(fibs.contains(N) ? "IsFibo\n" : "IsNotFibo\n");
        }
        System.out.print(sb);
    }
}