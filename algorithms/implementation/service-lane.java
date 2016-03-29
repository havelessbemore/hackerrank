//https://www.hackerrank.com/challenges/service-lane
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Get Input
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        short T = Short.parseShort(temp[1]);
        byte[] width = new byte[N];
        temp = br.readLine().split(" ");
        for(int i = 0; i < N; ++i){
            width[i] = Byte.parseByte(temp[i]);
        }
        //Run Tests
        while (T-- > 0){
            temp = br.readLine().split(" ");
            int i = Integer.parseInt(temp[0]);
            int j = Integer.parseInt(temp[1]);
            int min = width[i];
            while (min > 1 && i++ < j){
                min = min < width[i] ? min : width[i];
            }
            sb.append(min + "\n");
        }
        System.out.print(sb);
    }
}