package bean.tank;

import bean.game.Game;
import bean.game.Type;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public final class MyTank extends Tank {
    public MyTank() {
        super(new Image("FIle:image/自己.png"), 1, 1);

        Game.scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            switch (code) {
                case W:
                    moveUp();
                    break;
                case S:
                    moveDown();
                    break;
                case A:
                    moveLeft();
                    break;
                case D:
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
