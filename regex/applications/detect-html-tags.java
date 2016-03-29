//https://www.hackerrank.com/challenges/detect-html-tags
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Matcher m = Pattern.compile(
            
            //Opening bracket and optional spaces
            "<\\s*"
            //Tag name
            + "([a-z0-9]+)"
            
            //Optional 1+ spaces and tag attributes
            +"(?:\\s(?:\\s*[a-z]+\\s*=\\s*\\\"[^\\\\\"]*\\\")*)?"
            
            //Self-close tag or normal tag
            +"\\s*(?:\\/>|>)",
            
            //Input is valid html so assume 
            //existence closing tags and correct nesting
            
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        
        //Find all the tags in input
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String line = reader.readLine();
            m.reset(line);
            while (m.find()) {
                set.add(m.group(1));
            }
        }

        //Print out tags
        int count = 0;
        int size = set.size();
        for (String word : set) {
            System.out.print((++count < size) ? word + ";" : word);
        }
    }
}