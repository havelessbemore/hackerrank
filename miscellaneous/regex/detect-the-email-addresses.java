//https://www.hackerrank.com/challenges/detect-the-email-addresses
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher matcher = Pattern.compile(
            "(?<local>"
            
                + "[-a-zA-Z0-9!#$%&'*+/=?^_`{|}~.]+(?:\\.\\\"(?:[- a-zA-Z0-9!#$%&'*+/=?^_`{|}~.(),:;<>@\\[\\]]|\\\\\"|\\\\)+\\\"\\.[- a-zA-Z0-9!#$%&'*+/=?^_`{|}~.]+)?"
                
                + "|"
                
                + "\\\"(?:[- a-zA-Z0-9!#$%&'*+/=?^_`{|}~.(),:;<>@\\[\\]]|\\\\\"|\\\\)+\\\""
            
            + ")@(?<domain>"
            
                //Hostname
                + "[a-zA-Z0-9](?:[-a-zA-Z0-9]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[-a-zA-Z0-9]{0,61}[a-zA-Z0-9])?)*"
                
                + "|"
                
                //IPv4
                + "\\[(?:2(?:5[0-5]?|[0-4][0-9]?)?|[0-1][0-9]{0,2})(?:\\.(?:2(?:5[0-5]?|[0-4][0-9]?)?|[0-1][0-9]{0,2})){3}\\]"
                
                + "|"
                
                //IPv6
                + "\\[IPv6(?::[0-9a-f]{1,4}){0,8}(?::(?::[0-9a-f]{1,4}){0,8})?\\]"
            
            + ")"
            ,Pattern.CASE_INSENSITIVE
        ).matcher("");

        Set<String> emails = new TreeSet<String>();

        //For each line in the input
        for (int N = Integer.parseInt(in.nextLine()); N > 0; --N) {
            String line = in.nextLine();
            //Run through the regex
            matcher.reset(line);
            //And for each email address matched
            while (matcher.find()) {
                String domain = matcher.group("domain");
                if (domain.length() < 256) {
                    //Store in the emails list
                    emails.add(matcher.group());
                }
            }
        }
        
        //Print emails
        int i = emails.size();
        for (String email : emails) {
            System.out.print(email + (--i > 0 ? ";" : ""));
        }
    }
}