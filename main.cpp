#include <iostream>

using std::cout;
using std::endl;
using std::cin;

#define BOARD_SIZE 3
#define PLAYER_ONE 'X'
#define PLAYER_TWO 'O'
#define PLAYER_ONE_MOVE 1
#define PLAYER_TWO_MOVE 2

bool isActiveGame(char **board){
	//TODO
}

int whoWonTheGame(char **board){
	//TODO
}

int main(){
	char board[BOARD_SIZE][BOARD_SIZE] = { { '_', '_', '_' }, { '_', '_', '_' }, { '_', '_', '_' } }; // Initialize the board 3x3
	bool activeGame = true; 
	unsigned short currentPlayerTurn = PLAYER_ONE_MOVE; // Current player turn
	unsigned short posX = 0, posY = 0;  // Positions to put symbol to
	for (int i = 0; i < BOARD_SIZE; i++){
		for (int j = 0; j < BOARD_SIZE; j++){
			cout << board[i][j];
		}
		cout << endl;
	}

	while (activeGame){
		//TODO
	}
	return 0;
}
