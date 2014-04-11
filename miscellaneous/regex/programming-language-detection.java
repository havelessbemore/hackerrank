//https://www.hackerrank.com/challenges/programming-language-detection
import java.io.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args) throws IOException{
    	//Get input
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(String str = br.readLine(); str != null; str = br.readLine()){
			str = str.trim();
			if (str.length() > 0){
				sb.append(str + "\n");
			}
		}
		String code = sb.toString();

    	//Check imports/includes
    	//While this is a poor language detector
    	//it happens to be enough for given input
		if (getMatcher("^import [a-z0-9_\\.\\*]+;", code).find()){
			exit("Java");
		}
		if (getMatcher("^#include\\s*(?:<.*?>|\".*?\")", code).find()){
			exit("C");
		}
		exit("Python");
	}
	private static Matcher getMatcher(String pattern, String input){
		return Pattern.compile(
			pattern, 
			Pattern.MULTILINE 
			| Pattern.CASE_INSENSITIVE
			).matcher(input);
	}
	private static void exit(String lang){
		System.out.print(lang);
		System.exit(0);
	}
}