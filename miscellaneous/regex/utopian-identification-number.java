//https://www.hackerrank.com/challenges/utopian-identification-number
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher matcher = Pattern.compile(
            "[a-z]{0,3}[0-9]{2,8}[A-Z]{3,}"
        ).matcher("");
        for (int N = Integer.parseInt(in.nextLine()); N > 0; --N) {
            String id = in.nextLine();
            matcher.reset(id);
            System.out.println(matcher.matches() ? "VALID" : "INVALID");
        }
    }
}