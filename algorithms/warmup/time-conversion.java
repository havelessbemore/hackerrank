//https://www.hackerrank.com/challenges/time-conversion
import java.io.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Get time
    String time = br.readLine();
    
    //Get hour and adjust based on AM/PM
    byte hour = Byte.parseByte(time.substring(0, 2));
    
    //If noon or midnight
    if(hour == 12){
      hour = 0;
    }
    
    //Add 12 hours to afternoon
    if("P".equals(time.substring(8, 9))){
      hour += 12;
    }
    
    //Print time in military format
    System.out.print(String.format("%02d", hour) + time.substring(2, 8));
  }
}
