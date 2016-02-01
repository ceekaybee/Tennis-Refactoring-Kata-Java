
public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getName())
            player1.wonPoint();
        else
            player2.wonPoint();
    }

    public String getScore() {
        if (scoresAreEqual()) {
            return scoreForTie();
        }
        else if (advantagePlayer1()) {
            return advantageScoreFor(player1);
        }
        else if(advantagePlayer2()) {
            return advantageScoreFor(player2);
        }
        else if(winForPlayer1()) {
            return winScoreFor(player1);
        }
        else if(winForPlayer2()) {
            return winScoreFor(player2);
        }
        else {
            return scoreForBothBelow4();
        }
    }

    private static String winScoreFor(Player player) {
        return "Win for " + player.getName();
    }

    private static String advantageScoreFor(Player player) {
        return "Advantage " + player.getName();
    }

    private String scoreForBothBelow4() {
        String score;
        score = nameFor(player1.getScore()) + "-" + nameFor(player2.getScore());
        return score;
    }

    private String scoreForTie() {
        String score;
        if(player1.getScore() > 2) {
            score = "Deuce";
        }
        else {
            score = nameFor(player1.getScore()) + "-All";
        }
        return score;
    }

    private boolean winForPlayer1() {
        return atLeastOneScoreAbove4() && player1.getScore() - player2.getScore() >= 2;
    }

    private boolean winForPlayer2() {
        return atLeastOneScoreAbove4() && player2.getScore() - player1.getScore() >= 2;
    }

    private boolean advantagePlayer2() {
        return atLeastOneScoreAbove4() && player1.getScore() - player2.getScore() == -1;
    }

    private boolean advantagePlayer1() {
        return atLeastOneScoreAbove4() && player1.getScore() - player2.getScore() == 1;
    }

    private String nameFor(int score) {
        String name = "";
        switch(score)
        {
            case 0:
                name+="Love";
                break;
            case 1:
                name+="Fifteen";
                break;
            case 2:
                name+="Thirty";
                break;
            case 3:
                name+="Forty";
                break;
        }
        return name;
    }

    private boolean atLeastOneScoreAbove4() {
        return player1.getScore() >= 4 || player2.getScore() >=4;
    }

    private boolean scoresAreEqual() {
        return player1.getScore() == player2.getScore();
    }
}
