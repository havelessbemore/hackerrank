//Week 2, Tuesday
//https://www.hackerrank.com/contests/w2/challenges/cut-the-tree
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //Get vertex values and tree sum
        Vertex[] verts = new Vertex[N];
        N = 0;
        int sum = 0;
        for(String s : br.readLine().split(" ")){
            short v = Short.parseShort(s);
            sum += v;
            verts[N++] = new Vertex(v);
        }
        
        //Get edges
        while (--N > 0){
            String[] temp = br.readLine().split(" ");
            int i1 = Integer.parseInt(temp[0]) - 1;
            int i2 = Integer.parseInt(temp[1]) - 1;
            verts[i1].addEdge(verts[i2], sum);
            verts[i2].addEdge(verts[i1], sum);
        }
        
        //Initialize
        Vertex.init(verts[0]);
        
        //Find smallest diff
        int min = Integer.MAX_VALUE;
        for(Vertex vertex : verts){
            int curMin = vertex.minDiff(sum);
            //Update min
            min = (curMin < min) ? curMin : min;
        }
        
        //Output
        System.out.print(min);
    }
    
    private static class Vertex{
        private int minDiff;
        private short value;
        private boolean isInit;
        private List<Edge> edges;
        public Vertex(short value){
            this.value = value;
            this.isInit = false;
            this.edges = new ArrayList<Edge>();
        }
        
        public void addEdge(Vertex vertex, int value){
            edges.add(new Edge(vertex, value));
        }
        
        public int minDiff(int sum){
            int min = sum;
            for(Edge edge : edges){
                //Get difference of both possible trees
                int curMin = sum - 2*edge.value;
                //Make absolute value
                curMin = (curMin < 0) ? -curMin : curMin;
                //Update min
                min = (curMin < min) ? curMin : min;
            }
            return min;
        }
        
        public static void init(Vertex v){
            if (!v.isInit){
                v.init();
            }
        }
        
        private int init(){
            this.isInit = true;
            Edge caller = null;
            int sum = this.value;
            //For each edge
            for(Edge edge : edges){
                //If it's the caller, save for later
                if (edge.vertex.isInit){
                    caller = edge;
                //Otherwise, get the sum of
                //all vertices for that edge
                } else {
                    sum += edge.value = edge.vertex.init();
                }
            }
            //If it's the caller
            //subtract this vertex's
            //sum from the tree's sum
            if (caller != null){
                caller.value -= sum;
            }
            return sum;
        }
        
        private class Edge{
            public int value;
            public Vertex vertex;
            public Edge(Vertex vertex, int value){
                this.value = value;
                this.vertex = vertex;
            }
        }
    }
}