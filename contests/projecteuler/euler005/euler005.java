//https://www.hackerrank.com/contests/projecteuler/challenges/euler005
import java.io.*;

public class Solution{

	private final static byte N_MAX = 40;

	public static void main(String[] args) throws IOException {

		//Input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final byte T = Byte.parseByte(br.readLine());
		final byte[] Ns = new byte[T];
		for(byte t = 0; t < T; Ns[t++] = Byte.parseByte(br.readLine())){
		}
		br.close();

		//Initialize primes
		int[] primes = getPrimes(N_MAX);
		byte numPrimes = (byte)primes.length;
		double[] primeLogs = new double[numPrimes];
		for(byte p = 0; p < numPrimes; ++p){
			primeLogs[p] = Math.log(primes[p]);
		}

		//Solve
		long[] Vs = new long[T];

		//For each test case
		for(byte t = 0; t < T; ++t){
            
			//Multiply together the largest whole power of 
			//each prime: prime^power <= N and power >= 1
			long v = 1L;
			final byte N = Ns[t];
			final double logN = Math.log(N);
			for(byte p = 0; p < numPrimes && primes[p] <= N; ++p){
				v *= Math.pow(primes[p], (int)(logN/primeLogs[p]));
			}
			Vs[t] = v;
		}

		//Output
		StringBuilder sb = new StringBuilder();
		for(byte t = 0; t < T; sb.append(Vs[t++]).append("\n")){
		}
		System.out.print(sb);
	}
	
	private static int[] getPrimes(int n){
		final int halfLen = n >> 1;
		final int halfSqrtN = ((int)Math.sqrt(n)) >> 1;
		final boolean[] isComposite = new boolean[halfLen];

		//Sieve
		for(int i = 0; i < halfSqrtN; ++i){
			if (!isComposite[i]){
				int prime = (i << 1) + 3;
				for(int j = (i << 1) * (i + 3) + 3; j < halfLen; j += prime){
					isComposite[j] = true;
				}
			}
		}

		//Count primes
		int c = 1;
		for(int i = 0; i < halfLen; c += (isComposite[i++]) ? 0 : 1){
		}

		//Store primes
		int[] primes = new int[c];
		primes[c = 0] = 2;
		for(int i = 0; i < halfLen; ++i){
			if (!isComposite[i]){
				primes[++c] = (i << 1) + 3;
			}
		}

		return primes;
	}
}