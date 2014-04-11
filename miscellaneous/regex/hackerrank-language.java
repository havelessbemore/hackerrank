//https://www.hackerrank.com/challenges/hackerrank-language
import java.util.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Matcher matcher = Pattern.compile(
            "^[1-9][0-9]{4}"
            +"\\s"
            +"(?:"
            +"C|CPP|JAVA|PYTHON|"
            +"PERL|PHP|RUBY|CSHARP|"
            +"HASKELL|CLOJURE|BASH|SCALA|"
            +"ERLANG|CLISP|LUA|BRAINFUCK|"
            +"JAVASCRIPT|GO|D|OCAML|"
            +"R|PASCAL|SBCL|DART|"
            +"GROOVY|OBJECTIVEC"
            +")$"
        ).matcher("");
        for(int N = Integer.parseInt(in.nextLine()); N > 0; N--) {
            String request = in.nextLine();
            matcher.reset(request);
            System.out.println(matcher.find() ? "VALID" : "INVALID");
        }
    }
}