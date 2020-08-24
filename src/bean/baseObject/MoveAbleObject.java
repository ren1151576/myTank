package bean.baseObject;

import bean.game.Game;
import javafx.application.Platform;

public abstract class MoveAbleObject extends BaseObject {

    public void moveUp() {

        if (Game.map[x][y - 1] != null) {
            return;
        }
        cleanOld();
        y--;
        setNew();
    }

    public void moveDown() {

        if (Game.map[x][y + 1] != null) {
            return;
        }
        cleanOld();
        y++;
        setNew();
    }

    public void moveLeft() {

        if (Game.map[x - 1][y] != null) {
            return;
        }
        cleanOld();
        x--;
        setNew();
    }

    public void moveRight() {

        if (Game.map[x + 1][y] != null) {
            return;
        }
        cleanOld();
        x++;
        setNew();
    }

    private void setNew() {
        cleanOld();
        Game.map[x][y] = this;
        imageView.setX(x * mappingValue);
        imageView.setY(y * mappingValue);
    }

}
