//https://www.hackerrank.com/challenges/simple-array-sum
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Skip first line
    br.readLine();
    
    //Sum input
    long sum = 0;
    for(String s : br.readLine().split(" ")){
      sum += Integer.parseInt(s);
    }
    
    //Print sum
    System.out.print(sum);
  }
}
