import com.mygdx.game.CollisionRect;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class Tets {

    @Test
    public void Test1()
    {
        assertTrue(true);
    }
    @Test
    public void Test2()
    {
        CollisionRect rect1 = new CollisionRect(10, 10, 10, 10);
        CollisionRect rect2 = new CollisionRect(9,  9,  10, 10);
        assertTrue(rect1.collidesWith(rect2));
    }
}
