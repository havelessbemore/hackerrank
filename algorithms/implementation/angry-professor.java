//https://www.hackerrank.com/challenges/angry-professor
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //For each test
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      
      //Get # students (N) and minimum not-cancelled threshold (K)
      String[] line = br.readLine().split(" ");
      short K = Short.parseShort(line[1]);
      short N = (short)(Short.parseShort(line[0]) - K + 1);
      
      //Get arrival times
      line = br.readLine().split(" ");
      
      //Check if class is cancelled
      boolean isCancelled = true;
      for(short i = 0; i < N; ++i){
        
        //If student arrived on time or early
        if(Byte.parseByte(line[i]) < 1){
          ++N;
          
          //If enough students arrived to give class
          if(--K < 1){
            isCancelled = false;
            break;
          }
        }
      }
      
      //Print if class is cancelled
      System.out.println((isCancelled) ? "YES" : "NO");
    }
  }
}
