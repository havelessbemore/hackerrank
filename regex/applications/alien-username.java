//https://www.hackerrank.com/challenges/alien-username
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Matcher m = Pattern.compile(
            
            //It has to begin with either an underscore ‘_’ or a dot ‘.’
            "^[_\\.]"
            
            //It has to be immediately followed by one or more digits numbered 0-9
            + "\\d+"
            
            //It can then have letters, either uppercase or lowercase, 0 or more in number
            + "[a-zA-Z]*"
            
            //It can then end with an optional ‘_’
            + "_?"
            
        ).matcher("");
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String line = reader.readLine();
            String output = (m.reset(line).matches()) ? "VALID" : "INVALID";
            System.out.println(output);
        }
    }
}