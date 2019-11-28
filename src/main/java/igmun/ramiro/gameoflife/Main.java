package igmun.ramiro.gameoflife;

import igmun.ramiro.gameoflife.boards.Board;
import igmun.ramiro.gameoflife.controllers.Controller;
import igmun.ramiro.gameoflife.windows.GameWindow;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {
    
    Board board = new Board();
    Controller controller = new Controller(board);
    GameWindow window = new GameWindow(board, controller);
    controller.setWindow(window);
    //The GUI elements are started in the Event Dispatch Thread EDT
    SwingUtilities.invokeLater(window::startGUI);
  }
}
