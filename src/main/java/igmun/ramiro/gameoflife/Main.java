package igmun.ramiro.gameoflife;

import javax.swing.SwingUtilities;

public class Main {

  public static void main(String[] args) {

    /*
    We create the main components of the MVC pattern and their dependencies. 
    The Model is composed by the class Board, which represents the state of the 
    "universe" and the class Generations, which contains the main evolving 
    algorithm in a static method.
    The View is represented by the GameWindow class, which contains all the 
    swing elements.
    The Controller is represented by the class Controller, which controlls
    the GameWindow and the Model(Board-Generations)
    */
    
    Board board = new Board();
    Controller controller = new Controller(board);
    GameWindow window = new GameWindow(board, controller);
    controller.setWindow(window);
    //The GUI elements are started in the Event Dispatch Thread EDT
    SwingUtilities.invokeLater(() -> window.startGUI());
  }
}
