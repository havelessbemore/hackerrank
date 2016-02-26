//https://www.hackerrank.com/challenges/rust-murderer
import java.io.*;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    final StringBuffer sb = new StringBuffer();
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //For each test case
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){
      
      //Get number of cities
      String[] line = br.readLine().split(" ");
      final int N = Integer.parseInt(line[0]);
      
      //Initialize edges
      final List<Set<Integer>> roads = new ArrayList<Set<Integer>>(N);
      for(int i = 0; i < N; ++i){
        roads.add(new HashSet<Integer>());
      }
      
      //Get edges
      for(short M = Short.parseShort(line[1]); M > 0; --M){
        line = br.readLine().split(" ");
        final int X = Integer.parseInt(line[0]) - 1;
        final int Y = Integer.parseInt(line[1]) - 1;
        roads.get(X).add(Y);
        roads.get(Y).add(X);
      }
      
      //Get Rust's starting position and find min distances
      final int S = Integer.parseInt(br.readLine()) - 1;
      final int[] minDistances = getEdgelessMinDistances(roads, S, N);
      
      //Print output
      for(int i = 0; i < S; sb.append(minDistances[i++] + " ")){}
      for(int i = S; ++i < N; sb.append(minDistances[i] + " ")){}
      sb.append("\n");
    }
    System.out.print(sb);
  }
  
  private static int[] getEdgelessMinDistances(final List<Set<Integer>> roads, final int origin, final int N){
    
    //Initialize distances
    final int[] distances = new int[N];
    for(int i = 0; i < N; distances[i++] = -1){}
    
    //Create a list of unvisited cities
    final List<Integer> unvisitedCities = new LinkedList<Integer>();
    for(int i = 0; i < origin; unvisitedCities.add(i++)){}
    for(int i = origin; ++i < N; unvisitedCities.add(i)){}
    
    //Find min distances
    final Queue<Integer> q = new LinkedList<Integer>();
    q.add(origin);
    do {
      final int city = q.poll();
      final int distance = ++distances[city];
      final Set<Integer> cityRoads = roads.get(city);
      for(Iterator<Integer> it = unvisitedCities.iterator(); it.hasNext();){
        final int unvisitedCity = it.next();
        if(!cityRoads.contains(unvisitedCity)){
          distances[unvisitedCity] = distance;
          it.remove();
          q.add(unvisitedCity);
        }
      }
    } while (!q.isEmpty());
    
    return distances;
  }
  
  private static class Road implements Comparable<Road> {
    public final int cityId;
    public final int distance;
    
    public Road(final int cityId, final int distance){
      this.cityId = cityId;
      this.distance = distance;
    }
    
    public int compareTo(final Road b){
      return Integer.compare(this.distance, b.distance);
    }
  }
}
