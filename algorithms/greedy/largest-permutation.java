//https://www.hackerrank.com/challenges/largest-permutation
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Get input
    String[] line = br.readLine().split(" ");
    final int N = Integer.parseInt(line[0]);
    final int K = Integer.parseInt(line[1]);
    final int[] A = new int[N];
    line = br.readLine().split(" ");
    for(int i = 0; i < N; ++i){
      A[i] = Integer.parseInt(line[i]);
    }
    line = null;

    //Create an array to show where each number currently is
    final int[] pos = new int[N+1];
    for(int i = 0; i < N; ++i){
      pos[A[i]] = i;
    }
    
    //Make at most K swaps to sort list in reverse chronological order:
    //  For each natural number 'i' from N to 1...
    for(int i = N, swaps = K; i > 0; --i){
      
      //Get the current position
      final int actualPos = pos[i];
      
      //Get the expected position when sorted in reverse
      final int expectedPos = N - i;
      
      //If 'i' is not in the correct place...
      if(actualPos != expectedPos){
        
        //Swap whatever's in i's place with i
        pos[A[expectedPos]] = actualPos;
        A[actualPos] = A[expectedPos];
        A[expectedPos] = i;
        
        //Stop sorting if we're out of swaps
        if(--swaps < 1){
          break;
        }
      }
    }
    
    //Print output
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < N; sb.append(A[i++] + " ")){}
    System.out.print(sb);
  }
}
