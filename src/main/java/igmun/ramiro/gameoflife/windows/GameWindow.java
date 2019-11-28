package igmun.ramiro.gameoflife.windows;

import igmun.ramiro.gameoflife.boards.Board;
import igmun.ramiro.gameoflife.panels.Panel;
import igmun.ramiro.gameoflife.controllers.Controller;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 *
 * @author Ramiro
 */
public class GameWindow {

  private Board board;
  private Controller controller;

  private JFrame window;
  private JLabel generationText;
  private JLabel aliveText;
  private JTextField size;
  private JTextField generations;

  private Panel panel;

  public GameWindow(Board board, Controller controller) {
    this.board = board;
    this.controller = controller;
  }

  public void startGUI() {

    window = new JFrame();

    window.setName("Game of Life");
    window.setTitle("Game Of Life");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS));

    createComponents();

    window.pack();
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }

  public void updateState() {
    generationText.setText("Generation #" + board.getGenerationsPassed());
    aliveText.setText("Alive: " + board.getAliveNumber());
    panel.repaint();
    panel.resetSize();
    window.pack();
  }

  private void createComponents() {
    createHeader();

    panel = new Panel(board);
    window.add(panel);

    JPanel menu = new JPanel();
    window.add(menu);

    menu.add(new JLabel("Size"));
    size = new JTextField("100", 3);
    menu.add(size);

    menu.add(new JLabel("Generations"));
    generations = new JTextField("500", 4);
    menu.add(generations);

    /*The action performed by the start button is starting a new thread on the background
    that executes the start of the class controller and the game logic*/
    JButton start = new JButton("Start");
    start.addActionListener((e) -> {
      new SwingWorker<>() {
        @Override
        protected Void doInBackground() throws Exception {
          board.setGenerationNumber(0);
          controller.start();
          return null;
        }
      }.execute();
    });
    menu.add(start);

  }

  public int getSize() {
    return Integer.parseInt(size.getText());
  }

  public int getGenerations() {
    return Integer.parseInt(generations.getText());
  }

  private void createHeader() {
    JPanel header = new JPanel();

    generationText = new JLabel("Generation #0");
    header.add(generationText);

    aliveText = new JLabel("Alive: " + board.getAliveNumber());
    header.add(aliveText);

    window.add(header);
  }

}
