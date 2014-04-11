//https://www.hackerrank.com/challenges/saying-hi
import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Matcher m = Pattern.compile("^hi\\s[^d]", Pattern.CASE_INSENSITIVE).matcher("");
        for(int N = Integer.parseInt(reader.readLine()); N > 0; --N) {
            String line = reader.readLine();
            if(m.reset(line).find()) {
                System.out.println(line);
            }
        }
    }
}