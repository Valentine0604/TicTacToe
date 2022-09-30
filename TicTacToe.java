import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            char[][] board = {
              {'_','_','_'},
              {'_','_','_'},
              {'_','_','_'}
            };

            printBoard(board);

          for(int i=0; i<9; i++){
            if(i%2==0){
              System.out.println("Turn X:");
              int[] spot = askUser(board);
              board[spot[0]][spot[1]] = 'X';
            }
            else{
              System.out.println("Turn O:");
              int[] spot = askUser(board);
              board[spot[0]][spot[1]] = 'O';
              
            }
            printBoard(board);
            int counter = checkWin(board);

            if(counter==3){
              System.out.println("X wins!");
              break;
            }
            else if(counter==-3){
              System.out.println("O wins!");
              break;
            }
            else if(i==8){
              System.out.println("It's a tie!");
              break;
            }
          }

          scan.close();
        }


    /** Function name - printBoard()
     * @param board (char[][])
     * 
     * Inside the function:
     *   1. print a new line.
     *   2. print the board.
     *      • separate each row by two lines. 
     *      • each row precedes a tab of space
     *      • each character in the grid has one space from the other character
     */
    
    public static void printBoard(char[][] array){
        for(int i=0; i<array.length; i++){
            System.out.print("\t");
            for(int j=0; j<array[i].length; j++){
                 System.out.print(array[i][j] + " ");
             }
             System.out.print("\n\n");
        }

    } 

   /** Function name – askUser
     * @param board (char[][] board)
     * @return spot (int[])
     * 
     * Inside the function
     *   1. Asks the user: - pick a row and column number: 
     *   2. Check if the spot is taken. If so, let the user choose again.
     *   3. Return the row and column in an int[] array.
     * 
     */

    public static int[] askUser(char[][] array){
        System.out.print("Pick the row and column: ");
        int row = scan.nextInt();
        int column = scan.nextInt();

        while(array[row][column]!='_'){
          System.out.print("The spot is taken. Pick another row and column: ");
          row = scan.nextInt();
          column = scan.nextInt();
        }

        return new int[] {row, column};
    } 

    /** Function name - checkWin 
     * @param board (char[][])
     * @return count (int)
     * 
     * Inside the function:
     *   1. Make a count variable that starts at 0.
     *   2. Check every row for a straight X or straight O (Task 7).
     *   3. Check every column for a straight X or straight O (Task 8).
     *   4. Check the left diagonal for a straight X or straight O (Task 9).
     *   5. Check the right diagonal for a straight X or straight O (Task 10).
     */
  public static int checkWin(char[][] array){
    int counter = 0;
    for(int i=0; i<array.length; i++){
      for(int j=0; j<array[i].length; j++){
        if(array[i][j]=='X'){
          counter++;
        }
        else if(array[i][j]=='O'){
          counter--;
        }
      }
      if(counter==3 || counter==-3){
        return counter;
      }
      else{
        counter = 0;
      }
    }

    for(int i=0; i<3; i++){
        for(int j=0; j<array.length; j++){
          if(array[j][i]=='X'){
            counter++;
          }
          else if(array[j][i]=='O'){
            counter--;
          }
        }
        if(counter==3 || counter==-3){
          return counter;
        }
        else{
          counter = 0;
        }
    }

    for(int i=0; i<array.length; i++){
      if(array[i][i]=='X'){
        counter++;
      }
      else if(array[i][i]=='O'){
        counter--;
      }
    }
    if(counter==3 || counter==-3){
      return counter;
    }
    else{
      counter = 0;
    }

    for(int i=0; i<3; i++){
      int rowIndex = 2 - i;
      if(array[i][rowIndex]=='X'){
        counter++;
      }
      else if(array[i][rowIndex]=='O'){
        counter--;
      }
    }
    if(counter==3 || counter==-3){
      return counter;
    }
    else{
      counter = 0;
    }
    return counter;
  }

}
