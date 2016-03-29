//https://www.hackerrank.com/challenges/arithmetic-progressions
//
//Defbuildions:
//   f(a, d) = {a, a + d, a + 2d, ...}
//   F(a, d, p) = {(a)^p, (a + d)^p, (a + 2d)^p, ...}
//   G(a1, a2, ..., aN, d1, d2, ..., dN, p1, p2, ..., pN) =  F(a1, d1, p1) * F(a2, d2, p2) * ... * F(aN, dN, pN)
//      where F(ax, dx, px) * F(ay, dy, py) = {X0*Y0, X1*Y1, X2*Y2, ...} where XM = (ax + Mdx)^px and Y = (ay + Mdy)^py
//
//Problem: Find how many derivatives is needed before constant value; also find the constant value
//
// Easiest explanation (personal opinion):
//
//Work:
//   Let x = f(a1, d1) and y = f(a2, d2):
//   G(a1, a2, d1, d2, p1, p2) 
//      = F(a1, d1, p1) * F(a2, d2, p2) 
//      = f(a1, d1) ^ p1 * f(a2, d2) ^ p2
//      = x ^ p1 * y ^ p2
//
// G = F(a1, d1, p1) *
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
import java.io.*;
import java.util.*;

public class Solution{

	private final static int MOD = 1000003;

	public static void main(String[] args) throws IOException{
		final StringBuilder sb = new StringBuilder();
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//Get input
		final int N = Integer.parseInt(br.readLine());
		int[] D = new int[N];
		int[] P = new int[N];
		for(int n = 0; n < N; ++n){
			String[] temp = br.readLine().split(" ");
			D[n] = Short.parseShort(temp[1]);
			P[n] = Integer.parseInt(temp[2]);
		}

		//Initialize
		RSQ pSums = new RSQ(P);
        RPQ dpProds = new RPQ(D, P, MOD);
		FactorialCache facts = new FactorialCache(MOD);
        D = null;
        P = null;

		//For each query
		for(int Q = Integer.parseInt(br.readLine()); Q > 0; --Q){
			String[] temp = br.readLine().split(" ");
			final int I = Integer.parseInt(temp[1]) - 1;
			final int J = Integer.parseInt(temp[2]) - 1;
			
			//If update
			if (temp.length > 3){
				final short V = Short.parseShort(temp[3]);
                pSums.update(I, J, V);
                dpProds.update(I, J, V);
			//If query
			} else {
                long V = 0;
				final long K = pSums.get(I, J);
                final long F = facts.get(K);
                if (K > 0){
                    V = (F * dpProds.get(I, J)) % MOD;
                }
				sb.append(K).append(" ").append(V).append("\n");
			}
		}

		//Print
		System.out.print(sb);
	}
    
    private static long pow(final long base, final long power, final int mod){
        if (power < 2L){
            return (power < 1L) ? 1 % mod : base % mod;
        }
        long sq = pow(base, power >> 1L, mod);
        sq = (sq * sq) % mod;
        return ((power & 1L) == 0L) ? sq : (sq * base) % mod;
    }

	public static class FactorialCache{
		
		private int mod;
        private int size;
		private int[] factorials;

		public FactorialCache(int mod){
            this.size = 2;
			this.mod = mod;
			this.factorials = new int[mod];
			factorials[0] = 1;
            factorials[1] = 1;
		}
        
		public int get(long index){

			if (index < 0 || index >= mod){
				return 0;
			}
            
            while (size <= index){
                long prod = size;
                prod = (prod * this.factorials[size - 1]) % this.mod;
                this.factorials[size++] = (int)prod;
            }

			return this.factorials[(int)index];
		}
	}
    
    public static class RSQ{
        private final int length;
        private final long[] data;
        private final long[] lazy;
        
        public RSQ(final int[] A){
            this.length = A.length;
            final int height = (int)Math.ceil(Math.log(this.length)/Math.log(2));
            final int size = (1 << (height + 1)) - 1;
            this.data = new long[size];
            this.lazy = new long[size];
            build(A, 0, this.length - 1, 0);
        }
        
        private long build(final int[] A, final int min, final int max, final int i){
            if (min == max){
                return data[i] = A[min];
            }
            final int mid = getMid(min, max);
            return data[i] = build(A, min, mid, getLeft(i)) + 
                            build(A, mid+1, max, getRight(i));
        }
        
        public long get(int ql, int qr){
            return get(0, this.length - 1, ql, qr, 0);
        }
        
