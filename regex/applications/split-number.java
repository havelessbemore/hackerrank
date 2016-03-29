//https://www.hackerrank.com/challenges/split-number
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher m = Pattern.compile(
            "(?<countryCode>\\d{1,3})"

			+ "([ -])"

			+ "(?<localAreaCode>\\d{1,3})"

            + "\\2"

            + "(?<number>\\d{4,10})"
        ).matcher("");
        
        int N = Integer.parseInt(in.nextLine());
        while (N-- > 0) {
            String line = in.nextLine();
            if (m.reset(line).matches()) {
                String countryCode = m.group("countryCode");
                String localAreaCode = m.group("localAreaCode");
                String number = m.group("number");
                String output = "CountryCode=" + countryCode 
                                + ",LocalAreaCode=" + localAreaCode 
                                + ",Number=" + number;
                System.out.println(output);
            }
        }
    }
}