package cn.xpbootcamp.tennis;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

public class Score {

    private static final String SCORE_SPLITTER = "-";
    private static final String DEUCE = "Deuce";
    private static final String ALL = "All";
    private static final String ADVANTAGE = "Advantage ";
    private static final String WIN_FOR = "Win for ";

    private final Player player1;
    private final Player player2;
    private final Map<Integer, String> scoreMap;

    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        scoreMap = of(0, "Love",
                1, "Fifteen",
                2, "Thirty",
                3, "Forty");
    }

    public String getScore() {
        if (isStandOff()) {
            return getScoreWhenStandOff();
        }

        if (isAnyPlayerScoreOverThreePoint()) {
            return getScoreWhenScoreOverThreePoint();
        }

        return getNormalScore();
    }

    private boolean isStandOff() {
        return this.player1.getScore() == this.player2.getScore();
    }

    private String getScoreWhenStandOff() {
        if (this.player1.getScore() > 2) {
            return DEUCE;
        }
        return scoreMap.get(this.player1.getScore()) +
                SCORE_SPLITTER +
                ALL;
    }

    private boolean isAnyPlayerScoreOverThreePoint() {
        return this.player1.getScore() >= 4 || this.player2.getScore() >= 4;
    }

    private String getScoreWhenScoreOverThreePoint() {
        int absDifference = Math.abs(this.player1.getScore() - this.player2.getScore());
        String playerNameWithMoreScore = this.player1.getScore() > this.player2.getScore()
                ? this.player1.getName()
                : this.player2.getName();
        return absDifference == 1
                ? getAdvantageScore(playerNameWithMoreScore)
                : getWinForScore(playerNameWithMoreScore);
    }

    private String getAdvantageScore(String playerName) {
        return ADVANTAGE + playerName;
    }

    private String getWinForScore(String playerName) {
        return WIN_FOR + playerName;
    }

    private String getNormalScore() {
        return scoreMap.get(this.player1.getScore()) +
                SCORE_SPLITTER +
                scoreMap.get(this.player2.getScore());
    }

}
