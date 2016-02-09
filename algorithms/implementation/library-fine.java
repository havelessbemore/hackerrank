//https://www.hackerrank.com/challenges/library-fine
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        //Get actual date
        byte actualDay = s.nextByte();
        byte actualMonth = s.nextByte();
        short actualYear = s.nextShort();
        
        //Get expected date
        byte expectedDay = s.nextByte();
        byte expectedMonth = s.nextByte();
        short expectedYear = s.nextShort();
        
        //Calculate fine
        short fine = 0;
        if(actualYear == expectedYear){
            if(actualMonth == expectedMonth){
                if(actualDay > expectedDay){
                    fine = (short)(15*(actualDay - expectedDay));
                }
            } else if(actualMonth > expectedMonth){
                fine = (short)(500*(actualMonth - expectedMonth));
            }
        } else if (actualYear > expectedYear){
            fine = (short)10000;
        }
        
        //Print output
        System.out.print(fine);
    }
}
