package au.com.dius.superbowl.game;

public class GameFactory {
  public static Game newBowlingGame() {
    return new GameImpl();
  }
}
