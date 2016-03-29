//https://www.hackerrank.com/challenges/detect-html-links
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher matcher = Pattern.compile(
            "<\\s*a\\s+href\\s*=\\s*\\\""
            + "(?<link>[^\\\\\"]*)"
            + "\\\"[^>]*>(?:<[^>]*>)*"
            + "(?<name>.*?)"
            + "(?:<\\s*/[^>]*>)*<\\s*/\\s*a\\s*>",
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        
        for (int N = Integer.parseInt(in.nextLine()); N > 0; N--) {
            String html = in.nextLine();
            matcher.reset(html);
            while (matcher.find()) {
                String link = matcher.group("link").trim();
                String name = matcher.group("name").trim();
                System.out.println(link+","+name);
            }
        }
    }
}