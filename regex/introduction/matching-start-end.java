//https://www.hackerrank.com/challenges/matching-start-end
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^\\d\\w\\w\\w\\w\\.$");
    
    //Works too but not the point of the challenge
    //tester.checker("^\\d\\w{4}\\.$");
  }
}
