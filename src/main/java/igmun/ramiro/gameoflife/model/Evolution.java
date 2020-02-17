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



    for (int row = 0; row <= size - 1; row++) {
      for (int column = 0; column <= size - 1; column++) {
        int neighbors = getNumberOfNeighbors(row, column, size, boardState);
        if (neighbors < 2 || neighbors > 3) {
          newBoardState[row][column] = false;
        } else if (neighbors == 3) {
          newBoardState[row][column] = true;
          aliveNumber++;
        } else {
          newBoardState[row][column] = boardState[row][column];
          aliveNumber = boardState[row][column] ? aliveNumber + 1 : aliveNumber;
        }
      }
    }
    board.setBoardState(newBoardState);
    board.setAliveNumber(aliveNumber);
    board.advanceGeneration();
  }

  /*
  * This method returns the number of living neighbors for each cell in the board.
  * It iterates through the sub-matrix of the eight neighbors around the given cell
  */
  private int getNumberOfNeighbors(int row, int column, int size, Boolean[][] boardState) {
    int numberOfNeighbors = 0;
    int correctedRow;
    int correctedColumn;
    for (int submatrixRow = row - 1; submatrixRow <= row + 1; submatrixRow++) {
      for (int submatrixColumn = column - 1; submatrixColumn <= column + 1; submatrixColumn++) {
        correctedRow = submatrixRow;
        correctedColumn = submatrixColumn;
        if (isOutOfRange(size, submatrixRow)) {
          correctedRow = submatrixRow < 0 ? size - 1 : 0;
        }

        if (isOutOfRange(size, submatrixColumn)) {
          correctedColumn = submatrixColumn < 0 ? size - 1 : 0;
        }

        if (boardState[correctedRow][correctedColumn] && !(correctedRow == row && correctedColumn == column)) {
          numberOfNeighbors++;
        }
      }
    }
    return numberOfNeighbors;
  }

  private boolean isOutOfRange(int size, int index) {
    return index < 0 || index > size - 1;
  }

}
