//https://www.hackerrank.com/contests/w3/challenges/sam-and-substrings
import java.io.*;

/*

Explanation by example: N = 123

1) Get all possible substrings

1 + 12 + 123
2 + 23
3

2) Seperate numbers into individual digits*place

1 + (10 + 2) + (100 + 20 + 3)
2 + (20 + 3)
3

3) Remove groups and seperate into digit*10^placePower

1*10^0 + 10*10^1 + 2*10^0 + 1*10^2 + 2*10^1 + 3*10^0
2*10^0 + 2*10^1 + 3*10^0
3*10^0

4) Bunch together similar digits and combine duplicates

1*1*10^0 + 1*1*10^1 + 1*1*10^2
2*2*10^0 + 2*2*10^1
3*3*10^0

5) Group by place

(1*1 + 2*2 + 3*3)*10^0 + (1*1 + 2*2)*10^1 + (1*1)*10^2

6) Reduce

(14)*10^0 + (5)*10^1 + (1)*10^2

7) Reduce

14 + 50 + 100

8) Answer

164

-----

In more general terms: 

If N is a number of length n in little endian,
the sum of all possible substrings is

(N[0](n) + N[1](n-1) + ... + N[n-1](1))*10^0
(N[1](n-1) + ... + N[n-1](1))*10^1
...
N[n-1](1)*10^(n-1)

=

RSum ( RSum ( N[j](n-j) , j from i to n - 1) * 10^i , i from 0 to n - 1)

*/

public class Solution {
    
    private final static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        
        //Get balls in reverse order
        int[] balls = strNumToArr((new BufferedReader(new InputStreamReader(System.in))).readLine());
        
        //Do inner RSum
        int n = balls.length;
        for(int i = n - 2; i >= 0; --i){
            balls[i] = (int)((balls[i+1] + (((long)balls[i])*(n - i))%MOD)%MOD);
        }
        
        //Do outer RSum
        int pow = 1;
        int total = 0;
        for(int i = 0; i < n; ++i){
            total = (int)((total + (((long)balls[i])*pow)%MOD)%MOD);
            pow = (int)((pow*10L)%MOD);
        }
        
        //Print
        System.out.print(total);
        
        
    }
    
    //Converts a number in string format
    //to an array of digits in little endian
    private static int[] strNumToArr(String str){
        int n = str.length();
        int[] ar = new int[n];
        for(char c : str.toCharArray()){
            ar[--n] = c - '0';
        }
        return ar;
    }    
}