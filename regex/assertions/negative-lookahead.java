//https://www.hackerrank.com/challenges/negative-lookahead
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("(.)(?!\\1)");
  }
}
