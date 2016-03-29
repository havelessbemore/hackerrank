//https://www.hackerrank.com/challenges/find-a-word
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Matcher m = Pattern.compile(
            "(?<![_0-9a-z])[_0-9a-z]+(?![_0-9a-z])", 
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        
        //Count every word in every line
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String line = reader.readLine();
            m.reset(line);
            while (m.find()) {
                String word = m.group();
                Integer count = map.get(word);
                map.put(word, (count == null) ? 1 : count+1);
            }
        }
        
        //Print out the count for every test word
        int T = Integer.parseInt(reader.readLine());
        while (T-- > 0) {
            String word = reader.readLine();
            Integer count = map.get(word);
            System.out.println((count == null) ? 0 : count);
        }
    }
}