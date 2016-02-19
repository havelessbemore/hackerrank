//https://www.hackerrank.com/challenges/dijkstrashortreach
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      //For each test case
      for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
        
        //Get number of nodes (N) and number of edges (M)
        String[] line = br.readLine().split(" ");
        final short N = Short.parseShort(line[0]);
        final int M = Integer.parseInt(line[1]);
        
        //Create nodes
        final Node[] nodes = new Node[N];
        for(short i = 0; i < N; ++i){
          nodes[i] = new Node(i);
        }
        
        //Get edges
        for(int i = 0; i < M; ++i){
          line = br.readLine().split(" ");
          final short x = (short)(Short.parseShort(line[0]) - 1);
          final short y = (short)(Short.parseShort(line[1]) - 1);
          final short r = Short.parseShort(line[2]);
          nodes[x].edges.add(new Edge(r, nodes[y]));
          nodes[y].edges.add(new Edge(r, nodes[x]));
        }
        
        //Get starting node id
        final short S = (short)(Short.parseShort(br.readLine().trim()) - 1);
        
        //Solve
        final int[] minDistances = getMinDistances(N, S, nodes);
        
        //Print output
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < N; ++i){
          if(i != S){
            sb.append(minDistances[i] + " ");
          }
        }
        System.out.println(sb);
      }
    }
    
    private static int[] getMinDistances(final short N, final short S, final Node[] nodes){
      
      //Initialize min distances, using -1 for infinity
      final int[] minDistances = new int[N];
      for(short i = 0; i < N; minDistances[i++] = -1){}
      minDistances[S] = 0;
      
      //Follow edges and record min distances to starting node
      final Queue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>(){
        @Override
        public int compare(Edge a, Edge b){
          return Short.compare(a.weight, b.weight);
        }
      });
      q.add(new Edge((short)0, nodes[S]));
      do{
        final Node node = q.poll().node;
        final int curDistance = minDistances[node.id];
        for(Edge edge : node.edges){
          int c = minDistances[edge.node.id];
          int n = edge.weight + curDistance;
          if(c < 0 || c > n){
            q.add(edge);
            minDistances[edge.node.id] = n;
          }
        }
      } while (!q.isEmpty());
      
      return minDistances;
    }
    
  private static class Node {
    public final short id;
    public final List<Edge> edges;
    public Node(final short id){
      this.id = id;
      this.edges = new LinkedList<Edge>();
    }
  }
  
  private static class Edge {
    public final short weight;
    public final Node node;
    public Edge(final short weight, final Node node){
      this.weight = weight;
      this.node = node;
    }
  }
}
