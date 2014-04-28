//https://www.hackerrank.com/contests/lambda-calculi-apr14/challenges/password-cracker-fp
import java.io._;
import scala.util.matching._;

object Solution {

    def main(args: Array[String]) {
        val sb : StringBuilder = new StringBuilder();
        for(T <- readLine().toByte until 0 by -1){
            //Input
            val N : Byte = readLine().toByte;
            val Passes : String = readLine();
            val LoginAttempt : String = readLine();
            //Probably not optimal but just create regex
            //and let it take care of the pattern matching,
            //works great for this problem's parameters
            val regex : Regex = Passes.replaceAll(" ", "|").r;
            var out : String = regex.findAllIn(LoginAttempt).mkString("", " ", "\n");
            var spaces = out.count(_ == ' ');
            if (LoginAttempt.length - (out.length - spaces - 1) == 0){
                sb.append(out);
            } else {
                sb.append("WRONG PASSWORD\n");
            }
        }
        print(sb);
    }
}