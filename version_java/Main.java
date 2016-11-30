import java.util.Scanner;

public class Main {
	public static boolean isActiveGame(char [][]board){
		//TODO
		return true;
	}

	public static int whoWonTheGame(char [][]board){
		//TODO
		return 0;
	}
	
	public static boolean hasFreeSpace(char [][]board){
		for(int i = 0;i<board[0].length;i++){
			for(int j = 0;j<board[1].length;j++){
				if(board[i][j] == '_'){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean isWin(char [][]board, final char PLAYER_ONE, final char PLAYER_TWO, final char[][][] WIN_POSITIONS){
		for(int i = 0;i<board[0].length;i++){
			for(int j = 0;j<board[1].length;j++){
				//TODO
			}
		}
		return true;
	}
	
	public static boolean isDraw(char [][]board, final char PLAYER_ONE, final char PLAYER_TWO, final char[][][] WIN_POSITIONS){
		return !isWin(board, PLAYER_ONE, PLAYER_TWO, WIN_POSITIONS) && !hasFreeSpace(board);
	}
	
	public static boolean canPlaceThere(char [][]board, byte posX, byte posY,final byte BOARD_SIZE, final char PLAYER_ONE, final char PLAYER_TWO){
		return board[posX][posY] != PLAYER_ONE && board[posX][posY] != PLAYER_TWO && (posX >= 0 && posX < BOARD_SIZE) && (posY >= 0 && posY < BOARD_SIZE);
	}

	public static void printBoard(char [][]board, final byte BOARD_SIZE){
		for (int i = 0; i < BOARD_SIZE; i++){
			for (int j = 0; j < BOARD_SIZE; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			char board[][] = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } }; // Initialize the board 3x3
			final int [][][]WIN_POSITIONS = {{{0,0},{0,1},{0,2}},
											{{1,0},{1,1},{1,2}},
											{{2,0},{2,1},{2,2}},
											{{0,0},{1,0},{2,0}},
											{{0,1},{1,1},{2,1}},
											{{0,2},{1,2},{2,2}},
											{{0,0},{1,1},{2,2}},
											{{0,2},{1,1},{2,0}}};
			
			byte posX = 0, posY = 0;  // Positions to put symbol to
			
			final byte BOARD_SIZE = 3; //Initialize board size
			final char PLAYER_ONE = 'X'; //Player one symbol
			final char PLAYER_TWO = 'O'; //Player two symbol
			final byte PLAYER_ONE_WON = 1;
			final byte PLAYER_TWO_WON = 2;
			
			boolean activeGame = true;
			boolean playerOneMove = true;
			boolean playerTwoMove = false;
			
			printBoard(board, BOARD_SIZE);
			
			//main game loop
			while (activeGame){
				if (playerOneMove){
					System.out.println("Player one's turn!");
					do{
						System.out.println("Please enter position to put " + PLAYER_ONE + " sign!");
						posX = input.nextByte();
						posY = input.nextByte();
					}while (!canPlaceThere(board, posX, posY,BOARD_SIZE,PLAYER_ONE,PLAYER_TWO));
					board[posX][posY] = PLAYER_ONE;
				}
				if (playerTwoMove){
					System.out.println("Player two's turn!");
					do{
						System.out.println("Please enter position to put " + PLAYER_TWO + " sign!");
						posX = input.nextByte();
						posY = input.nextByte();
					}while (!canPlaceThere(board, posX, posY,BOARD_SIZE,PLAYER_ONE,PLAYER_TWO));
					board[posX][posY] = PLAYER_TWO;
				}
				
				printBoard(board, BOARD_SIZE);
				activeGame = isActiveGame(board);
				if (!activeGame){
					if (whoWonTheGame(board) == PLAYER_ONE_WON){
						System.out.println("Player one won the game..!");
					}
					else{
						System.out.println("Player two won the game..!");
					}
				}
				if (playerOneMove){
					playerOneMove = false;
					playerTwoMove = true;
					continue;
				}
				if (playerTwoMove){
					playerTwoMove = false;
					playerOneMove = true;
			}
		}
	}

}
