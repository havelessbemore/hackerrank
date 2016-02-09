//https://www.hackerrank.com/challenges/the-time-in-words
import java.io.*;

public class Solution {
    final private static String[] WORDS = new String[]{
        "", "one", "two", "three", "four",
        "five", "six", "seven", "eight", "nine", 
        "ten", "eleven", "twelve", "thirteen", "fourteen", 
        "quarter", "sixteen", "seventeen", "eighteen", "nineteen", 
        "twenty"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Get input
        final byte hour = Byte.parseByte(br.readLine());
        byte minute = Byte.parseByte(br.readLine());
        
        //Output formatted input
        System.out.print(format(hour, minute));
    }
    
    private static String format(byte hour, byte minute){
        
        //Get hour
        String out = WORDS[hour];
        
        //If on the hour
        if(minute == 0){
            return out + " o' clock";
        }
        
        //Get if closer to next hour or current hour
        if(minute <= 30){
            out = "past " + out;
        } else {
            out = WORDS[hour + 1];
            minute = (byte)(60 - minute);
            out = "to " + out;
        }
        
        //Get minute
        if(minute == 1){
            return "one minute " + out;
        }
        if(minute % 15 == 0){
            return (minute == 15) ? "quarter " + out : "half " + out;
        }
        out = "minutes " + out;
        if(minute > 20){
            out = WORDS[minute % 20] + " " + out;
            minute = 20;
        }
        return WORDS[minute] + " " + out;
    }
}
