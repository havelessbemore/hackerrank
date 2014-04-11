//https://www.hackerrank.com/challenges/uk-and-us-2
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher matcher = Pattern.compile(
            "[a-z]*our[a-z]*", 
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        
        //Maps UK spelling to count of all occurences
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(int N = Integer.parseInt(in.nextLine()); N > 0; N--) {
            //Change "or"s to "our"s
            String words = in.nextLine()
                            .toLowerCase()
                            .replaceAll(
                                "([a-zA-Z]+)or|or([a-zA-Z]+)",
                                "$1our$2"
                            );
            //Find and count occurences of words with "our"
            matcher.reset(words);
            while (matcher.find()) {
                String word = matcher.group();
                Integer count = map.get(word);
                map.put(word, count == null ? 1 : count + 1);
            }
        }
        
        //Print count of each word
        for(int T = Integer.parseInt(in.nextLine()); T > 0; T--) {
            String word = in.nextLine().toLowerCase();
            Integer count = map.get(word);
            System.out.println(count == null ? 0 : count);
        }
    }
}