public class QueenBoard{
  public static void main(String[]args){
    QueenBoard q = new QueenBoard(10);
    q.addQueen(2, 2);
    System.out.println(q.TSHelper());
  }

  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      board[r][c] = -1;
      for (int idx = 0; idx < board.length; idx ++){
        if (r + idx < board.length) board[r + idx][c] ++;
        else if (c + idx < board[0].length) board[r][c + idx] ++;
      }
      return true;
    }
    return false;
  }

  //private boolean removeQueen(int r, int c){}

  public boolean solve(){
    return true;
  }

  //public int countSolutions(){}

  public String toString(){
    String output = "";
    for (int idx = 0; idx < board.length; idx ++){
      for (int idx2 = 0; idx2 < board[0].length; idx2 ++){
        if (board[idx][idx2] == -1) output += "Q ";
        else output += "_ ";
      }
      output += "\n";
    }
    return output.substring(0, output.length() - 1);
  }

  public String TSHelper(){
    String output = "";
    for (int idx = 0; idx < board.length; idx ++){
      for (int idx2 = 0; idx2 < board[0].length; idx2 ++){
        output += board[idx][idx2] + " ";
      }
      output += "\n";
    }
    return output.substring(0, output.length() - 1);
  }




}
