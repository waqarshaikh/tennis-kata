import java.util.List;

public class TennisGame1 implements TennisGame {

  public static final String ALL = "All";
  public static final String DEUCE = "Deuce";
  public static final String ADVANTAGE = "Advantage";
  public static final String WIN = "Win";
  private final List<String> scores = List.of("Love", "Fifteen", "Thirty", "Forty");
  private final String playerOneName;
  private final String playerTwoName;
  private int playerOneScore = 0;
  private int playerTwoScore = 0;

  public TennisGame1(String playerOneName, String playerTwoName) {
    this.playerOneName = playerOneName;
    this.playerTwoName = playerTwoName;
  }

  public void wonPoint(String playerName) {
    if (playerOneName.equals(playerName)) {
      playerOneScore += 1;
    }
    if (playerTwoName.equals(playerName)) {
      playerTwoScore += 1;
    }
  }

  public String getScore() {
    if (playerOneScore == playerTwoScore) {
      return getScoreForTie();
    } else if (playerOneScore >= 4 || playerTwoScore >= 4) {
      return getScoreAdvantageOrWin();
    } else {
      return getScoreForDefault();
    }
  }

  private String getScoreForDefault() {
    return scores.get(playerOneScore) + "-" + scores.get(playerTwoScore);
  }

  private String getScoreAdvantageOrWin() {
    int difference = playerOneScore - playerTwoScore;
    if (difference == 1) {
      return ADVANTAGE + " " + playerOneName;
    } else if (difference == -1) {
      return ADVANTAGE + " " + playerTwoName;
    } else if (difference >= 2) {
      return WIN + " for " + playerOneName;
    } else {
      return WIN + " for " + playerTwoName;
    }
  }

  private String getScoreForTie() {
    return playerOneScore <= 2 ? scores.get(playerTwoScore) + "-" + ALL : DEUCE;
  }
}