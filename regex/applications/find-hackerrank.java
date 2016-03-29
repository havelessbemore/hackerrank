//https://www.hackerrank.com/challenges/find-hackerrank
import java.io.*;

public class Solution {

    private final static String KEY = "hackerrank";
    private final static int KEY_STARTS = 1;
    private final static int KEY_ENDS = 2;
    private final static int KEY_STARTS_ENDS = 0;
    private final static int KEY_DEFAULT = -1;

    public static void main(String[] args) throws IOException {
        int keyLength = KEY.length();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //For each test
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0){
           
            //Read the line
            String line = reader.readLine();
            int lineLength = line.length();
            
            //Find location of keyword
            int index = line.indexOf(KEY);
            
            //If starts with key
            if (index == 0) {
                
               //Check if ends with key
               System.out.println((lineLength == keyLength) ? KEY_STARTS_ENDS : KEY_STARTS);
            } else {
            
	            //Check if ends with key
	            System.out.println((index + keyLength == lineLength) ? KEY_ENDS : KEY_DEFAULT);
	        }
        }
    }
}