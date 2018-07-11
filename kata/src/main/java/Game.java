public class Game {
    public int[] rolls = new int[21];
    public int currentRoll;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score(){
        int score = 0;
        int roll = 0;
        for (int frame = 0; frame < 10; frame++){
            if(isStrike(roll)){
                score += calculateFrameScore(roll) + strikeBonus(roll);
                roll++;
            }
            else if(isSpare(roll)){
                score += calculateFrameScore(roll) + spareBonus(roll);
                roll += 2;
            }
            else {
                score += calculateFrameScore(roll);
                roll += 2;
            }
        }
        return score;
    }

    private boolean isSpare(int roll){
        return rolls[roll] + rolls[roll+1] == 10;
    }

    private boolean isStrike(int roll){
        return rolls[roll] == 10;
    }

    private int calculateFrameScore(int roll){
        return Math.min(rolls[roll] + rolls[roll + 1], 10);
    }

    private int spareBonus(int roll){
        return rolls[roll+2];
    }

    private int strikeBonus(int roll){
        return rolls[roll+1] + rolls[roll+2];
    }
}
