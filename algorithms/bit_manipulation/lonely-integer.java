//https://www.hackerrank.com/challenges/lonely-integer
import java.util.*;

public class Solution {
    private static int SIZE = 101;
    static int lonelyinteger(int[] a) {
        int N = a.length;
        int[] C = new int[SIZE];
        //for(int i = 0; i < SIZE; C[i++] = 0){}
        for (int i = 0; i < N; C[a[i++]]++){}
        for (int i = 0; i < SIZE; i++){
            if (C[i] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = lonelyinteger(_a);
        System.out.println(res);
    }
}

------------------------------------------------
    
Python-Solution:-
    
from collections import Counter
n=int(input())
l=list(map(int,input().split()))
d=Counter(l)
for i,j in d.items():
    if j==1:
        print(i)
        break
 -------------------------------------------------
