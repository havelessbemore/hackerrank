//https://www.hackerrank.com/contests/projecteuler/challenges/euler002
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Data[] data = new Data[T];
        for(int t = 0; t < T; ++t){
            long n = Long.parseLong(br.readLine());
            data[t] = new Data(t, n);
        }
        br.close();
        br = null;
        
        //Solve
        
        //Order by N
        Arrays.sort(data, new Comparator<Data>(){
            public int compare(Data a, Data b){
                return (a.N < b.N) ? -1 : (a.N == b.N) ? 0 : 1;
            }
        });
        
        //Get sum of even fibonacci numbers up to N.
        long prevFib = 1;
        long curFib = 2;
        long curFibSum = 0;
        for(int t = 0; t < T; ++t){
            long n = data[t].N;
            while (curFib <= n){
                curFibSum += curFib;
                long temp = prevFib + curFib;
                prevFib = temp + curFib;
                curFib = prevFib + temp;
            }
            data[t].V = curFibSum;
        }
        
        //Order by T
        Arrays.sort(data, new Comparator<Data>(){
            public int compare(Data a, Data b){
                return (a.T < b.T) ? -1 : 1;
            }
        });
        
        //Print
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; ++t){
            sb.append(data[t].V).append("\n");
        }
        System.out.print(sb);
    }
    
    private static class Data{
        public long V;
        public final int T;
        public final long N;
        public Data(final int T, final long N){
            this.T = T;
            this.N = N;
            this.V = 0;
        }
    }
}