import java.util.List;

public class TennisGame2 implements TennisGame {

  public static final String ADVANTAGE = "Advantage";
  public static final String WIN = "Win";
  public static final String DEUCE = "Deuce";
  public static final String ALL = "All";
  private final String playerOneName;
  private final String playerTwoName;
  private final List<String> scores = List.of("Love", "Fifteen", "Thirty", "Forty");
  private int playerOnePoint = 0;
  private int playerTwoPoint = 0;
  private String playerOneResult = "";
  private String playerTwoResult = "";

  public TennisGame2(String playerOneName, String playerTwoName) {
    this.playerOneName = playerOneName;
    this.playerTwoName = playerTwoName;
  }

  public String getScore() {
    String score = getScoreForTieOrDeuce();
    score = getScoreForDefault(score);
    score = getScoreForAdvantageOrWin(score);
    return score;
  }

  private String getScoreForTieOrDeuce() {
    if (playerOnePoint == playerTwoPoint && playerOnePoint <= 2) {
      return scores.get(playerOnePoint) + "-" + ALL;
    } else {
      return DEUCE;
    }
  }

  private String getScoreForDefault(String score) {
    if (playerOnePoint > 0 && playerTwoPoint == 0) {
      if (playerOnePoint <= 2) {
        playerOneResult = scores.get(playerOnePoint);
      }
      playerTwoResult = scores.get(playerTwoPoint);

      score = playerOneResult + "-" + playerTwoResult;
    }
    if (playerTwoPoint > 0 && playerOnePoint == 0) {
      if (playerTwoPoint <= 2) {
        playerTwoResult = scores.get(playerTwoPoint);
      }
      playerOneResult = scores.get(playerOnePoint);

      score = playerOneResult + "-" + playerTwoResult;
    }

    if (playerOnePoint > playerTwoPoint && playerOnePoint < 4) {
      playerOneResult = scores.get(playerOnePoint);
      playerTwoResult = scores.get(playerTwoPoint);

      score = playerOneResult + "-" + playerTwoResult;
    }
    if (playerTwoPoint > playerOnePoint && playerTwoPoint < 4) {
      playerOneResult = scores.get(playerOnePoint);
      playerTwoResult = scores.get(playerTwoPoint);

      score = playerOneResult + "-" + playerTwoResult;
    }
    return score;
  }

  private String getScoreForAdvantageOrWin(String score) {
    if (playerOnePoint > playerTwoPoint && playerTwoPoint >= 3) {
      score = ADVANTAGE + " " + playerOneName;
    }
    if (playerTwoPoint > playerOnePoint && playerOnePoint >= 3) {
      score = ADVANTAGE + " " + playerTwoName;
    }

    if (playerOnePoint >= 4 && playerTwoPoint >= 0 && (playerOnePoint - playerTwoPoint) >= 2) {
      score = WIN + " for " + playerOneName;
    }
    if (playerTwoPoint >= 4 && playerOnePoint >= 0 && (playerTwoPoint - playerOnePoint) >= 2) {
      score = WIN + " for " + playerTwoName;
    }
    return score;
  }

  public void wonPoint(String player) {
    if (player.equals(playerOneName)) {
      playerOnePoint++;
    } else {
      playerTwoPoint++;
    }
  }
}