//https://www.hackerrank.com/challenges/game-of-throne-ii
import java.io.*;
import java.util.*;

public class Solution {
    private final static int MOD = 1000000007;
    private final static byte ALPHABET_SIZE = 26;
    private final static byte ALPHABET_ASCII_OFFSET = 97;
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int N = str.length() >> 1;
        int[] charCounts = characterCount(str);
        for(int i = 0; i < ALPHABET_SIZE; charCounts[i++] >>= 1){}
        str = null;
        Arrays.sort(charCounts);
        int curFactorial = 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        for(byte i = 0; i < ALPHABET_SIZE; ++i){
            int factorial = charCounts[i];
            addFactors(curFactorial, factorial, map);
            curFactorial = factorial;
            addAToB(map, total);
        }
        addFactors(curFactorial, N, map);
        subAFromB(total, map);
        long answer = 1;
        for(int key : map.keySet()){
            int power = map.get(key);
            answer = (answer * pow(key, power)) % MOD;
        }
        System.out.print(answer);
    }
    private static int[] characterCount(String str){
        int[] ar = new int[ALPHABET_SIZE];
        for(char c : str.toCharArray()){
            ar[c - ALPHABET_ASCII_OFFSET]++;
        }
        return ar;
    }
    private static void addFactors(int minFactorial, int maxFactorial, Map<Integer, Integer> sum){
        while (minFactorial < maxFactorial){
            int factorial = ++minFactorial;
            for(int factor = 2; factorial > 1; ++factor){
                if (factorial%factor == 0){
                    int power = 0;
                    do {
                        ++power;
                        factorial /= factor;
                    } while (factorial%factor == 0);
                    Integer v = sum.get(factor);
                    sum.put(factor, v == null ? power : v + power);
                }
            }
        }
    }
    private static void addAToB(Map<Integer, Integer> a, Map<Integer, Integer> b){
        for(int key : a.keySet()){
            Integer v = b.get(key);
            b.put(key, v == null ? a.get(key) : a.get(key) + v);
        }
    }
    private static void subAFromB(Map<Integer, Integer> a, Map<Integer, Integer> b){
        for(int key : a.keySet()){
            Integer v = b.get(key);
            b.put(key, v == null ? -a.get(key) : v - a.get(key));
        }
    }
    private static int pow(int base, int power){
        if (power < 2){
            return power < 1 ? 1 : base % MOD;
        }
        long x = pow(base, power >> 1);
        x = (x * x) % MOD;
        return ((power & 1) == 0) ? (int)x : (int)((base * x) % MOD);
    }
}