package au.com.dius.superbowl.game;

import au.com.dius.superbowl.exception.GameException;

public interface Game {

  void roll(int pins) throws GameException;

  int score();
}
