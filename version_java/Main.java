import java.util.Scanner;

public class Main {
	public static boolean isActiveGame(char [][]board, final char PLAYER, final char BOT, final int[][][] WIN_POSITIONS){
		return !isWinPlayer(board, PLAYER, WIN_POSITIONS) && !isWinBot(board, BOT, WIN_POSITIONS) && hasFreeSpace(board);
	}

	public static byte whoWonTheGame(char [][]board, final char PLAYER, final char BOT, final int[][][] WIN_POSITIONS){
		if(isWinPlayer(board, PLAYER, WIN_POSITIONS)){
			return 1;
		}
		if(isWinBot(board, BOT, WIN_POSITIONS)){
			return 2;
		}
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
	
	public static boolean isWinPlayer(char [][]board, final char PLAYER, final int[][][] WIN_POSITIONS){
		boolean hasWinner = false;
		for(int i = 0;i<WIN_POSITIONS.length;i++){
			hasWinner = true;
			for(int j = 0;j<WIN_POSITIONS[i].length;j++){
				if(board[WIN_POSITIONS[i][j][0]][WIN_POSITIONS[i][j][1]] == PLAYER){
					hasWinner = true;
				}
				else{
					hasWinner = false;
					break;
				}
			}
			if(hasWinner){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isWinBot(char [][]board, final char BOT, final int[][][] WIN_POSITIONS){
		boolean hasWinner = false;
		for(int i = 0;i<WIN_POSITIONS.length;i++){
			hasWinner = true;
			for(int j = 0;j<WIN_POSITIONS[i].length;j++){
				if(board[WIN_POSITIONS[i][j][0]][WIN_POSITIONS[i][j][1]] == BOT){
					hasWinner = true;
				}
				else{
					hasWinner = false;
					break;
				}
			}
			if(hasWinner){
				return true;
			}
		}
		return false;
	}

	public static void printBoard(char [][]board){
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[i].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void botMove(char [][]board, final char BOT, final int[][][]BOT_CHECK_WIN){
		boolean canWin = false;
		byte posX = 0, posY = 0;
		int index = 0;
		for(int i = 0;i<BOT_CHECK_WIN.length;i++){
			canWin = false;
			for (int j = 0; j < BOT_CHECK_WIN[i].length; j++) {
				if(board[BOT_CHECK_WIN[i][j][0]][BOT_CHECK_WIN[i][j][1]] == BOT){
					canWin = true;
					index = i;
				}
				else{
					break;
				}
			}
			if(canWin){
				if(index % 3 == 0){
					if(board[BOT_CHECK_WIN[index][1][0]][BOT_CHECK_WIN[index][1][1] + 1] != '_'){
						continue;
					}
					board[BOT_CHECK_WIN[index][1][0]][BOT_CHECK_WIN[index][1][1] + 1] = BOT;
					return;
				}
				if(index % 3 == 1){
					if(board[BOT_CHECK_WIN[index][1][0]][BOT_CHECK_WIN[index][1][1] - 2] != '_'){
						continue;
					}
					board[BOT_CHECK_WIN[index][1][0]][BOT_CHECK_WIN[index][1][1] - 2] = BOT;
					return;
				}
				if(index % 3 == 2){
					if(board[BOT_CHECK_WIN[index][1][0]][BOT_CHECK_WIN[index][1][1] - 1] != '_'){
						continue;
					}
					board[BOT_CHECK_WIN[index][1][0]][BOT_CHECK_WIN[index][1][1] - 1] = BOT;
					return;
				}
			}
		}
		
		do{
			posX = (byte)(Math.random()*(3-0) + 0);
			posY = (byte)(Math.random()*(3-0) + 0);
		}while(board[posX][posY] != '_');
		board[posX][posY] = BOT;
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
			
			final int [][][]BOT_CHECK_WIN ={{{0,0},{0,1}},
											{{0,1},{0,2}},
											{{0,0},{0,2}},
											{{1,0},{1,1}},
											{{1,1},{1,2}},
											{{1,0},{1,2}},
											{{2,0},{2,1}},
											{{2,1},{2,2}},
											{{2,0},{2,2}},
											{{0,0},{1,0}},
											{{1,0},{2,0}},
											{{0,0},{2,0}},
											{{0,1},{1,1}},
											{{1,1},{2,1}},
											{{0,1},{2,1}},
											{{0,2},{1,2}},
											{{1,2},{2,2}},
											{{0,2},{2,2}},
											{{0,0},{1,1}},
											{{1,1},{2,2}},
											{{0,0},{2,2}},
											{{0,2},{1,1}},
											{{1,1},{2,0}},
											{{0,2},{2,0}}};
			
			byte posX = 0, posY = 0;  // Positions to put symbol to
			
			final byte BOARD_SIZE = 3; //Initialize board size
			final char PLAYER = 'X'; //Player symbol
			final char BOT = 'O'; // Bot symbol
			
			final byte PLAYER_WON = 1; //Player win number
			final byte BOT_WON = 2; //Bot win number
			final byte DRAW = 0; //Draw number
			
			boolean activeGame = true;
			boolean playerMove = true;
			boolean botMove = false;
			
			printBoard(board);
			
			//main game loop
			while (activeGame){
				if (playerMove){
					System.out.println("Player one's turn!");
					do{
						System.out.println("Please enter position to put " + PLAYER + " sign!");
						posX = input.nextByte();
						posY = input.nextByte();
					}while ((posX<0 || posX>= BOARD_SIZE) || (posY<0 || posY>=BOARD_SIZE) || (board[posX][posY] != '_'));
					board[posX][posY] = PLAYER;
				}
				if (botMove){
					botMove(board, BOT, BOT_CHECK_WIN);
				}
				
				System.out.println();
				printBoard(board);
				activeGame = isActiveGame(board, PLAYER, BOT, WIN_POSITIONS);
				
				if (!activeGame){
					if (whoWonTheGame(board, PLAYER, BOT, WIN_POSITIONS) == PLAYER_WON){
						System.out.println("Player won the game..!");
					}
					else if(whoWonTheGame(board, PLAYER, BOT, WIN_POSITIONS) == BOT_WON){
						System.out.println("The bot won the game..!");
					}
					else if(whoWonTheGame(board, PLAYER, BOT, WIN_POSITIONS) == DRAW){
						System.out.println("It's draw");
					}
					continue;
				}
				
				if (playerMove){
					playerMove = false;
					botMove = true;
					continue;
				}
				if (botMove){
					botMove = false;
					playerMove = true;
			}
		}
	}

}
