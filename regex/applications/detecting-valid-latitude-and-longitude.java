//https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude
import java.io.*;
import java.util.regex.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Matcher matcher = Pattern.compile(
            "^\\("
            //Latitude
            + "[-+]?(?:90(?:\\.0+)?|[1-8]?[0-9](?:\\.[0-9]+)?)"
            + ", "
            //Longitude
            + "[-+]?(?:180(?:\\.0+)?|(?:(?:[0-9]?[0-9]|1[0-7][0-9])(?:\\.[0-9]+)?))"
            + "\\)$"
        ).matcher("");
        for(byte N = Byte.parseByte(br.readLine()); N > 0; --N){
            matcher.reset(br.readLine());
            sb.append(matcher.matches() ? "Valid\n" : "Invalid\n");
        }
        System.out.print(sb);
    }
}