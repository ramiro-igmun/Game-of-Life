package igmun.ramiro.gameoflife.boards;

import lombok.Data;

import java.util.Random;

@Data
public class Board {
  private Boolean[][] board;
  private int boardSize;
  private int generationsPassed;
  private int aliveNumber;

  public Board() {
    setBoardSize(100);
    setInitialBoardState(System.currentTimeMillis());
  }
  
  final public void setBoardSize(int boardSize) {
    this.boardSize = boardSize;
    board = new Boolean[boardSize][boardSize];
  }

  final public void setInitialBoardState(long seed) {
    Random random = new Random();
    random.setSeed(seed);

    for (int x = 0; x < boardSize; x++) {
      for (int y = 0; y < boardSize; y++) {
        board[x][y] = random.nextBoolean();
        if (board[x][y]){
          aliveNumber++;
        }
      }
    }
  }

  public void setAliveNumber(int aliveNumber) {
    this.aliveNumber = aliveNumber;
  }

  public void setBoardState(Boolean[][] boardState) {
    board = boardState;
  }

  public Boolean[][] getBoardState() {
    return board;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public void advanceGeneration() {
    generationsPassed++;
  }

  public int getGenerationsPassed() {
    return generationsPassed;
  }

  public int getAliveNumber() {
    return aliveNumber;
  }

  public void setGenerationNumber(int generationNumber) {
    this.generationsPassed = generationNumber;
  }
    
}
