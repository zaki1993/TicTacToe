#include <iostream>

using std::cout;
using std::endl;
using std::cin;

#define BOARD_SIZE 3
#define PLAYER_ONE 'X'
#define PLAYER_TWO 'O'
#define PLAYER_ONE_WON 1
#define PLAYER_TWO_WON 2

bool isActiveGame(char board[BOARD_SIZE][BOARD_SIZE]){
	//TODO
	return true;
}

int whoWonTheGame(char board[BOARD_SIZE][BOARD_SIZE]){
	//TODO
	return 0;
}

bool canPlaceThere(char board[BOARD_SIZE][BOARD_SIZE], unsigned short posX, unsigned short posY){
	return board[posX][posY] != PLAYER_ONE && board[posX][posY] != PLAYER_TWO && (posX >= 0 && posX < BOARD_SIZE) && (posY >= 0 && posY < BOARD_SIZE);
}

void printBoard(char board[BOARD_SIZE][BOARD_SIZE]){
	for (int i = 0; i < BOARD_SIZE; i++){
		for (int j = 0; j < BOARD_SIZE; j++){
			cout << board[i][j];
		}
		cout << endl;
	}
}
int main(){
	char board[BOARD_SIZE][BOARD_SIZE] = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } }; // Initialize the board 3x3
	
	const int[][][] DRAW_POSITIONS = {}; //TODO
	const int[][][] WIN_POSITIONS = {}; //TODO
	
	bool activeGame = true;
	unsigned short posX = 0, posY = 0;  // Positions to put symbol to
	bool playerOneMove = true;
	bool playerTwoMove = false;
	
	printBoard(board);
	
	while (activeGame){
		if (playerOneMove){
			cout << "Player one's turn!" << endl;
			do{
				cout << "Please enter position to put " << PLAYER_ONE << " sign!" << endl;
				cin >> posX >> posY;
			} while (!canPlaceThere(board, posX, posY));
			board[posX][posY] = PLAYER_ONE;
		}
		if (playerTwoMove){
			cout << "Player two's turn!" << endl;
			do{
				cout << "Please enter position to put " << PLAYER_TWO << " sign!" << endl;
				cin >> posX >> posY;
			} while (!canPlaceThere(board, posX, posY));
			board[posX][posY] = PLAYER_TWO;
		}
		system("cls"); //clearing the screen
		printBoard(board);
		activeGame = isActiveGame(board);
		if (!activeGame){
			if (whoWonTheGame(board) == PLAYER_ONE_WON){
				cout << "Player one won the game..!" << endl;
			}
			else{
				cout << "Player two won the game..!" << endl;
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
	return 0;
}
