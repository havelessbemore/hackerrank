//https://www.hackerrank.com/challenges/backreferences-to-failed-groups
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d{2}(-?)\\d{2}\\1\\d{2}\\1\\d{2}$");
  }
}