        private long get(final int min, final int max, final int ql, final int qr, final int i){
            if (max < ql || min > qr){
                return 0L;
            }
            final int left = getLeft(i);
            final int right = getRight(i);
            if(lazy[i] > 0){
                data[i] += lazy[i]*(max - min + 1);
                if (min < max){
                    lazy[left] += lazy[i];
                    lazy[right] += lazy[i];
                }
                lazy[i] = 0;
            }
            if (min >= ql && max <= qr){
                return data[i];
            }
            final int mid = getMid(min, max);
            return get(min, mid, ql, qr, left) + get(mid+1, max, ql, qr, right);
        }
        
        public void update(final int ql, final int qr, final int v){
            update(0, this.length - 1, ql, qr, 0, v);
        }
        
        private long update(final int min, final int max, final int ql, final int qr, final int i, final int v){
            final int left = getLeft(i);
            final int right = getRight(i);
            if(lazy[i] > 0){
                data[i] += lazy[i]*(max - min + 1);
                if (min < max){
                    lazy[left] += lazy[i];
                    lazy[right] += lazy[i];
                }
                lazy[i] = 0;
            }
            if (max < ql || min > qr){
                return data[i];
            }
            if (min >= ql && max <= qr){
                data[i] += ((long)v)*(max - min + 1);
                if (min < max){
                    lazy[left] += v;
                    lazy[right] += v;
                }
                return data[i];
            }
            final int mid = getMid(min, max);
            return data[i] = update(min, mid, ql, qr, left, v) + update(mid+1, max, ql, qr, right, v);
        }
        
        private static int getMid(final int a, final int b){
            return a + ((b - a) >> 1);
        }
        
        private static int getLeft(final int i){
            return 1 + (i << 1);
        }
        
        private static int getRight(final int i){
            return (1 + i) << 1;
        }
    }
    
    
    public static class RPQ{
        private final int mod;
        private final int length;
        private final long[] base;
        private final long[] data;
        private final long[] power;
        
        public RPQ(final int[] B, final int[] P, int mod){
            this.mod = mod;
            this.length = B.length;
            final int height = (int)Math.ceil(Math.log(this.length)/Math.log(2));
            final int size = (1 << (height + 1)) - 1;
            this.base = new long[size];
            this.data = new long[size];
            this.power = new long[size];
            buildBase(B, 0, this.length - 1, 0);
            buildData(B, P, 0, this.length - 1, 0);
        }
        
        private long buildData(final int[] B, final int[] P, final int min, final int max, final int i){
            if (min == max){
                return data[i] = pow(B[min], P[min], mod);
            }
            final int mid = getMid(min, max);
            return data[i] = (buildData(B, P, min, mid, getLeft(i)) * buildData(B, P, mid+1, max, getRight(i))) % mod;
        }
        
        private long buildBase(final int[] A, final int min, final int max, final int i){
            if (min == max){
                return base[i] = A[min];
            }
            final int mid = getMid(min, max);
            return base[i] = (buildBase(A, min, mid, getLeft(i)) * buildBase(A, mid+1, max, getRight(i))) % mod;
        }
        
        public long get(int ql, int qr){
            return get(0, this.length - 1, ql, qr, 0);
        }
        
        private long get(final int min, final int max, final int ql, final int qr, final int i){
            if (max < ql || min > qr){
                return 1;
            }
            final int left = getLeft(i);
            final int right = getRight(i);
            if(power[i] > 0){
                data[i] = (data[i] * pow(base[i], power[i], mod)) % mod;
                if (min < max){
                    power[left] += power[i];
                    power[right] += power[i];
                }
                power[i] = 0;
            }
            if (min >= ql && max <= qr){
                return data[i];
            }
            final int mid = getMid(min, max);
            return (get(min, mid, ql, qr, left) * get(mid+1, max, ql, qr, right)) % mod;
        }
        
        public void update(final int ql, final int qr, final int v){
            update(0, this.length - 1, ql, qr, 0, v);
        }
        
        private long update(final int min, final int max, final int ql, final int qr, final int i, final int v){
            final int left = getLeft(i);
            final int right = getRight(i);
            if(power[i] > 0){
                data[i] = (data[i] * pow(base[i], power[i], mod)) % mod;
                if (min < max){
                    power[left] += power[i];
                    power[right] += power[i];
                }
                power[i] = 0;
            }
            if (max < ql || min > qr){
                return data[i];
            }
            if (min >= ql && max <= qr){
                data[i] = (data[i] * pow(base[i], v, mod)) % mod;
                if (min < max){
                    power[left] += v;
                    power[right] += v;
                }
                return data[i];
            }
            final int mid = getMid(min, max);
            return data[i] = (update(min, mid, ql, qr, left, v) * update(mid+1, max, ql, qr, right, v)) % mod;
        }
        
        private static int getMid(final int a, final int b){
            return a + ((b - a) >> 1);
        }
        
        private static int getLeft(final int i){
            return 1 + (i << 1);
        }
        
        private static int getRight(final int i){
            return (1 + i) << 1;
        }
    }
}
