//https://www.hackerrank.com/challenges/fp-filter-positions-in-a-list

def f(arr: List[Int]): List[Int] = {
    return arr.zipWithIndex.filter((x) => (x._2&1) == 1).map((x) => x._1);
}