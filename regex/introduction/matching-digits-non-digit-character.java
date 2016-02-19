//https://www.hackerrank.com/challenges/matching-digits-non-digit-character
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("\\d\\d\\D\\d\\d\\D\\d\\d\\d\\d");
    
    //Also works but not the point of the challenge
    tester.checker("(?:\\d{2}\\D){2}\\d{4}");
  }
}
