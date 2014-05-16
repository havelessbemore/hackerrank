//https://www.hackerrank.com/challenges/eval-ex

object Solution {
    def f(x: Float): Float = {
        se(x, 9);
    }

    def fact(x: Int): Int = {
        if (x == 0){
            return 1;
        }
        return x * fact(x-1);
    }

    def pow(base: Float, power: Int): Float = {
        if (power == 0){
            return 1;
        }
        return base * pow(base, power-1);
    }

    def se(x: Float, steps: Int): Float = {
        if (steps == 0){
            return 1;
        }
        return pow(x, steps)/fact(steps).toFloat + se(x, steps-1);
    }

    def main(args: Array[String]) {
       var n = readInt
       (1 to n) foreach(x=> println(f(readFloat())))
    }
}