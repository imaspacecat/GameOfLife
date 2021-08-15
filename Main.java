
import java.util.Scanner;
class Main {
  private static int widthX = 10;
  private static int heightY = 10; 

  public static void main(String[] args) throws InterruptedException {
    Board board = new Board(widthX, heightY);
    seedBoard(board);
    while(true){
      board.printBoard();
      board.checkRules();
      
      Thread.sleep(500);






    }

    
    
    
    
  }

  public static void seedBoard(Board board){
    //inputs the seed (initial cells)
    Scanner scanner = new Scanner(System.in);
    while(true){
      System.out.println("Enter a seed (x).");
      int inputX = scanner.nextInt();
      System.out.println("Enter a seed (y).");
      int inputY = scanner.nextInt();

      board.seed(inputX, inputY);

      // System.out.println("Seed again?");
      String inputS = scanner.nextLine();
      inputS.toLowerCase();
      if(inputS.contains("n")){
        break;
      } else{
        System.out.println("Enter another seed.");
      }
    

    
    }

   
  }
}