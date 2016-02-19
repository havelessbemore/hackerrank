//https://www.hackerrank.com/challenges/matching-word-boundaries
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("(\\b[aeiouAEIOU][a-zA-Z]*\\b)");
  }
}
