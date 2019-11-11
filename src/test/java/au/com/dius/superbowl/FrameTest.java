package au.com.dius.superbowl;

import au.com.dius.superbowl.exception.GameException;
import au.com.dius.superbowl.game.Frame;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameTest {

  @Test
  public void roll1And1ShouldNotBeSpareOrStrike() throws Exception {
    Frame frame = new Frame(1, 1);
    assertFalse(frame.isSpare());
    assertFalse(frame.isStrike());
  }

  @Test
  public void roll2And8ShouldResultSpare() throws Exception {
    Frame frame = new Frame(4, 6);
    assertTrue(frame.isSpare());
    assertFalse(frame.isStrike());
  }

  @Test
  public void roll10And0ShouldResultStrike() throws Exception {
    Frame frame = new Frame(10, 0);
    assertFalse(frame.isSpare());
    assertTrue(frame.isStrike());
  }

  @Test(expected = GameException.class)
  public void rollingInvalidNoOfPinsShouldThrowException() throws Exception {
    new Frame(10, 1);
  }
}
