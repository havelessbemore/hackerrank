//https://www.hackerrank.com/contests/projecteuler/challenges/euler007
import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    public static class Primes{
        private int maxI;
        private int maxN;
        private List<Integer> primes;
        public Primes(){
            maxI = 1;
            maxN = 9;
            primes = new ArrayList<Integer>();
            primes.add(2);
            primes.add(3);
            primes.add(5);
            primes.add(7);
        }
        public int size(){
            return primes.size();
        }
        public int get(int n){
            while (primes.size() <= n){
                grow();
            }
            return primes.get(n);
        }
        public void grow(){
            int temp = maxN;
            maxN = (int)Math.pow(primes.get(++maxI), 2);
            for(int curN = temp + 2; curN < maxN; curN += 2){
                boolean isPrime = true;
                for(int i = 1; i < maxI && isPrime; ++i){
                    isPrime = (curN % primes.get(i)) != 0;
                }
                if (isPrime){
                    primes.add(curN);
                }  
            }
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Primes primes = new Primes();
        
        for(short T = Short.parseShort(br.readLine()); T > 0; --T){
            short N = Short.parseShort(br.readLine());
            sb.append(primes.get(N-1) + "\n");
        }
        
        System.out.print(sb);
    }
}
