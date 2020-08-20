package bean.bullet;

import bean.baseObject.MoveAbleObject;
import bean.game.Direction;
import bean.game.Game;
import bean.game.Type;
import javafx.scene.image.Image;

public class Bullet extends MoveAbleObject implements Runnable {
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

        new Thread(this).start();
    }


    @Override
    public void run() {
        while (true) {
            switch (direction) {
                case up:
                    if (Game.map[x][y - 1] != null) {
                        deleteObj();
                        return;
                    }
                    moveUp();
                    break;
                case down:
                    if (Game.map[x][y + 1] != null) {
                        deleteObj();
                        return;
                    }
                    moveDown();
                    break;
                case left:
                    if (Game.map[x - 1][y] != null) {
                        deleteObj();
                        return;
                    }
                    moveLeft();
                    break;
                case right:
                    if (Game.map[x + 1][y] != null) {
                        deleteObj();
                        return;
                    }
                    moveRight();
                    break;
                default:
                    deleteObj();
                    return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
