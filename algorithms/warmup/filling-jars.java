//https://www.hackerrank.com/challenges/filling-jars
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        double avg = 0.0d;
        int N = Integer.parseInt(temp[0]);
        for(int M = Integer.parseInt(temp[1]); M > 0; --M){
            temp = br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]) - 1;
            int b = Integer.parseInt(temp[1]);
            int k = Integer.parseInt(temp[2]);
            avg += 1.0d*(b-a)*k/N;
        }
        System.out.print((long)avg);
    }
}