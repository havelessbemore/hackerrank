//https://www.hackerrank.com/challenges/valid-pan-format
import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Matcher m = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$").matcher("");
        int N = Integer.parseInt(reader.readLine());
        while (N-- > 0) {
            String line = reader.readLine();
            String output = m.reset(line).matches() ? "YES\n" : "NO\n";
            sb.append(output);
        }
        System.out.print(sb);
    }
}