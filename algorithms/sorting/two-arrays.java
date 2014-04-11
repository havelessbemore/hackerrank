//https://www.hackerrank.com/challenges/two-arrays
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for(int T = in.nextInt(); T > 0; T--){
            int N = in.nextInt();
            int K = in.nextInt();
            List<Integer> A = new ArrayList<Integer>(N);
            List<Integer> B = new ArrayList<Integer>(N);
            for(int i = 0; i++ < N; A.add(in.nextInt())){}
            Collections.sort(A);
            for(int i = 0; i++ < N; B.add(in.nextInt())){}
            Collections.sort(B);
            int i = 0;
            for(int j = N; i < N && (A.get(i) + B.get(--j)) >= K; ++i){}
            System.out.println(i == N ? "YES" : "NO");
        }
    }
}