//https://www.hackerrank.com/challenges/summing-the-n-series
import java.io.*;

public class Solution{
    
    private final static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            long N = Long.parseLong(br.readLine());
            N = N%MOD;
            int sN = (int)((N*N)%MOD);
            sb.append(sN + "\n");
        }
        System.out.print(sb);
    }
}
/*
T(n) = n^2 - (n-1)^2

Squares
-------
0: 0
1: 1
2: 4
3: 9
4: 16
5: 25
6: 36
7: 49
8: 64
9: 81
10: 100

Series sum up to n
------------------
1: T(1) = (1 - 0) = 1 = 1
2: T(2) + T(1) = (4 - 1) + (1 - 0) = 3 + 1 = 4
3: T(3) + T(2) + T(1) = (9 - 4) + (4 + 1) + (1 - 0) = 5 + 3 + 1 = 9
4: T(4) + T(3) + ... = (16 - 9) + (9 - 4) + ... = 7 + 5 + 3 + 1 = 16
...
n: T(n) + T(n-1) + ... T(1) = n^2
*/