//https://www.hackerrank.com/challenges/gem-stones
import java.io.*;

public class Solution{
    private final static char MIN_ELEMENT = 'a';
    private final static char MAX_ELEMENT = 'z';
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte N = Byte.parseByte(br.readLine());
        
        //Get the number of elements possible
        int numElements = MAX_ELEMENT - MIN_ELEMENT + 1;

        //Counts the number of compositions
        //each element can be found in
        byte[] elementCompCounts = new byte[numElements];
        
        //For each composition
        for(byte i = 0; i < N; ++i){

            //Get the elements for the composition
            char[] elements = br.readLine().toCharArray();

            //Count the occurences of each element
            byte[] elementCounts = new byte[numElements];
            for(char c : elements){
                elementCounts[c - MIN_ELEMENT]++;
            }

            //Increase the element's composition count
            //if found at least once in this composition
            for(int j = 0; j < numElements; ++j){
                elementCompCounts[j] += (elementCounts[j] > 0) ? 1 : 0;
            }
        }
        
        //Count the number of elements 
        //that appear in every composition
        byte gemCount = 0;
        for(int i = 0; i < numElements; ++i){
            gemCount += (elementCompCounts[i] == N) ? 1 : 0;
        }

        //Output
        System.out.print(gemCount);
    }
}