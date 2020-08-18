package bean.tank;

import bean.baseObject.MoveAbleObject;
import bean.bullet.Bullet;
import javafx.scene.image.Image;

public abstract class Tank extends MoveAbleObject {

    private Bullet bullet;

    protected Direction direction;

    public Tank(Image image, int x, int y, Direction direction) {
        this.direction = direction;
        initElement(image, x, y);
    }

    protected enum Direction{
        up,
        down,
        left,
        right
    }
}
