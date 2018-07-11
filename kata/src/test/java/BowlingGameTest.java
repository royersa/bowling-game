import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

    private Game game;

    @Before
    public void initialize(){
        game = new Game();
    }

    private void rollMany(int rolls, int pins){
        for (int i = 0; i< rolls; i++){
            game.roll(pins);
        }
    }

    private void rollSpare(){
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike(){
        game.roll(10);
    }

    @Test
    public void testGutterGame(){
        rollMany(20, 0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void testAllOnes(){
        rollMany(20, 1);
        Assert.assertEquals(20, game.score());
    }

    @Test
    public void testSpare(){
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        Assert.assertEquals(16, game.score());
    }

    @Test
    public void testStrike(){
        rollStrike();
        game.roll(3);
        game.roll(4);
        rollMany(16, 0);
        Assert.assertEquals(24, game.score());
    }

    @Test
    public void testPerfectGame(){
        rollMany(12, 10);
        Assert.assertEquals(300, game.score());
    }
}
