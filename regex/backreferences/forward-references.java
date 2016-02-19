//https://www.hackerrank.com/challenges/forward-references
public class Solution {    
  public static void main(String[] args) {
    Regex_Test tester = new Regex_Test();
    tester.checker("^(\\2tic|(tac))+$");
    
    //Works too but doesn't experiment with forward references
    //tester.checker("^tac(?:tac(?:tic)?)+$");
  }
}
