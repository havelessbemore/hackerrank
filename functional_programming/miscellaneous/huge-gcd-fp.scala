//https://www.hackerrank.com/challenges/huge-gcd-fp
import java.io._;
import scala.collection.mutable.HashMap;

object Solution {
    //Memoize all possible primes for input range
    //(that are possible divisors of two different numbers)
    var MAX: Int = 10000;
    var MOD: Int = 1000000007;
    var primes: Array[Int] = sieveOfEratosthenes(math.ceil(math.sqrt(MAX)).toInt);
    
    def main(args: Array[String]) {
        var N: Short = readLine().toShort;
        var A: Array[Short] = readLine().split(" ").map((x) => x.toShort);
        var M: Short = readLine().toShort;
        var B: Array[Short] = readLine().split(" ").map((x) => x.toShort);
        
        var mA: HashMap[Int, Int] = new HashMap[Int, Int]();
        for(a <- A){
            mA = combineFactors(mA, getPrimeFactors(a));
        }
        A = null;
        
        var mB: HashMap[Int, Int] = new HashMap[Int, Int]();
        for(b <- B){
            mB = combineFactors(mB, getPrimeFactors(b));
        }
        B = null;
        
        var mC: HashMap[Int, Int] = getCommonFactors(mA, mB);
        mA = null;
        mB = null;
        
        var gcd: Int = 1;
        for((prime, count) <- mC){
            gcd = ((gcd.toLong*pow(prime, count, MOD))%MOD).toInt;
        }
        
        print(gcd);
    }
    
    def pow(base: Int, power: Int, mod: Int): Int = {
        if (power < 2){
            if (power < 1){
                return 1;
            }
            return base%mod;
        }
        var c: Long = pow(base, power>>1, mod);
        c = (c*c)%mod;
        if ((power&1) == 1){
            c = (c*base)%mod;
        }
        return c.toInt;
    }
    
    def combineFactors(m1: HashMap[Int, Int], m2: HashMap[Int, Int]): HashMap[Int, Int] = {
        var m3: HashMap[Int, Int] = m1.clone();
        for((prime, count) <- m2){
            m3.put(prime, m3.getOrElse(prime, 0) + count);
        }
        return m3;
    }

    def getCommonFactors(m1: HashMap[Int, Int], m2: HashMap[Int, Int]): HashMap[Int, Int] = {
        var m3: HashMap[Int, Int] = new HashMap[Int, Int]();
        for((prime, count) <- m1){
            if (m2.contains(prime)){
                m3.put(prime, math.min(count, m2.get(prime).get));
            }
        }
        return m3;
    }
    
    def getPrimeFactors(n: Int): HashMap[Int, Int] = {
        var num: Int = n;
        var max: Int = math.sqrt(num).toInt;
        var map: HashMap[Int, Int] = new HashMap[Int, Int]();
        for(prime <- primes){
            if ((num%prime) == 0){
                var count: Int = 0;
                do {
                    count += 1;
                    num /= prime;
                } while ((num%prime) == 0);
                map.put(prime, count);
                max = math.sqrt(num).toInt;
            }
            if (prime > max){
                if (num > 1){
                    map.put(num, 1);
                }
                return map;
            }
        }
        if (num > 1){
            map.put(num, 1);
        }
        return map;
    }
    
    def sieveOfEratosthenes(N: Int): Array[Int] = {
        //Uses a sieve of odd numbers from 3 to N
        var length: Int = N >> 1;
        var maxI: Int = math.ceil((math.sqrt(N) - 3)/2).toInt;
        var isComposite: Array[Boolean] = new Array[Boolean](length);
        var primeCount: Int = 1;
        for(i <- 0 until maxI if !isComposite(i)){
            primeCount += 1;
            var prime: Int = 2*i+3;
            for(j <- (prime*prime - 3)/2 until length by prime){
                isComposite(j) = true;
            }
        }
        for(i<- maxI until length if !isComposite(i)){
            primeCount += 1;
        }
        var j: Int = 1;
        var primes: Array[Int] = new Array[Int](primeCount);
        primes(0) = 2;
        for(i <- 0 until length if !isComposite(i)){
            primes(j) = 2*i + 3;
            j += 1;
        }
        return primes;
    }
}