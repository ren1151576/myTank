package bean.tank;

import bean.game.Direction;
import bean.game.Game;
import bean.game.Type;
import javafx.scene.image.Image;

public final class MyTank extends Tank {
    public MyTank() {
        super(new Image("FIle:image/自己.png"), 1, 1, Direction.up);
        Game.scene.setOnKeyPressed(event -> {

            switch (event.getCode()) {
                case J:
                    fire();
                    break;
                default:
                    move(event.getCode());
            }

        });
    }

    @Override
    protected Type setType() {
        return Type.myTank;
    }
}
