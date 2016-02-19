//https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("\\S\\S\\s\\S\\S\\s\\S\\S");
    
    //Works too but not the point of the challenge
    //tester.checker("(?:\\S{2}\\s){2}\\S{2}");
  }
}
