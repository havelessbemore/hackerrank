//https://www.hackerrank.com/challenges/arithmetic-progressions
import java.io.*;
import java.util.*;
//
//Definitions:
//   f(a, d) = {a, a + d, a + 2d, ...}
//   F(a, d, p) = {(a)^p, (a + d)^p, (a + 2d)^p, ...}
//   G(a1, a2, ..., aN, d1, d2, ..., dN, p1, p2, ..., pN) =  F(a1, d1, p1) * F(a2, d2, p2) * ... * F(aN, dN, pN)
//      where F(ax, dx, px) * F(ay, dy, py) = {X0*Y0, X1*Y1, X2*Y2, ...} where XM = (ax + Mdx)^px and Y = (ay + Mdy)^py
//
//Problem: Find how many derivatives is needed before constant value; also find the constant value
//
//Work:
//   Let x = f(a1, d1) and y = f(a2, d2):
//   G(a1, a2, d1, d2, p1, p2) 
//      = F(a1, d1, p1) * F(a2, d2, p2) 
//      = f(a1, d1) ^ p1 * f(a2, d2) ^ p2
//      = x ^ p1 * y ^ p2
//
//Example 1: Let p1 = 1 and p2 = 1:
//   G   = xy
//   G'  = y + x
//   G'' = 1 + 1 = 2
//
//   Now let a1 = 1, d1 = 2 and a2 = 3, d2 = 5:
//   G   = F(a1, d1, p1) * F(a2, d2, p2) = F(1, 2, 1) * F(3, 5, 1)
//       = {1 * 3, 3 * 8, 5 * 13, 7 * 18, 9 * 23, 28 * 11, ...}
//       = {3, 24, 65, 126, 207, 308, ...}
//   G'  = {24 - 3, 65 - 24, 126 - 65, 207 - 126, 308 - 207, ...}
//       = {21, 41, 61, 81, 101, ...}
//   G'' = {41 - 21, 61 - 41, 81 - 61, 101 - 81, ...}
//       = {20, 20, 20, 20, ...}
//
//   Derivatives: 2, Constant: 20
//
//Example 2: Let p1 = 1 and p2 = 2
//   G    = xy^2
//   G'   = y^2 + 2xy
//   G''  = 2y + 2y + 2x = 2x + 4y
//   G''' = 2 + 4 = 6
//
//   Now let a1 = 1, d1 = 2 and a2 = 3, d2 = 5:
//   G    = F(a1, d1, p1) * F(a2, d2, p2) = F(1, 2, 1) * F(3, 5, 2)
//        = {1 * 9, 3 * 64, 5 * 169, 7 * 324, 9 * 529, 11 * 784}
//        = {9, 192, 845, 2268, 4761, 8624, ...}
//   G'   = {192 - 9, 845 - 192, 2268 - 845, 4761 - 2268, 8624 - 4761, ...}
//        = {183, 653, 1423, 2493, 3863, ...}
//   G''  = {653 - 183, 1423 - 653, 2493 - 1423, 3863 - 2493, ...}
//        = {470, 770, 1070, 1370, ...}
//   G''' = {770 - 470, 1070 - 770, 1370 - 1070, ...}
//        = {300, 300, 300, ...}
//
//   Derivatives: 3, Constant: 300
//
//Conclusion:
//   After doing these and a few more to verify, a pattern can be noticed:
//   In example 1: Derivatives = 2 = 1 + 1 = p1 + p2
//   In example 2: Derivatives = 3 = 1 + 2 = p1 + p2
//   In example 1: Constant = 20  = 10 * 2 = (2 * 5) * 2 = (d1 * d2) * (p1 + p2)
//   More precisely: In example 2: Constant = 300 = 50 * 6 = (2 * 5^2) * (1 + 2)! = (d1^p1 * d2^p2) * (p1 + p2)!
//
//   Finally, extending from this:
//   G(a1, a2, ..., aN, d1, d2, ..., dN, p1, p2, ..., pN) = (d1^p1 * d2^p2 * ... * dN^pN) * (p1 + p2 + ... + pN)!
//
public class Solution{
	public static void main(String[] args) throws IOException{
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Get input
		int N = Integer.parseInt(br.readLine());
		short[] D = new short[N];
		short[] P = new short[N];
		for(int n = 0; n < N; ++n){
			String[] temp = br.readLine().split(" ");
			//A
			D[n] = Short.parseShort(temp[1]);
			P[n] = Short.parseShort(temp[2]);
		}



		for(int Q = Integer.parseInt(br.readLine()); Q > 0; --Q){
			String[] temp = br.readLine().split(" ");
			int I = Integer.parseInt(temp[1]);
			int J = Integer.parseInt(temp[2]);
			//...
		}
	}
}