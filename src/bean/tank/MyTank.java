package bean.tank;

import bean.game.Game;
import bean.game.Type;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public final class MyTank extends Tank {
    public MyTank() {
        super(new Image("FIle:image/自己.png"), 1, 1, Direction.up);
        Game.scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
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
        });
    }

    @Override
    protected Type setType() {
        return Type.myTank;
    }
}
