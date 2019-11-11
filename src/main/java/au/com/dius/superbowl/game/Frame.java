package au.com.dius.superbowl.game;

import au.com.dius.superbowl.exception.GameException;

public class Frame {

  private static final int MAX_NO_OF_PINS = 10;

  private final int rollOne;
  private final int rollTwo;

  public Frame(int rollOne, int rollTwo) throws GameException {
    if (rollOne + rollTwo > MAX_NO_OF_PINS) {
      throw new GameException("Max no. of pins cannot exceed 10: " + rollOne + " + " + rollTwo);
    }
    this.rollOne = rollOne;
    this.rollTwo = rollTwo;
  }

  int rollOne() {
    return this.rollOne;
  }

  int rollTwo() {
    return this.rollTwo;
  }

  int score() {
    return this.rollOne + this.rollTwo;
  }

  public boolean isSpare() {
    return !this.isStrike() && (this.rollOne + this.rollTwo) == MAX_NO_OF_PINS;
  }

  public boolean isStrike() {
    return this.rollOne == MAX_NO_OF_PINS;
  }
}
