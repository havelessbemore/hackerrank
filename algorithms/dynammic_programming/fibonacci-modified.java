//https://www.hackerrank.com/challenges/fibonacci-modified
import java.io.*;
import java.math.BigInteger;

public class Solution {
  public static void main(String[] args) throws IOException{
    
    //Get input
    String[] line = (new BufferedReader(new InputStreamReader(System.in))).readLine().split(" ");
    BigInteger A = BigInteger.valueOf(Byte.parseByte(line[0]));
    BigInteger B = BigInteger.valueOf(Byte.parseByte(line[1]));
    
    //Solve
    for(byte n = (byte)(Byte.parseByte(line[2]) - 2); n > 0; --n){
      BigInteger C = B.multiply(B).add(A);
      A = B;
      B = C;
    }
    
    //Print output
    System.out.print(B);
  }
}
