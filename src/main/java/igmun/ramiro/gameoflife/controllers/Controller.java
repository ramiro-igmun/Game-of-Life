package igmun.ramiro.gameoflife.controllers;

import igmun.ramiro.gameoflife.Generation;
import igmun.ramiro.gameoflife.boards.Board;
import igmun.ramiro.gameoflife.windows.GameWindow;
import lombok.Data;

import javax.swing.*;

@Data
public class Controller {

    private GameWindow window;
    private Board board;
    private int generationsNumber;

    public Controller(Board board) {
        this.board = board;
    }

    private void setInitialParameters() {

        generationsNumber = window.getGenerations();
        board.setBoardSize(window.getSize());
        board.setInitialBoardState(System.currentTimeMillis());
    }

    /*
    This method contains the program flow
    */
    public void start() {
        Generation generation = new Generation();

        setInitialParameters();

        for (int i = 0; i < generationsNumber; i++) {
            generation.evolve(board);
            //We queue the View update in the Event Dispatcher Thread.
            SwingUtilities.invokeLater(() -> window.updateState());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Do anything like user logger
            }
        }

    }

}
