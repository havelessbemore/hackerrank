//https://www.hackerrank.com/challenges/caesar-cipher-1
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Get length of string
    final byte N = Byte.parseByte(br.readLine());
    
    //Get string
    char[] s = br.readLine().toCharArray();
    
    //Get encryption key
    final byte K = Byte.parseByte(br.readLine());
    
    //Iterate through string
    for(byte i = 0; i < N; ++i){
      char c = s[i];
      
      //Encrypt current char if it's a letter
      if(c >= 'a' && c <= 'z'){
        s[i] = (char)(((c - 'a' + K) % 26) + 'a');
      } else if(c >= 'A' && c <= 'Z'){
        s[i] = (char)(((c - 'A' + K) % 26) + 'A');
      }
    }
    
    //Print encrypted key
    System.out.print(s);
  }
}
