public class QueenBoard{
  public static void main(String[]args){
    QueenBoard test = new QueenBoard(4);
    test.solve();
    System.out.println(test);
  }

  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      board[r][c] = -1;
      for (int idx = 1; idx < board.length; idx ++){
        if (r + idx < board.length) board[r + idx][c] ++;
        if (r - idx >= 0) board[r - idx][c] ++;
        if (c + idx < board[0].length) board[r][c + idx] ++;
        if (c - idx >= 0) board[r][c - idx] ++;
        if (r + idx < board.length && c + idx < board[0].length) board[r + idx][c + idx] ++;
        if (r + idx < board.length && c - idx >= 0) board[r + idx][c - idx] ++;
        if (c + idx < board.length && r - idx >= 0) board[r - idx][c + idx] ++;
        if (r - idx >= 0 && c - idx >= 0) board[r - idx][c - idx] ++;
      }
      return true;
    }
    return false;
  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] == -1){
      board[r][c] = 0;
      for (int idx = 1; idx < board.length; idx ++){
        if (r + idx < board.length) board[r + idx][c] --;
        if (r - idx >= 0) board[r - idx][c] --;
        if (c + idx < board[0].length) board[r][c + idx] --;
        if (c - idx >= 0) board[r][c - idx] --;
        if (r + idx < board.length && c + idx < board[0].length) board[r + idx][c + idx] --;
        if (r + idx < board.length && c - idx >= 0) board[r + idx][c - idx] --;
        if (c + idx < board.length && r - idx >= 0) board[r - idx][c + idx] --;
        if (r - idx >= 0 && c - idx >= 0) board[r - idx][c - idx] --;
      }
      return true;
    }
    return false;
  }

  public boolean solve() {return solveHelper(0, 0);}


  //rowLQA and colLQA are the row and columns of the last queen added.
  //start row is where the for loop will start so that it doesn't get stuck
  //in endless recursion.
  private boolean solveHelper(int currentCol, int startRow){
    if (currentCol == board[0].length) return true;
    else if (currentCol < 0) return false;
    else {
      //boolean added = false;
      for (int idx = startRow; idx < board.length; idx ++){
        if (addQueen(idx, currentCol)) return solveHelper(currentCol + 1, 0);
      }
      if (currentCol == 0) return false;
      int start = 0;
      for (int idx = 0; idx < board.length; idx ++){
        if (board[idx][currentCol - 1] == -1){
          removeQueen(idx, currentCol - 1);
          start = idx + 1;
        }
      }
      return solveHelper(currentCol - 1, start);
    }
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

  public void clearBoard(){
    board = new int[board.length][board[0].length];
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
