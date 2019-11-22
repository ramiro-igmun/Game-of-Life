package igmun.ramiro.gameoflife;

import javax.swing.SwingUtilities;

public class Controller {

  private Board board;
  private int generations;
  private GameWindow window;

  public Controller(Board board) {
  this.board = board;
  }

  private void setInitialParameters() {
    
    generations = window.getGenerations();
    board.setBoardSize(window.getSize());
    board.setInitialBoardState(System.currentTimeMillis());
  }

  /*
  This method contains the program flow
  */
  public void start() {

    setInitialParameters();

    for (int i = 0; i < generations; i++) {
      Generations.evolve(board);
      //We queue the View update in the Event Dispatcher Thread.
      SwingUtilities.invokeLater(() -> window.updateState());
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
      }
    }

  }

  public void setGenerations(int generations) {
    this.generations = generations;
  }
  
  public void setWindow(GameWindow window){
    this.window = window;
  }
}
