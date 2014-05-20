//https://www.hackerrank.com/challenges/kmp-fp
//See: http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm

object Solution {
    
    def main(args: Array[String]) {
        val sb: StringBuilder = new StringBuilder();
        
        //For each test
        for(t <- 0 until readByte()){
           
            //Get input
            val text: String = readLine();
            val pat: String = readLine();
            
            //Solve
            if (isSubstring(text, pat)){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        
        //Print
        print(sb);
    }
    
    def isSubstring(str: String, substr: String): Boolean = {
        return KMPSearch(str.toCharArray, substr.toCharArray) >= 0;
    }
    
    def KMPSearch(S: Array[Char], W: Array[Char]): Int = {
        var m: Int = 0;
        var i: Int = 0;
        val T: Array[Int] = getKMPTable(W);
        
        while (m + i < S.length){
            if (W(i) == S(m+i)){
                if (i == W.length - 1){
                    return m;
                }
                i += 1;
            } else if (T(i) > -1){
                i = T(i);
                m += i - T(i);
            } else {
                i = 0;
                m += 1;
            }
        }
        
        return -1;
    }
    
    def getKMPTable(W: Array[Char]): Array[Int] = {
        var pos: Int = 2;
        var cnd: Int = 0;
        
        val N: Int = W.length;
        val T: Array[Int] = new Array[Int](math.max(2,N));
        T(0) = -1;
        T(1) = 0;
        
        while (pos < N){
            if(W(pos-1) == W(cnd)){
                cnd += 1;
                T(pos) = cnd;
                pos += 1;
            } else if(cnd > 0){
                cnd = T(cnd);
            } else {
                T(pos) = 0;
                pos += 1;
            }
        }
        
        return T;
    }
    
}