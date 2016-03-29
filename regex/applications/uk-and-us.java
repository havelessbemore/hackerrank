//https://www.hackerrank.com/challenges/uk-and-us
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher matcher = Pattern.compile(
            "\\b([a-z]+)[sz]e\\b", 
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        int N = Integer.parseInt(in.nextLine());
        while (N-- > 0) {
            String line = in.nextLine();
            matcher.reset(line);
            while (matcher.find()) {
                String word = matcher.group(1) + "ze";
                Integer count = map.get(word);
                map.put(word, count == null ? 1 : count + 1);
            }
        }
        
        int T = Integer.parseInt(in.nextLine());
        while (T-- > 0) {
            String word = in.nextLine();
            Integer count = map.get(word);
            System.out.println(count == null ? 0 : count);
        }
    }
}