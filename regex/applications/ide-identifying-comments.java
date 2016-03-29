//https://www.hackerrank.com/challenges/ide-identifying-comments
import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        //Get code
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(String line; (line = br.readLine()) != null; sb.append(line + "\n")){}
        String code = sb.toString();

        //Run the regex
        Matcher m = Pattern.compile(
            "\\/\\/.*?(?=\\n)|\\/\\*.*?\\*\\/", 
            Pattern.DOTALL | Pattern.MULTILINE
        ).matcher(code);

        //Print out matches
        sb = new StringBuffer();
        while (m.find()){
            sb.append(m.group() + "\n");
        }
        System.out.print(sb);
    }
}