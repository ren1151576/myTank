package bean.baseObject;

import bean.game.Game;
import bean.game.Type;

public abstract class MoveAbleObject extends BaseObject {

    public void moveUp() {

        if (Game.map[x][--y] != null) {
            y++;
            return;
        }
        setNew();
    }

    public void moveDown() {

        if (Game.map[x][++y] != null) {
            y--;
            return;
        }
        setNew();
    }

    public void moveLeft() {

        if (Game.map[--x][y] != null) {
            x++;
            return;
        }

        setNew();
    }

    public void moveRight() {

        if (Game.map[++x][y] != null) {
            x--;
            return;
        }
        setNew();
    }


    private void cleanOld() {
        Game.map[x][y] = null;
    }

    private void setNew() {
        cleanOld();
        Game.map[x][y] = this;
        imageView.setX(x * mappingValue);
        imageView.setY(y * mappingValue);
    }
}
