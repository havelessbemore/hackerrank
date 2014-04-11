//https://www.hackerrank.com/challenges/prng-sequence-guessing
import java.io.*;
import java.util.*;

public class Solution {
    private final static short RANDOMS_MAX = 1000;
    private final static byte RANDOMS_LENGTH = 10;
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte N = Byte.parseByte(br.readLine()); N > 0; --N){
            String[] temp = br.readLine().split(" ");
            long minSeed = Long.parseLong(temp[0]);
            long maxSeed = Long.parseLong(temp[1]);
            short[] nextInts = new short[RANDOMS_LENGTH];
            for(int i = 0; i < RANDOMS_LENGTH; nextInts[i++] = Short.parseShort(br.readLine())){}
            Random r = new Random();
            long seed = guessSeed(r, minSeed, maxSeed, nextInts);
            sb.append(seed + " ");
            for(int i = 0; i < RANDOMS_LENGTH; ++i){
                sb.append(r.nextInt(RANDOMS_MAX) + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    private static long guessSeed(Random r, long min, long max, short[] ar){
        for(long seed = min; seed <= max; ++seed){
            r.setSeed(seed);
            int i = 0;
            while (i < RANDOMS_LENGTH && r.nextInt(RANDOMS_MAX) == ar[i]){
                ++i;
            }
            if(i == RANDOMS_LENGTH){
                return seed;
            }
        }
        return -1;
    }
}