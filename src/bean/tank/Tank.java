package bean.tank;

import bean.baseObject.MoveAbleObject;
import bean.bullet.Bullet;
import bean.game.Direction;
import bean.game.Game;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public abstract class Tank extends MoveAbleObject {

    protected Direction direction;

    public Tank(Image image, int x, int y, Direction direction) {
        this.direction = direction;
        initElement(image, x, y);
    }

    protected void move(KeyCode code) {
        switch (code) {
            case W:
                if (direction != Direction.up) {
                    imageView.setRotate(0);
                    direction = Direction.up;
                    break;
                }
                moveUp();
                break;
            case S:
                if (direction != Direction.down) {
                    imageView.setRotate(180);
                    direction = Direction.down;
                    break;
                }
                moveDown();
                break;
            case A:
                if (direction != Direction.left) {
                    imageView.setRotate(270);
                    direction = Direction.left;
                    break;
                }
                moveLeft();
                break;
            case D:
                if (direction != Direction.right) {
                    imageView.setRotate(90);
                    direction = Direction.right;
                    break;
                }
                moveRight();
                break;
            default:
                System.err.println(code.getName() + "未配置");
        }
    }

    public void fire() {
        Platform.runLater(() -> new Bullet(direction,x,y));
    }
}
