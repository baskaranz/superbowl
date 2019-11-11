package au.com.dius.superbowl;

import au.com.dius.superbowl.exception.GameException;
import au.com.dius.superbowl.game.Game;
import au.com.dius.superbowl.game.GameImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingImplTest {
  private Game game;

  @Before
  public void setUp() {
    this.game = new GameImpl();
  }

  @Test
  public void roll4And4ShouldResult8() throws GameException {
    game.roll(4);
    game.roll(4);
    assertEquals(8, game.score());
  }

  @Test
  public void roll4And6And5And0Result20() throws Exception {
    game.roll(4);
    game.roll(6);
    game.roll(5);
    game.roll(0);
    assertEquals(20, game.score());
  }

  @Test
  public void roll10And5And4ShouldResult28() throws GameException {
    game.roll(10);
    game.roll(5);
    game.roll(4);
    assertEquals(28, game.score());
  }

  @Test
  public void roll10And10And5And4ShouldResult48() throws GameException {
    game.roll(10);
    game.roll(10);
    game.roll(5);
    game.roll(4);
    assertEquals(48, game.score());
  }

  @Test
  public void rolling10FramesShouldBeOk() throws Exception {
    this.rollPinsForGivenTimes(10, 1);
    assertEquals(10, game.score());
  }

  @Test(expected = GameException.class)
  public void rollingGreaterThan10FramesShouldThrowException() throws GameException {
    this.rollPinsForGivenTimes(21, 1);
  }

  @Test
  public void allStrikesShouldScore300() throws Exception {
    this.rollPinsForGivenTimes(10, 10);
    assertEquals(300, game.score());
  }

  private void rollPinsForGivenTimes(int times, int noOfPins) throws GameException {
    for (int i = 0; i < times; i++) {
      game.roll(noOfPins);
    }
  }
}
