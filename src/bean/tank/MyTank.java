package bean.tank;

import bean.game.Direction;
import bean.game.Game;
import bean.game.Type;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.Timer;
import java.util.TimerTask;

public final class MyTank extends Tank {

    private final MyTankMove myTankMove = new MyTankMove();

    public MyTank() {
        super(new Image("FIle:image/自己.png"), 1, 1, Direction.up);
        Game.scene.setOnKeyPressed(event -> {

            switch (event.getCode()) {
                case J:
                    fire();
                    break;
                default:
                    myTankMove.myMove(event.getCode());
            }

        });
    }

    @Override
    protected Type setType() {
        return Type.myTank;
    }

    private class MyTankMove extends TimerTask {
        private Timer timer;

        public void myMove(KeyCode keyCode) {
            if (timer != null) {
                return;
            }
            move(keyCode);
            timer = new Timer();
            timer.schedule(myTankMove, 1000);
        }

        @Override
        public void run() {
            timer = null;
        }
    }
}
