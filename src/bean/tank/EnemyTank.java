package bean.tank;

import bean.game.Direction;
import bean.game.Type;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.util.Random;

public final class EnemyTank extends Tank implements Runnable {
    @Override
    protected Type setType() {
        return Type.enemyTank;
    }

    public EnemyTank() {
        super(new Image("FIle:image/敌人.png"), 28, 13, Direction.down);
        autoTask();
    }

    private void autoTask() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int moveFlag = random.nextInt(4);
            Direction direction = Direction.values()[moveFlag];
            KeyCode keyCode;
            switch (direction) {
                case up:
                    keyCode = KeyCode.W;
                    break;
                case down:
                    keyCode = KeyCode.S;
                    break;
                case left:
                    keyCode = KeyCode.A;
                    break;
                case right:
                    keyCode = KeyCode.D;
                    break;
                default:
                    keyCode = null;
            }
            move(keyCode);

            int fireFlag = random.nextInt(7);

            if (fireFlag < 3) {
                fire();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
