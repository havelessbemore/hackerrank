//https://www.hackerrank.com/challenges/a-very-big-sum
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Skip first line
    br.readLine();
    
    //Sum input
    long sum = 0;
    for(String s : br.readLine().split(" ")){
      sum += Long.parseLong(s);
    }
    
    //Print sum
    System.out.print(sum);
  }
}
