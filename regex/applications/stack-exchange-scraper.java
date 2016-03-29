//https://www.hackerrank.com/challenges/stack-exchange-scraper
import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
    	//Get input html
    	StringBuffer sb = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (String str = in.readLine(); str != null; str = in.readLine()) {
            sb.append("\n" + str);
        }
        String html = sb.toString();

        //Match all the questions
        Matcher matcher = Pattern.compile(
            "<\\s*div\\s+class\\s*=\\s*\"question-summary\"\\s*id\\s*=\\s*\"question-summary-(?<id>\\d+)\"\\s*>"
            + ".*?<\\s*div\\s+class\\s*=\\s*\"summary\"\\s*>"
            + ".*?<\\s*a\\s+.*?class\\s*=\\s*\"question-hyperlink\"\\s*>"
            + "(?<title>.*?)"
            + "</\\s*a\\s*>.*?<\\s*div\\s+class\\s*=\\s*\"user-action-time\"\\s*>"
            + ".*?<\\s*span\\s+.*?>(?<time>.*?)</\\s*span\\s*>",
            Pattern.CASE_INSENSITIVE | Pattern.DOTALL
        ).matcher(html);
        
        //Output the information
        while (matcher.find()) {
            String id = matcher.group("id");
            String title = matcher.group("title");
            String time = matcher.group("time");
            System.out.println(id+";"+title+";"+time);
        }
    }
}