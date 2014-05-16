//https://www.hackerrank.com/challenges/password-cracker-fp
//See: https://www.hackerrank.com/contests/lambda-calculi-apr14/challenges/password-cracker-fp
import scala.util.matching._;

object Solution {

    def main(args: Array[String]) {
        for(t <- readByte() until 0 by -1){
            //Input
            val n: Byte = readByte();
            val pass: String = readLine();
            val attempt: String = readLine();
            //Probably not optimal but just create regex
            //and let it take care of the pattern matching,
            //works great for this problem's parameters
            val regex: Regex = pass.replaceAll(" ", "|").r;
            val out : String = regex.findAllIn(attempt).mkString("", " ", "");
            val spaces: Int = out.count(_ == ' ');
            if (attempt.length == (out.length - spaces)){
                println(out);
            } else {
                println("WRONG PASSWORD");
            }
        }
    }
}