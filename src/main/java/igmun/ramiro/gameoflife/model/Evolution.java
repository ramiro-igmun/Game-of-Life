package igmun.ramiro.gameoflife.model;

public class Evolution {

  /*
  This is the main algorithm. It takes the current board state and iterates
  through all the cells checking its neighbor cells, to determine if each cell
  should be alive or dead in the next generation
   */
  public void evolve(Board board) {
    int size = board.getBoardSize();
    int aliveNumber = 0;

    Boolean[][] boardState = board.getBoardState();
    Boolean[][] newBoardState = new Boolean[size][size];

    for (int i = 0; i <= size - 1; i++) {
      for (int j = 0; j <= size - 1; j++) {
        int neighbors = getNumberOfNeighbors(i, j, size, boardState);
        if (neighbors < 2 || neighbors > 3) {
          newBoardState[i][j] = false;
        } else if (neighbors == 3) {
          newBoardState[i][j] = true;
          aliveNumber++;
        } else {
          newBoardState[i][j] = boardState[i][j];
          aliveNumber = boardState[i][j] ? aliveNumber + 1 : aliveNumber;
        }
      }
    }
    board.setBoardState(newBoardState);
    board.setAliveNumber(aliveNumber);
    board.advanceGeneration();
  }

  /*
  This method returns the number of living neighbors for each cell in the board.
  It iterates through the sub-matrix of the eight neighbors around the given cell
   */
  private int getNumberOfNeighbors(int i, int j, int size, Boolean[][] boardState) {
    // TODO Refactor to use words identifiers
    int numberOfNeighbors = 0;
    int x;
    int y;
    for (int k = i - 1; k <= i + 1; k++) {
      for (int m = j - 1; m <= j + 1; m++) {
        x = k;
        y = m;
        if (k < 0 || k > size - 1) {
          x = k < 0 ? size - 1 : 0;
        }

        if (m < 0 || m > size - 1) {
          y = m < 0 ? size - 1 : 0;
        }

        if (boardState[x][y] && !(x == i && y == j)) {
          numberOfNeighbors++;
        }
      }
    }
    return numberOfNeighbors;
  }

}
