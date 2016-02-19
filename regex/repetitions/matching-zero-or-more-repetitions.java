//https://www.hackerrank.com/challenges/matching-zero-or-more-repetitions
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d{2,}[a-z]*[A-Z]*$");
  }
}
