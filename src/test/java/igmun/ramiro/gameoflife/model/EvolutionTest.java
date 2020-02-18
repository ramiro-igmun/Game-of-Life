package igmun.ramiro.gameoflife.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvolutionTest {

  private Board board;
  private Evolution evolution;

  @BeforeEach
  void setup() {
    board = new Board(3);
    evolution = new Evolution();
  }

  @Test
  void givenAStaticBoardStateThenStateDoesNotChange() {
    Boolean[][] initialBoardState = {{false,true,true},{false,true,true},{false,false,false}};
    board.setBoardState(initialBoardState);
    Boolean[][] expectedBoardState = {{false,true,true},{false,true,true},{false,false,false}};
    evolution.evolve(board);
    assertArrayEquals(expectedBoardState,board.getBoardState());
  }

  @Test
  void givenADynamicBoardStateThenAppliesDeathRuleCorrectly() {
    Boolean[][] initialBoardState = {{true,false,true},{false,true,false},{true,false,true}};
    board.setBoardState(initialBoardState);
    Boolean[][] expectedBoardState = {{false,false,false},{false,false,false},{false,false,false}};
    evolution.evolve(board);
    assertArrayEquals(expectedBoardState,board.getBoardState());
  }

  @Test
  void givenADynamicBoardStateThenAppliesReviveRuleCorrectly() {
    Boolean[][] initialBoardState = {{false,true,false},{true,false,false},{false,true,false}};
    board.setBoardState(initialBoardState);
    Boolean[][] expectedBoardState = {{true,true,true},{true,true,true},{true,true,true}};
    evolution.evolve(board);
    assertArrayEquals(expectedBoardState,board.getBoardState());
  }
}