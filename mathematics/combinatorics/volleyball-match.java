//https://www.hackerrank.com/challenges/volleyball-match
//See: https://www.hackerrank.com/contests/w1/challenges/volleyball-match
import java.io.*;

public class Solution{

    private final static int MOD = 1000000007;
    private final static int WIN_SCORE_GAP = 2;
    private final static int MIN_WIN_SCORE = 25;
    private final static int MANDATORY_TIE = 24;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        System.out.print(getNumPossibleGames(A, B));
    }

    private static int getNumPossibleGames(int A, int B){
        if (A < B){
            int temp = A;
            A = B;
            B = temp;
        }

        if (A < MIN_WIN_SCORE){
            return 0;
        }

        if (A == MIN_WIN_SCORE){
            return (A - B < WIN_SCORE_GAP) ? 0 : nCr(A-1, B, MOD);
        }

        if(A - B != WIN_SCORE_GAP){
            return 0;
        }

        int numGames = nCr(MANDATORY_TIE, MANDATORY_TIE, MOD);

        numGames = (int)((((long)numGames) * pow(2, B - 24, MOD))%MOD);
        return numGames;
    }

    private static int nCr(int n, int r, int mod){
        if (n < r){
            int temp = n;
            n = r;
            r = temp;
        }

        if (n < 1 || r < 1){
            return 1;
        }

        int[] row = new int[r];
        for(int i = 0; i < r; row[i++] = 1){}

        for(int i = 2; i < r; ++i){
            for(int j = i-1; j > 0; --j){
                row[j] = (row[j] + row[j-1])%mod;
            }
        }

        --r;
        int sum = row[r];
        for(int i = 0; i < n; ++i){
            for(int j = r; j > 0; --j){
                row[j] = (row[j] + row[j-1])%mod;
            }
            sum = (sum + row[r])%mod;
        }

        return sum;
    }

    private static int pow(int base, int exponent, int mod){
        if (exponent < 2){
            return (exponent < 1) ? 1 : base;
        }
        long product = pow(base, exponent>>1, mod);
        product = (product*product)%mod;
        return ((exponent & 1) == 1) ? (int)((product*base)%mod) : (int)(product);
    }
}