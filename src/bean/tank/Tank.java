package bean.tank;

import bean.baseObject.MoveAbleObject;
import bean.bullet.Bullet;
import javafx.scene.image.Image;

public abstract class Tank extends MoveAbleObject {

    private Bullet bullet;

    public Tank(Image image, int x, int y) {
        initElement(image, x, y);
    }

}
