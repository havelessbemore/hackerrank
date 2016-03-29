//https://www.hackerrank.com/challenges/common-divisors
import java.io._;
import scala.collection.mutable.HashMap;

object Solution {
    //Memoize all possible primes for input range
    //(that are possible divisors of two different numbers)
    var MAX: Int = 100000000;
    var primes: Array[Int] = sieveOfEratosthenes(math.ceil(math.sqrt(MAX)).toInt);
    
    def main(args: Array[String]) {
        for(t <- 0 until readLine().toByte){
            var temp: Array[Int] = readLine().split(" ").map((x) => x.toInt);
            var L: Int = temp(0);
            var M: Int = temp(1);
            var primes: HashMap[Int, Int] = getCommonFactors(
                getPrimeFactors(L), getPrimeFactors(M)
            );
            var total: Int = 1;
            for((prime, count) <- primes){
                total *= count+1;
            }
            println(total);
        }
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