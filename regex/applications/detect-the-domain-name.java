//https://www.hackerrank.com/challenges/detect-the-domain-name
import java.util.*;
import java.util.regex.*;

public class Solution {
    private final static Matcher matcher = Pattern.compile(
        //Http
        "(?:https?://)"
        
        //Domain
        +"(?<domain>[-a-z0-9_~]{1,63}(?:\\.[-a-z0-9_~]{1,63}){1,126})"
        
        //Port
        +"(?::[0-9]{1,5})?"
        
        //Path
        +"(?:/[^\\s?]*)?"
        
        //Parameters
        +"(?:\\?[-a-z0-9_~]+=[-a-z0-9_~]*(?:&[-a-z0-9_~]+=[-a-z0-9_~]*)*)?",
        
        Pattern.CASE_INSENSITIVE
    ).matcher("");
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> domains = new TreeSet<String>();
        
        //Find domains
        int N = Integer.parseInt(in.nextLine());
        while (N-- > 0) {
            String htmlFrag = in.nextLine();
            matcher.reset(htmlFrag);
            while (matcher.find()) {
                String domain = matcher.group("domain").toLowerCase();
                if (domain.length() < 254) {
                    if (domain.startsWith("www.") || domain.startsWith("ww2.")) {
                        domain = domain.substring(4);
                    }
                    domains.add(domain);
                }
            }
        }
        
        //Print domains
        N = domains.size();
        for (String domain : domains) {
            System.out.print(domain + (--N > 0 ? ";" : ""));
        }
    }
}