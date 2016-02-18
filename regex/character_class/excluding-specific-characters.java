//https://www.hackerrank.com/challenges/excluding-specific-characters
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^[^0-9][^aeiou][^bcDF][^\\s][^AEIOU][^.,]$");
  }
}
