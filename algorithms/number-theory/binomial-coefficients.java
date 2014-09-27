//https://www.hackerrank.com/challenges/binomial-coefficients
//See: http://www.math.hmc.edu/funfacts/ffiles/30002.4-5.shtml

/*

//Updated version using BigInteger

import java.io.*;
import java.math.*;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            BigInteger N = new BigInteger(temp[0]);
            BigInteger P = new BigInteger(temp[1]);
            
            BigInteger R = BigInteger.ONE;
            BigInteger NP1 = N.add(BigInteger.ONE);
            while (N.compareTo(P) >= 0){
                BigInteger[] ar = N.divideAndRemainder(P);
                BigInteger quotient = ar[0];
                BigInteger remainder = ar[1];
                R = R.multiply(remainder.add(BigInteger.ONE));
                N = quotient;
            }
            R = R.multiply(N.add(BigInteger.ONE));
            R = NP1.subtract(R);
            
            sb.append(R + "\n");
        }
        
        System.out.print(sb);
    }
}

*/

//Original version using custom Number class

import java.io.*;

public class Solution{
    
    public static void main(String[] args) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
            String[] temp = br.readLine().split(" ");
            int P = Integer.parseInt(temp[1]);
            Number N = new Number(temp[0], 10);
            Number NbP = N.clone();
            NbP.base(P);
            NbP.base(NbP.base()+1, false);
            NbP.addeq(new Number(array(NbP.digits(), 1), NbP.base()));
            Number X = NbP.multiplyDigits();
            N.addeq(new Number(1));
            N.subeq(X);
            sb.append(N + "\n");
        }
        System.out.print(sb);
    }
    
    private static int[] array(int length, int val){
        int[] ar = new int[length];
        while (length-- > 0){
            ar[length] = val;
        }
        return ar;
    }
    
    public static class Number{
        private int base;
        private int[] num; //Little endian
        private int digits;
        
        //Only supports strings up to base 10
        public Number(String str, int base){
            this(strToIntArr(str), base);
        }

        public Number(int num){
            this(num, 10);
        }
        
        //Supports any int base
        public Number(int num, int base){
            this(intToIntArr(num, base), base);
        }
        
        //Supports any int base
        public Number(int[] num, int base){
            this.num = num;
            this.base = base;
            this.digits = this.num.length;
            subDigits();
        }
        
        ////////////////////////
        //        DIGITS      //
        ////////////////////////
        
        public int digits(){
            return this.digits;
        }
        
        private void subDigits(){
            while (this.digits > 0 && this.num[this.digits - 1] < 1){
                this.digits--;
            }
        }
        
        private void addDigits(){
            while (this.digits < this.num.length && this.num[this.digits] > 0){
                this.digits++;
            }
        }
        
        ////////////////////////
        //        BASE        //
        ////////////////////////
        
        public int base(){
            return this.base;
        }
        
        public void base(int B){
            base(B, true);
        }
        
        public void base(int B, boolean convert){
            if (convert){
                int i;
                int[] N = this.num;
                int X = this.digits;
                int A = this.base;
                int Y = (int)(1.0d + X * Math.log(A) / Math.log(B));
                int[] ar = new int[Y];
                for(i = 0; i < Y && X > 0; ++i){
                    ar[i] = Number.diveq(N, X, A, B);
                    while (X > 0 && N[X-1] < 1){
                        --X;
                    }
                }
                this.num = ar;
                this.digits = i;
            }
            this.base = B;
        }
        
        ////////////////////////
        //         DIV        //
        ////////////////////////
        
        /*
        public int diveq(Number N){
        }
        */
        
        private static int diveq(int[] dividend, int length, int base, int divisor){
            long remainder = 0L;
            while(length-- > 0){
                remainder = remainder*base + dividend[length];
                dividend[length] = (int)(remainder/divisor);
                remainder %= divisor;
            }
            return (int)remainder;
        }
        
        ////////////////////////
        //         SUB        //
        ////////////////////////
        
        //Only works if difference is >= 0
        public void subeq(Number N){
            if (N.base != this.base){
                N = N.clone();
                N.base(this.base);
            }
            Number.subeq(this.num, this.digits, N.num, N.digits, this.base);
            subDigits();
        }
        
        //Only works if minuend >= subtrahend
        private static void subeq(int[] minuend, int mLength, int[] subtrahend, int sLength, int base){
            byte borrow = 0;

            //Subtract common indices
            for(int i = 0; i < sLength; ++i){
                minuend[i] -= subtrahend[i] + borrow;
                borrow = 0;
                if (minuend[i] < 0){
                    borrow = 1;
                    minuend[i] += base;
                }
            }

            //Subtract the remainding borrows
            if (borrow > 0){
                int i = sLength;
                int afterBorrow = base-1;
                while (i < mLength && minuend[i] == 0){
                    minuend[i++] = afterBorrow;
                }
                minuend[i] -= 1;
            }
        }
        
        ////////////////////////
        //         ADD        //
        ////////////////////////
        
        public void addeq(Number N){
            //Switch N to same base
            if (N.base != this.base){
                N = N.clone();
                N.base(this.base);
            }
            //Get max size of array needed
            int length = this.digits > N.digits ? this.digits + 1 : N.digits + 1;
            //Copy over current array to new array if needed
            this.num = this.num.length < length ? Number.arrayCopy(this.num, new int[length], 0, this.digits) : this.num;
            //Add
            Number.addeq(this.num, this.digits, N.num, N.digits, this.base);
            //Check for added digits
            addDigits();
        }
        
        private static void addeq(int[] adduend, int aLength, int[] addend, int bLength, int base){
            byte carry = 0;
            
            //Add together common indices
            for(int i = 0; i < bLength; ++i){
                adduend[i] += addend[i] + carry;
                carry = 0;
                if (adduend[i] >= base){
                    carry = 1;
                    adduend[i] -= base;
                }
            }
            
            //Add the remainding carries
            if (carry > 0){
                int i = bLength;
                int needsCarry = base-1;
                while(i < aLength && adduend[i] == needsCarry){
                    adduend[i++] = 0;
                }
                adduend[i] += 1;
            }
        }
        
        ////////////////////////
        //        MULT        //
        ////////////////////////
        
        public void multeq(Number multiplier){
            //Switch multiplier to same base
            if (multiplier.base != this.base){
                multiplier = multiplier.clone();
                multiplier.base(this.base);
            }
            //Create new array to fit product
            int[] product = new int[this.digits + multiplier.digits];
            //Multiply
            Number.multeq(this.num, this.digits, multiplier.num, multiplier.digits, product, product.length, this.base);
            this.num = product;
            //Check for added digits
            this.digits = product.length;
            subDigits();
        }
        
        private static void multeq(int[] multiplicand, int aLen, int[] multiplier, int bLen, int[] product, int cLen, int base){
            //For each digit of multiplier
            for(int i = 0; i < bLen; ++i){
                int j;
                int carry = 0;
                
                //Multiply multiplicand by digit
                for(j = 0; j < aLen; ++j){
                    long prod = (((long)multiplier[i]) * multiplicand[j]) + product[i+j] + carry;
                    carry = 0;
                    if (prod >= base){
                        carry = (int)(prod/base);
                        prod %= base;
                    }
                    product[i+j] = (int)prod;
                }
                
                //Add the remainding carry
                product[i+j] = carry;
            }
        }
        
        ////////////////////////
        //        OTHER       //
        ////////////////////////
        
        public Number multiplyDigits(){
            Number N = new Number("1", 10);
            
            for(int i = 0; i < this.digits; ++i){
                N.multeq(new Number(this.num[i]));
            }
            
            return N;
        }
        
        ////////////////////////
        //       HELPERS      //
        ////////////////////////
        
        private static int[] intToIntArr(int num, int base){
            int i;
            int A = 10;
            int Y = (int)(1.0d + Math.log(num)*Math.log(A)/Math.log(base));
            int[] ar = new int[Y];
            for(i = 0; i < Y && num > 0; ++i){
                ar[i] = num % base;
                num /= base;
            }
            return ar;
        }
        
        //Only supports strings up to base 10
        private static int[] strToIntArr(String str){
            int n = str.length();
            int[] ar = new int[n];
            for(char c : str.toCharArray()){
                ar[--n] = c - '0';
            }
            return ar;
        }
        
        public void shrink(){
            if (this.num.length > this.digits){
                this.num = Number.arrayCopy(this.num, this.digits);
            }
        }
        
        public int[] toArray(){
            return Number.arrayCopy(this.num, this.digits);
        }
        
        public Number clone(){
            return new Number(Number.arrayCopy(this.num, this.digits), this.base);
        }
        
        public String toString(){
            StringBuffer sb = new StringBuffer();
            int length = this.digits;
            if (length < 1){
                return "0";
            }
            while (length-- > 0){
                sb.append(this.num[length]);
            }
            return sb.toString();
        }
        
        private static int[] arrayCopy(int[] N, int length){
            return Number.arrayCopy(N, new int[length], 0, length);
        }
        
        private static int[] arrayCopy(int[] N, int[] ar, int min, int max){
            while(max-- > min){
                ar[max] = N[max];
            }
            return ar;
        }
    }
} 
