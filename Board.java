class Board{
private int widthX, heightY;
private byte[][] board;
private byte[][] board2;
private final char num2Char[];

  public Board(int widthX, int heightY){

    this.widthX = widthX;
    this.heightY = heightY;

    board = new byte[widthX][heightY];
    board2 = new byte[widthX][heightY];
    num2Char = new char[]{'-', 'o'};


    fillBlankBoard();

  }


  private void createBlinker(int x, int y)
  {
    board[x][y-1] = 1;
    board[x][y] = 1;
    board[x][y+1] = 1;
  }

  private void createGlider(int x, int y){
    board[y+1][x] = 1;
    board[y][x] = 1;
    board[y-1][x] = 1;
    board[y+1][x-1] = 1;
    board[y][x-2] = 1;
  }

  public void fillBlankBoard(){
    //fills the array with blank characters

    for(int a = 0; a < board.length; a++){
      for(int b = 0; b < board.length; b++){
        board[a][b] = 0;
      }  
    }

    // createBlinker(5, 6);
    createGlider(5,6);
  }

  public void seed(int x, int y){
    board[x][y] = 1;

  }

  public void printBoard(){
  //prints the array
    for(int a = 0; a < board.length; a++){
      for(int b = 0; b < board.length; b++){
        System.out.print(num2Char[board[a][b]]);
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
        
        int liveCount = 
            board[(a-1 + widthX) % widthX][(b-1 + heightY ) % heightY] + 
            board[a][(b-1 + heightY) % heightY] + 
            board[(a+1) % widthX][(b-1 + heightY) % heightY] + 
            board[(a-1 + widthX) % widthX][b] + 
            board[(a+1) % widthX][b] +
            board[(a-1 + widthX) % widthX][(b+1) % heightY] + 
            board[a][(b+1) % heightY] + 
            board[(a+1) % widthX][(b+1) % heightY];
        // System.out.println("coords: (" + a + ", " + b + ")");
        // System.out.println("liveCount = " + liveCount);
        board2[a][b] = board[a][b];

        if(board[a][b] == 1){
          if(!(liveCount == 2 || liveCount == 3)){
            //dies
            board2[a][b] = 0;
            // System.out.println("Cell " + a + " " + b + " dies");
            continue;

          }  
        }
        if(board[a][b] == 0){
          if(liveCount == 3){
            //lives
            board2[a][b] = 1;
            // System.out.println("Cell" + a + " " + b + "lives");
            continue;

          }
        }
      }  
    }






  byte tmp[][] = board2;
  board2 = board;
  board = tmp;

  }


  




}
