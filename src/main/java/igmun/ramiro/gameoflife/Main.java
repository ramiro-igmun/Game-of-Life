package igmun.ramiro.gameoflife;

import igmun.ramiro.gameoflife.model.Board;
import igmun.ramiro.gameoflife.controller.Controller;
import igmun.ramiro.gameoflife.view.GameWindow;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    
    Board board = new Board(100);
    Controller controller = new Controller(board);
    GameWindow window = new GameWindow(board, controller);
    controller.setWindow(window);
    //The GUI elements are started in the Event Dispatch Thread EDT
    SwingUtilities.invokeLater(window::startGUI);
  }
}
