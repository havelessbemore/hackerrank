//https://www.hackerrank.com/challenges/range-minimum-query
//See: http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/
//See: http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static

object Solution {
    
    class SegmentTree(arr: Array[Int]){
        val length: Int = arr.length;
        val height: Int = math.ceil(math.log(length)/math.log(2)).toInt;
        val size: Int = math.pow(2, height + 1).toInt - 1;
        val mins: Array[Int] = new Array[Int](size);
        init(arr, 0, length-1, mins, 0);
        
        def init(input: Array[Int], minI: Int, maxI: Int, mins: Array[Int], index: Int): Int = {
            if (minI == maxI){
                mins(index) = input(minI);
                return arr(minI);
            }
            
            val midI: Int = mid(minI, maxI);
            mins(index) = min(init(input, minI, midI, mins, leftChild(index)),
                            init(input, midI+1, maxI, mins, rightChild(index)));
            return mins(index);
        }
        
        def getMin(left: Int, right: Int): Int = {
            return getMinUtil(mins, 0, length-1, left, right, 0);
        }
        
        def getMinUtil(mins: Array[Int], minI: Int, maxI: Int, left: Int, right: Int, index: Int): Int = {
            if (left <= minI && right >= maxI){
                return mins(index);
            }
            
            if (maxI < left || minI > right){
            	return Int.MaxValue;
            }
            
            val midI: Int = mid(minI, maxI);
            return min(getMinUtil(mins, minI, midI, left, right, leftChild(index)),
            			getMinUtil(mins, midI+1, maxI, left, right, rightChild(index)));

        }

        def min(a: Int, b: Int): Int = {
        	if (a < b){
        		return a;
        	}
        	return b;
        }

        def mid(min: Int, max: Int): Int = {
        	return min + (max - min)/2;
        }

        def leftChild(i: Int): Int = {
        	return 2*i + 1;
        }

        def rightChild(i: Int): Int = {
        	return 2*i + 2;
        }
    }
    
    def main(args: Array[String]) {
        //Input
        val Array(n, m) = readLine().split(" ").map(_.toInt);
        val arr: Array[Int] = readLine().split(" ").map(_.toInt);
        
        //Create tree
        val tree : SegmentTree = new SegmentTree(arr);
        
        //For every query
        val sb: StringBuilder = new StringBuilder();
        for(q <- 0 until m){
            
            //Get range and output min
            val Array(l, r) = readLine().split(" ").map(_.toInt);
            sb.append(tree.getMin(l, r) + "\n");
        }
        
        //Print
        print(sb);
    }
}