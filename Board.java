

class Board{
private int widthX, heightY;
private byte[][] board;

  public Board(int widthX, int heightY){

    this.widthX = widthX;
    this.heightY = heightY;

    board = new byte[widthX][heightY];

    fillBlankBoard();

  }


 

  public void fillBlankBoard(){
    //fills the array with blank characters

    for(int a = 0; a < board.length; a++){
      for(int b = 0; b < board.length; b++){
        board[a][b] = 0;
      }  
    }


  }

  public void seed(int x, int y){
    board[x][y] = 1;

  }

  public void printBoard(){
  //prints the array
    for(int a = 0; a < board.length; a++){
      for(int b = 0; b < board.length; b++){
        System.out.print(board[a][b]);
      }  
      System.out.println();
    }



  }

  public void checkRules(){
    //calculates which cells need to live and which need to die
    /**
    1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    2. Any live cell with two or three live neighbours lives on to the next generation.
    3. Any live cell with more than three live neighbours dies, as if by overpopulation.
    4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    1. Any live cell with two or three live neighbours survives.
    2. Any dead cell with three live neighbours becomes a live cell.
    3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
    **/

    
    for(int a = 0; a < board.length; a++){
      for(int b = 0; b < board.length; b++){

        //add all the neighbor's values together
        int liveCount = board[a-1][b-1] + board[a][b-1]
            + board[a+1][b-1] + board[a-1][b] + board[a+1][b] + board[a-1][b+1]
            + board[a][b+1] + board[a+1][b+1];

        if(board[a][b] == 1){
          if(liveCount >= 2){
            //stays alive
            continue;
          } else{
            //dies
            board[a][b] = 0;
          }  
        }

        if(board[a][b] == 0){
          if(liveCount >=3){
            //lives
            board[a][b] = 1;
          } else{
            //stays dead
            continue;
          }
        }
      }  
    }








  }


  




}
