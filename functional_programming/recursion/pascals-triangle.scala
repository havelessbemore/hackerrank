//https://www.hackerrank.com/challenges/pascals-triangle

object Solution {
    
    def pascalTriangle(k: Byte){
        pascalRow(1, k, (new Array[Short](k)).map((_) => 1.toShort));
    }
    
    def pascalRow(i: Byte, k: Byte, row: Array[Short]){
        if (i > k){
            return;
        }
        for(j <- i-2 until 0 by -1){
            row(j) = (row(j) + row(j-1)).toShort;
        }
        println(row.slice(0, i).mkString(" "));
        pascalRow((i+1).toByte, k, row);
        
    }
    
    def main(args: Array[String]) {
        pascalTriangle(readByte())
    }
}
