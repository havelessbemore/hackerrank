//https://www.hackerrank.com/challenges/random-number-generator
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(short n = Short.parseShort(br.readLine()); n > 0; --n){
            String[] input = br.readLine().split(" ");
            final short A = Short.parseShort(input[0]);
            final short B = Short.parseShort(input[1]);
            final short C = Short.parseShort(input[2]);
            sb.append(solve(A, B, C).reduce().toString() + "\n");
        }
        System.out.print(sb);
    }
    private static Fraction solve(int a, int b, int c){
        Fraction out = new Fraction();
        out.den = a * b;
        
        if (a + b <= c){
            out.num = out.den;
            return out;
        }
        
        int minX = 0;
        if (b < c){
            minX = c - b;
            out.num = b*minX;
        }
        
        int maxX = (a < c) ? a : c;
        
        out.num += c*(maxX - minX);
        int temp = maxX*maxX - minX*minX;
        if ((temp & 1) == 1){
            out.den <<= 1;
            out.num = (out.num << 1) - temp;
        } else {
            out.num -= temp >> 1;
        }
        
        return out;
    }
    public static class Fraction{
        public int num;
        public int den;
        public Fraction(){
            num = 0;
            den = 1;
        }
        public Fraction reduce(){
            int gcd = GCD(this.num, this.den);
            this.num /= gcd;
            this.den /= gcd;
            return this;
        }
        private static int GCD(int a, int b){
            while (b != 0){
                int c = b;
                b = a % b;
                a = c;
            }
            return a;
        }
        public String toString(){
            return num + "/" + den;
        }
    }
}
