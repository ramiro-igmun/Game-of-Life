package igmun.ramiro.gameoflife.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Board {
  private Boolean[][] boardState;
  private int boardSize;
  private int generationsPassed;
  private int aliveNumber;

  public Board(int boardSize) {
    setBoardSize(boardSize);
    setInitialBoardState(System.currentTimeMillis());
  }
  
  final public void setBoardSize(int boardSize) {
    this.boardSize = boardSize;
    boardState = new Boolean[boardSize][boardSize];
  }

  final public void setInitialBoardState(long seed) {
    Random random = new Random();
    random.setSeed(seed);

    for (int x = 0; x < boardSize; x++) {
      for (int y = 0; y < boardSize; y++) {
        boardState[x][y] = random.nextBoolean();
        if (boardState[x][y]){
          aliveNumber++;
        }
      }
    }
  }

  public void advanceGeneration() {
    generationsPassed++;
  }

}
