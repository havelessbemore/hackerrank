//https://www.hackerrank.com/contests/101hack34/challenges/beautiful-pairs
import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    
    //Get input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final short N = Short.parseShort(br.readLine());
    final short[] A = toShortArray(br.readLine().split(" "), N);
    final short[] B = toShortArray(br.readLine().split(" "), N);
    br.close();
    br = null;
    
    //Count the occurrences of numbers in A
    Map<Short, Short> map = new HashMap<Short, Short>(N);
    for(short i = 0; i < N; ++i){
      Short v = map.get(A[i]);
      map.put(A[i], (short)(v == null ? 1 : v + 1));
    }
    
    //Match them up with themselves in B
    for(short i = 0; i < N; ++i){
      Short v = map.get(B[i]);
      
      //Ignore counting numbers unique to B
      if(v != null){
        map.put(B[i], (short)(v - 1));
      }
    }
    
    //Subtract the number of mismatches from the
    //maximum amount of disjoint beautiful pairs (N)
    short pairwiseDisjointBeautifulPairs = N;
    for(Short v : map.values()){
      
      //Ignore counting excess numbers in B
      if(v > 0){
        pairwiseDisjointBeautifulPairs -= v;
      }
    }
    
    //Make the obligatory change to B
    pairwiseDisjointBeautifulPairs += (pairwiseDisjointBeautifulPairs == N) ? -1 : 1;
    
    //Print output
    System.out.print(pairwiseDisjointBeautifulPairs);
  }
  
  private static short[] toShortArray(final String[] A, final int N){
    final short[] B = new short[N];
    for(int i = 0; i < N; ++i){
      B[i] = Short.parseShort(A[i]);
    }
    return B;
  }
}
