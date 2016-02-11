//https://www.hackerrank.com/challenges/cipher
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Get input
    String[] line = br.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int K = Integer.parseInt(line[1]);
    char[] S = br.readLine().toCharArray();
    
    //Limit K
    if(K > N){
      K = N;
    }
    
    //Decode
    char[] C = new char[N];
    C[0] = S[0];
    for(int i = 1; i < K; ++i){
      C[i] = xor(S[i], S[i-1]);
    }
    for(int i = K; i < N; ++i){
      C[i] = xor(xor(S[i], S[i-1]), C[i-K]);
    }
    
    //Print output
    System.out.print(C);
  }
  
  private static char xor(final char a, final char b){
    return (a == b) ? '0' : '1';
  }
}
