//https://www.hackerrank.com/challenges/bday-gift
import java.io.*;
import java.text.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        long sum = 0;
        DecimalFormat df = new DecimalFormat("#.0");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(Byte N = Byte.parseByte(br.readLine()); N > 0; --N){
            sum += Integer.parseInt(br.readLine());
        }
        double expectedValue = sum/2.0;
        System.out.print(df.format(expectedValue));
    }
}
