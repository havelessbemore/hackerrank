//https://www.hackerrank.com/contests/w3/challenges/the-love-letter-mystery
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        //Initialize IO
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //For every test
        for(byte t = Byte.parseByte(br.readLine()); t > 0; --t){

            //Get the string and initialize number of operations to 0
            int numOps = 0;
            char[] str = br.readLine().toCharArray();

            //A palindrome is symmetrical along it's center, so:
            //Working from both ends inward, add the differences 
            //in letters from index in first half of string and 
            //its counterindex in the second half of the string
            for(short i = 0, j = (short)(str.length-1); i < j; ++i, --j){
                numOps += str[i] < str[j] ? str[j] - str[i] : str[i] - str[j];
            }

            //Add result to output
            sb.append(numOps + "\n");
        }

        //Print output
        System.out.print(sb);
    }
}