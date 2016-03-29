//https://www.hackerrank.com/challenges/html-attributes
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher tagMatcher = Pattern.compile(
            //Start tag
            "<\\s*"
            
            //Tag name
            + "(?<tag>[a-z0-9]+)"
            
            //Attributes
            + "(?<attrs>(?:\\s[^>]*)?)"
            
            //End tag
            + "\\s*>",
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        Matcher attrMatcher = Pattern.compile(
            //Attribute name
            "(?<attr>[a-z0-9_]+)"
            
            //Possible value
            + "(?:\\s*=\\s*(?:"
            + "\\\"(?:\\\\\"|.)*?\\\""
            + "|"
            + "'(?:\\\\'|.)*?'"
            + "))?",
            Pattern.CASE_INSENSITIVE
        ).matcher("");
        
        //Get tags and attributes
        Map<String, Set<String>> tags = new TreeMap<String, Set<String>>();
        for (int N = Integer.parseInt(in.nextLine()); N > 0; N--) {
            String html = in.nextLine();
            tagMatcher.reset(html);
            while (tagMatcher.find()) {
                String tag = tagMatcher.group("tag").toLowerCase();
                String attrs = tagMatcher.group("attrs");
                Set<String> attributes = tags.get(tag);
                if (attributes == null) {
                    attributes = new TreeSet<String>();
                    tags.put(tag, attributes);
                }
                attrMatcher.reset(attrs);
                while (attrMatcher.find()) {
                    String attr = attrMatcher.group("attr");
                    attributes.add(attr);
                }
            }
        }
        
        //Print out attributes
        for (String tag : tags.keySet()) {
            System.out.print(tag + ":");
            Set<String> attributes = tags.get(tag);
            int count = attributes.size();
            for (String attribute : attributes) {
                System.out.print(attribute+(--count > 0 ? "," : ""));
            }
            System.out.println("");
        }
    }
}