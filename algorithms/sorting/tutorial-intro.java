//https://www.hackerrank.com/challenges/tutorial-intro
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String V = in.nextLine();
        int N = Integer.parseInt(in.nextLine());
        String[] ar = in.nextLine().split(" ");
        for (int i = 0; i < N; ++i) {
            if (ar[i].equals(V)) {
                System.out.println(i);
            }
        }
    }
}