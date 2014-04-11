//https://www.hackerrank.com/challenges/find-substring
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        //Save all lines
        List<String> lines = new ArrayList<String>();
        for (int N = Integer.parseInt(in.nextLine()); N > 0; N--) {
            String line = in.nextLine();
            lines.add(line);
        }
        
        //Count occurrences of substring
        for (int T = Integer.parseInt(in.nextLine()); T > 0; T--) {
            String subword = in.nextLine();
            Matcher matcher = Pattern.compile(
                "[a-z0-9_]+"+subword+"[a-z0-9_]+",
                Pattern.CASE_INSENSITIVE
            ).matcher("");
            int count = 0;
            for (String line : lines) {
                matcher.reset(line);
                while (matcher.find()){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}