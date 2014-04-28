//https://www.hackerrank.com/contests/lambda-calculi-apr14/challenges/jumping-bunnies
import java.io._;
import scala.collection.mutable._;

object Solution {

    def main(args: Array[String]) {
        //Input
        var N: Byte = readLine().toByte;
        var J: Array[Int] = new Array[Int](N);
        var S: Array[String] = readLine().split(" ");
        for(i <- 0 until J.length){
            J(i) = S(i).toInt;
        }
        //Find the common point for consecutive jumps
        var nearestPoint: Map[Int, Int]  = Map[Int, Int]();
        for(j <- J){
            var jump: Map[Int, Int] = getPrimePowers(j);
            subtractCommonPowers(jump, nearestPoint);
            addPowers(nearestPoint, jump);
        }
        //Convert from map of primes and their powers to long
        var point: Long = 1;
        for ((factor, power) <- nearestPoint){
            point *= math.pow(factor, power).toLong;
        }
        //Output
        println(point);
    }

    def addPowers(n: Map[Int, Int], q: Map[Int, Int]){
        for((factor, power) <- q){
            var newPower = power;
            if (n.contains(factor)){
                newPower += n(factor);
            }
            n(factor) = newPower;
        }
    }

    def subtractCommonPowers(n: Map[Int, Int], q: Map[Int, Int]) {
        for((factor, power) <- n){
            if (q.contains(factor)){
                val sub: Int = power - q(factor);
                if (sub <= 0){
                    n-=(factor);
                } else {
                    n(factor) = sub;
                }
            }
        }
    }

    def getPrimePowers(input: Int) : Map[Int, Int] = {
        var n: Int = input;
        var map : Map[Int, Int] = Map[Int, Int]();
        n = getPower(n, 2, map);
        val maxFactor : Int = math.floor(math.sqrt(n)).toInt;
        var factor: Int = 3;
        while (n >= factor && factor <= maxFactor){
            n = getPower(n, factor, map);
            factor += 2;
        }
        if (n > 1){
            map(n) = 1;
        }
        return map;
    }

    def getPower(num: Int, divisor: Int, map: Map[Int, Int]) : Int = {
        var q: Int = 0;
        var n: Int = num;
        while (n % divisor == 0){
            q += 1;
            n = n / divisor;
        }
        if (q > 0){
            map(divisor) = q;
        }
        return n;
    }
}