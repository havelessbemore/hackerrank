//https://www.hackerrank.com/challenges/the-quickest-way-up
import java.io.*;
import java.util.*;

public class Solution {
  private final static byte MAX_ROLL = 6;
  private final static byte BOARD_LEN = 100;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    //Create board
    final byte[] board = new byte[BOARD_LEN];
    
    //For every test case
    for(byte T = Byte.parseByte(br.readLine()); T > 0; --T){

      //Initialize board
      for(byte i = 0; i < BOARD_LEN; ++i){
        board[i] = i;
      }

      //Get snakes
      for(byte N = Byte.parseByte(br.readLine()); N > 0; --N){
        final String[] line = br.readLine().split(" ");
        final byte S = (byte)(Byte.parseByte(line[0]) - 1);
        final byte E = (byte)(Byte.parseByte(line[1]) - 1);
        board[S] = E;
      }

      //Get ladders
      for(byte M = Byte.parseByte(br.readLine()); M > 0; --M){
        final String[] line = br.readLine().split(" ");
        final byte S = (byte)(Byte.parseByte(line[0]) - 1);
        final byte E = (byte)(Byte.parseByte(line[1]) - 1);
        board[S] = E;
      }


      //Solve and print output
      System.out.println(getMinMoves(board));
    }
  }

  private static byte getMinMoves(final byte[] board){

    //Initialize moves counting
    final byte[] moves = new byte[BOARD_LEN];
    for(byte i = 1; i < BOARD_LEN; moves[i++] = BOARD_LEN){}
    final Queue<Byte> q = new PriorityQueue<Byte>(new Comparator<Byte>(){
      @Override
      public int compare(Byte a, Byte b){
        return b.compareTo(a);
      }
    });

    //Go through board and find min moves
    q.add((byte)0);
    do{
      final byte square = q.poll();
      final byte numMoves = (byte)(moves[square] + 1);
      for(byte i = (byte)(square + 1), n = (byte)(Math.min(BOARD_LEN, i + MAX_ROLL)); i < n; ++i){
        final byte j = board[i];
        if(numMoves < moves[j]){
          moves[j] = numMoves;
          q.add(j);
        }
      }
    } while (!q.isEmpty());

    //Check if possible to reach max square
    final byte minMoves = moves[BOARD_LEN - 1];
    return (minMoves == BOARD_LEN) ? -1 : minMoves;
  }
}
