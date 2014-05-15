//https://www.hackerrank.com/challenges/functional-programming-warmups-in-recursion---gcd
object Solution {
    
  def gcd(x: Int, y: Int): Int =
  {
    // You only need to fill up this function
    // To return the value of the GCD of x and y
    if (y == 0){
      return x;
    }
    gcd(y, x%y);
  }
  
  /**This part handles the input/output. Do not change or modify it **/
  def acceptInputAndComputeGCD(pair:List[Int]) = {
    println(gcd(pair.head,pair.reverse.head))
  } 

  def main(args: Array[String]) {
    /** The part relates to the input/output. Do not change or modify it **/
    (readLine().trim().split(" ").map(x=>x.toInt).toList)
  }
}