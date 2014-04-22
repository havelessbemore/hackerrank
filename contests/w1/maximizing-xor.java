//https://www.hackerrank.com/contests/w1/challenges/maximizing-xor
/*
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short L = Short.parseShort(br.readLine());
        short R = Short.parseShort(br.readLine());
        short out = maxXor(L, R);
        System.out.print(out);
    }

    private static short maxXor(short L, short R) {
        //Probably not the best way, will optimize later
        short max = 0;
        for(short a = L; a <= R; ++a){
            for(short b = a+1; b <= R; ++b){
                short xor = (short)(a ^ b);
                max = xor > max ? xor : max;
            }
        }
        return max;
    }
}

1  | 0001
2  | 0010
3  | 0011
4  | 0100
5  | 0101
6  | 0110
7  | 0111
8  | 1000
9  | 1001
10 | 1010

----------

5  | 101
6  | 110
7  | 111

Upper bound will have highest bit place set, find what bit that is.
In this case it's 3rd bit, or 4x bit. 
See what x our max is in: x1 = 7/4 = 1
See what x our lower bound is in: x2 = 5/6 = 1
If they are equal, try again with 2nd bit:
    x1 = 7/2 = 3
    x2 = 5/2 = 2
They are not equal, so we know it's possible to have a xored number with this bit set.
Restated, we know our answer is at least 2.
Let's go on to the next bit:
    x1 = 7/1 = 7
    x2 = 5/1 = 5
They are not equal, so we know it's possible to have a xored number with this bit set.
Add 1 to our current answer for a total of 3.


10/8 = 1, 1/8 = 0, not equal, current answer : 8
10/4 = 2, 1/4 = 0, not equal, current answer : 12
10/2 = 5, 1/2 = 0, not equal, current answer : 14
10/1 = 10, 1/1 = 0, not equal, current answer : 15

Seeing as how we go through every bit to the largest one, instead
of finding the largest first, just go from smallest to largest until
our bit's decimal equivalent is larger than our upper bound.
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short L = Short.parseShort(br.readLine());
        short R = Short.parseShort(br.readLine());
        short out = maxXor(L, R);
        System.out.print(out);
    }
    private static short maxXor(short L, short R) {
        short max = 0;
        for(int pow = 1; pow <= R; pow <<= 1){
            max += (L/pow == R/pow) ? 0 : pow;
        }
        return max;
    }
}
/*
Now the only small issue is the need for a larger type for pow to avoid overflow possibility.
There are other ways, like http://graphics.stanford.edu/~seander/bithacks.html#IntegerLog
but they use lookup tables and I'd rather not for this problem. You could use Math library
and take the log base 2 of R, then double pow that many times, but according to other people
this method is neither fast nor precise (http://stackoverflow.com/questions/3305059/how-do-you-calculate-log-base-2-in-java-for-integers)
*/