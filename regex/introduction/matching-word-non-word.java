//https://www.hackerrank.com/challenges/matching-word-non-word
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("\\w\\w\\w\\W\\w\\w\\w\\w\\w\\w\\w\\w\\w\\w\\W\\w\\w\\w");
    
    //Works too but not the point of the challenge
    //tester.checker("\\w{3}\\W\\w{10}\\W\\w{3}");
  }
}
