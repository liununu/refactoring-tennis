package cn.xpbootcamp.tennis;

public class Score {
    private final Player player1;
    private final Player player2;

    public Score(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
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
        switch (this.player1.getScore()) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private boolean isAnyPlayerScoreOverThreePoint() {
        return this.player1.getScore() >= 4 || this.player2.getScore() >= 4;
    }

    private String getScoreWhenScoreOverThreePoint() {
        int minusResult = this.player1.getScore() - this.player2.getScore();
        if (minusResult == 1) {
            return "Advantage " + this.player1.getName();
        } else if (minusResult == -1) {
            return "Advantage " + this.player2.getName();
        } else if (minusResult >= 2) {
            return "Win for " + this.player1.getName();
        } else {
            return "Win for " + this.player2.getName();
        }
    }

    private String getNormalScore() {
        String score = "";
        switch (this.player1.getScore()) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }

        score += "-";

        switch (this.player2.getScore()) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }
        return score;
    }

}
