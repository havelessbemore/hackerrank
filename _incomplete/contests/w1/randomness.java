//https://www.hackerrank.com/contests/w1/challenges/randomness
/*
0 = 0 - 0
1 = 1 - 1
2 = 1 - 3
3 = 1 - 6
4 = 1 - 10
5 = 1 - 15
...

a = 1: a

...

aa = 2: a, aa
ab = 3: a, b, ab
ba = 3: b, a, ba
bb = 2: b, bb

=

aa = 2: a, aa
bb = 2: b, bb

ab = 3: a, b, ab
ba = 3: b, a, ba

...

aaa = 3: a, aa, aaa
aab = 5: a, b, aa, ab, aab
aac = 5: a, c, aa, ac, aac
aba = 5: a, b, ab, ba, aba
abb = 5: a, b, ab, bb, abb
abc = 6: a, b, c, ab, bc, abc
aca = 5: a, c, ac, ca, aca
acb = 6: a, c, b, ac, cb, acb
baa = 5: b, a, ba, aa, baa
bab = 5: b, a, ba, ab, bab
bac = 6: b, a, c, ba, ac, bac
bba = 5: b, a, bb, ba, bba
bbb = 3: b, bb, bbb
bbc = 5: b, c, bb, bc, bbc
caa = 5: c, a, ca, aa, caa
cab = 6: c, a, b, ca, ab, cab
cba = 6: c, b, a, cb, ba, cba
cbb = 5: c, b, cb, bb, cbb
cbc = 5: c, b, cb, bc, cbc
cca = 5: c, a, cc, ca, cca
ccb = 5: c, b, cc, cb, ccb
ccc = 3: c, cc, ccc

=

aaa = 3: a, aa, aaa
bbb = 3: b, bb, bbb
ccc = 3: c, cc, ccc

aab = 5: a, b, aa, ab, aab
aac = 5: a, c, aa, ac, aac
aba = 5: a, b, ab, ba, aba
abb = 5: a, b, ab, bb, abb
aca = 5: a, c, ac, ca, aca
baa = 5: b, a, ba, aa, baa
bab = 5: b, a, ba, ab, bab
bba = 5: b, a, bb, ba, bba
bbc = 5: b, c, bb, bc, bbc
caa = 5: c, a, ca, aa, caa
cbb = 5: c, b, cb, bb, cbb
cbc = 5: c, b, cb, bc, cbc
cca = 5: c, a, cc, ca, cca
ccb = 5: c, b, cc, cb, ccb

abc = 6: a, b, c, ab, bc, abc
acb = 6: a, c, b, ac, cb, acb
bac = 6: b, a, c, ba, ac, bac
cab = 6: c, a, b, ca, ab, cab
cba = 6: c, b, a, cb, ba, cba

---

aaaa =  4: a, aa, aaa, aaaa
aaab =  7: a, b, aa, ab, aaa, aab, aaab
aabc =  9: a, b, c, aa, ab, bc, aab, abc, aabc
abcd = 10: a, b, c, d, ab, bc, cd, abc, bcd, abcd

---

aaaaa =   5: a, aa, aaa, aaaa, aaaaa
aaaab =   9: a, b, aa, ab, aaa, aab, aaaa, aaab, aaaab
aaabc =  12: a, b, c, aa, ab, bc, aaa, aab, abc, aaab, aabc, aaabc
aabcd =  14: a, b, c, d, aa, ab, bc, cd, aab, abc, bcd, aabc, abcd, aabcd
abcde =  : a, b, c, d, e, ab, bc, cd, de, abc, bcd, cde, abcd, bcde, abcde

---

F(Size of String, Number of Unique letters in string)

F(1, 1) = 1

F(2, 1) = 2
F(2, 2) = 3

F(3, 1) = 3
F(3, 2) = 5
F(3, 3) = 6

F(4, 1) = 4
F(4, 2) = 7
F(4, 3) = 9
F(4, 4) = 10

F(5, 1) = 5
F(5, 2) = 9
F(5, 3) = 12
F(5, 4) = 14
F(5, 5) = 15
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int Q = Integer.parseInt(temp[1]);
        char[] S = br.readLine().toCharArray();
        
        //Create an array to tell us how many unique substrings are possible
        //for a string of length N with X unique characters
        int[] numSubs = new int[N];
        numSubs[0] = N;
        for(int i = 1, j = N - i; i < N; ++i){
            numSubs[i] = numSubs[i-1] + j--;
        }
        
        //Shift every character in string down by 'a'
        //so we align it with arrays used from here on
        for(int i = 0; i < N; S[i++] -= 'a'){}
        
        //Create an array to hold the number of occurences for each character.
        //As stated in the problem, only lowercase latin letters (a - z).
        //Keep track of the number of unique characters in the string.
        //Initialize with initial string
        int numUniqChars = 0;
        int[] charCounts = new int[('z' - 'a') + 1];
        for(char c : S){
            if (charCounts[c]++ == 0){
                ++numUniqChars;
            }
        }
        
        print(numSubs);
        print(charCounts);
        
        //For each query
        while (Q-- > 0){
            temp = br.readLine().split(" ");
            int P = Integer.parseInt(temp[0]) - 1;
            char C = (char)(temp[1].charAt(0) - 'a');
            
            //Update the charCounts and uniqueChars
            if (charCounts[S[P]]-- == 1){
                --numUniqChars;
            }
            S[P] = C;
            if (charCounts[S[P]]++ == 0){
                ++numUniqChars;
            }
            
            //Output the number of substrings
            sb.append(numSubs[numUniqChars-1] + "\n");
        }
        
        System.out.print(sb);
    }
    private static void print(int[] ar){
        StringBuffer sb = new StringBuffer();
        for(int v : ar){
            sb.append(v + " ");
        }
        System.out.println(sb);
    }
}