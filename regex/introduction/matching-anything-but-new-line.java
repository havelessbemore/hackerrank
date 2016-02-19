//https://www.hackerrank.com/challenges/matching-anything-but-new-line
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("...\\....\\....\\....");
    
    //Also works but not the point of the challenge
    //tester.checker(".{3}(?:\\..{3}){3}");
  }
}
