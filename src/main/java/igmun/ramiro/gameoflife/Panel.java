
package igmun.ramiro.gameoflife;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/*
This is the class in charge of drawing the game board in the game window
*/
public class Panel extends JPanel {

  private Board board;
  private int size;
  private int cellSize;

  public Panel(Board board) {
    this.board = board;
    this.size = board.getBoardSize();
    this.cellSize = 5;
    super.setPreferredSize(new Dimension(size * cellSize, size * cellSize));
  }
  
  public void resetSize(){
    this.size = board.getBoardSize();
    setPreferredSize(new Dimension(size * cellSize, size * cellSize));
  }
  

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    /*
    Iterates though the board and paints a fill black rectangle if true and a 
    normal rectangle if false
    */
    Boolean[][] boardState = board.getBoardState();
      for (int j = 0; j < boardState.length; j++) {
        for (int k = 0; k < boardState.length; k++) {
          if (boardState[j][k]) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(k*cellSize, j*cellSize, cellSize, cellSize);
          }else{
            g.setColor(Color.LIGHT_GRAY);
            g.drawRect(k*cellSize, j*cellSize, cellSize, cellSize);
        }
      }
    }
  }
}
