//https://www.hackerrank.com/challenges/maxsubarray
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    StringBuffer sb = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //For each test case
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      
      //Get input
      final int N = Integer.parseInt(br.readLine());
      final short A[] = toShortArray(br.readLine().split(" "), N);
      
      //Initialize output
      int maxSumCont = 0;
      int maxSumNonCont = 0;
      
      //Get maximum value
      final short maxVal = max(A, N);
      
      //If there are no positive values, use max value
      if(maxVal < 1){
        maxSumNonCont = maxSumCont = maxVal;
      
      //Get max sums
      } else {
        maxSumCont = getMaxContiguousSum(A, N);
        maxSumNonCont = getMaxNonContiguousSum(A, N);
      }
      
      //Print output
      sb.append(maxSumCont + " " + maxSumNonCont + "\n");
    }
    System.out.print(sb);
  }
  
  private static int getMaxContiguousSum(final short[] A, final int N){
    int cur = 0;
    int sum = 0;
    for(int i = 0; i < N; ++i){
      cur = Math.max(cur + A[i], 0);
      sum = Math.max(sum, cur);
    }
    return sum;
  }
  
  private static int getMaxNonContiguousSum(final short[] A, final int N){
    int sum = 0;
    for(int i = 0; i < N; sum += Math.max(A[i++], 0)){}
    return sum;
  }
  
  private static short max(final short[] A, final int N){
    short max = Short.MIN_VALUE;
    for(int i = 0; i < N; ++i){
      max = (max > A[i]) ? max : A[i];
    }
    return max;
  }
  
  private static short[] toShortArray(final String[] A, final int N){
    final short[] B = new short[N];
    for(int i = 0; i < N; ++i){
      B[i] = Short.parseShort(A[i]);
    }
    return B;
  }
}
