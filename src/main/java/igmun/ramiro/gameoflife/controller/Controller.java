package igmun.ramiro.gameoflife.controller;

import igmun.ramiro.gameoflife.model.Evolution;
import igmun.ramiro.gameoflife.model.Board;
import igmun.ramiro.gameoflife.view.GameWindow;

import javax.swing.SwingUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

  private GameWindow window;
  private Board board;
  private int generationsNumber;

  public Controller(Board board) {
    this.board = board;
  }

  public void setWindow(GameWindow window){
    this.window = window;
  }

  private void setInitialParameters() {

    generationsNumber = window.getGenerations();
    board.setBoardSize(window.getSize());
    board.setInitialBoardState(System.currentTimeMillis());
  }


   //This method contains the program flow
  public void start() {
    Evolution evolution = new Evolution();

    setInitialParameters();

    for (int i = 0; i < generationsNumber; i++) {
      evolution.evolve(board);
      //We queue the View update in the Event Dispatcher Thread.
      SwingUtilities.invokeLater(() -> window.updateState());
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        Logger.getLogger(Controller.class.getName()).log(Level.INFO,"Thread sleep interrupted");
      }
    }

  }

}
