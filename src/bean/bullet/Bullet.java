package bean.bullet;

import bean.baseObject.MoveAbleObject;
import bean.game.Direction;
import bean.game.Type;
import javafx.scene.image.Image;

import java.util.Timer;
import java.util.TimerTask;

public class Bullet extends MoveAbleObject {
    @Override
    protected Type setType() {
        return Type.bullet;
    }

    private final Direction direction;

    public Bullet(Direction direction, int startX, int startY) {
        int changeXNum = 0;
        int changeYNum = 0;

        switch (direction) {
            case right:
                changeXNum = 1;
                break;
            case left:
                changeXNum = -1;
                break;
            case down:
                changeYNum = 1;
                break;
            case up:
                changeYNum = -1;
                break;
            default:
        }

        Image image = new Image("FIle:image/boom.png");
        initElement(image, startX + changeXNum, startY + changeYNum);
        this.direction = direction;

        Timer timer = new Timer();
        timer.schedule(new MyTask(), 0, 1000);
    }


    class MyTask extends TimerTask {

        @Override
        public void run() {
            switch (direction) {
                case up:
                    moveUp();
                    break;
                case down:
                    moveDown();
                    break;
                case left:
                    moveLeft();
                    break;
                case right:
                    moveRight();
                    break;
                default:
            }

        }

    }
}
