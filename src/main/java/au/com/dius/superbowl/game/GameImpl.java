package au.com.dius.superbowl.game;

import au.com.dius.superbowl.exception.GameException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class GameImpl implements Game {

  private static final int DEFAULT_FRAMES = 10;
  private static final int MAX_NO_OF_PINS = 10;

  private final List<Frame> frames = new ArrayList<>(DEFAULT_FRAMES + 1);
  private int pinsRollOne = 0;
  private boolean isRollOne = true;

  @Override
  public void roll(int noOfPins) throws GameException {
    doValidations();
    rollNow(noOfPins);
  }

  @Override
  public int score() {
    if (frames.stream().allMatch(Frame::isStrike)) {
      return 300;
    }

    return IntStream.range(0, frames.size()).map(this::scoreForFrame).reduce(0, Integer::sum);
  }

  private void doValidations() throws GameException {
    if (frames.size() < DEFAULT_FRAMES) {
      return;
    }
    if (frames.size() == DEFAULT_FRAMES && frames.get(DEFAULT_FRAMES - 1).isSpare() && isRollOne) {
      return;
    }
    if (frames.size() == DEFAULT_FRAMES && frames.get(DEFAULT_FRAMES - 1).isStrike()) {
      return;
    }
    throw new GameException("No rolls beyond 10 frame");
  }

  private void rollNow(int noOfPins) throws GameException {
    if (isRollOne) {
      rollOne(noOfPins);
    } else {
      if (frames.size() == DEFAULT_FRAMES && frames.get(DEFAULT_FRAMES - 1).isSpare()) {
        rollTwo(0);
      } else {
        rollTwo(noOfPins);
      }
    }
  }

  private void rollOne(int noOfPins) throws GameException {
    pinsRollOne = noOfPins;
    isRollOne = false;
    if (noOfPins == MAX_NO_OF_PINS) {
      rollTwo(0);
    }
  }

  private void rollTwo(int noOfPins) throws GameException {
    frames.add(new Frame(pinsRollOne, noOfPins));
    isRollOne = true;
    pinsRollOne = 0;
  }

  private int scoreForFrame(int i) {
    int result = frames.get(i).score();
    if (i == 0) {
      return result;
    }
    if (frames.get(i - 1).isSpare()) {
      result += frames.get(i).rollOne();
    }
    if (frames.get(i - 1).isStrike()) {
      result += frames.get(i).score();
    }
    return result;
  }
}
