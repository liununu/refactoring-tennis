package cn.xpbootcamp.tennis;

import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        findWinner(playerName).wonPoint();
    }

    public String getScore() {
        return new Score(player1, player2).getScore();
    }

    private Player findWinner(String playerName) {
        return isPlayer1WonPoint(playerName) ? player1 : player2;
    }

    private boolean isPlayer1WonPoint(String playerName) {
        return Objects.equals(playerName, this.player1.getName());
    }
}