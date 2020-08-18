package bean.baseObject;

import bean.game.Game;
import bean.game.Type;

public abstract class MoveAbleObject extends BaseObject {

    protected int moveSpeed = 1;

    public void moveUp() {
        cleanOld();
        y -= moveSpeed;
        setNew();
    }

    public void moveDown() {
        cleanOld();
        y += moveSpeed;
        setNew();
    }

    public void moveLeft() {
        cleanOld();
        x -= moveSpeed;
        setNew();
    }

    public void moveRight() {
        cleanOld();
        x += moveSpeed;
        setNew();
    }


    private void cleanOld() {
        Game.map[x][y] = Type.empty;
    }

    private void setNew() {
        Game.map[x][y] = type;
        imageView.setX(x * mappingValue);
        imageView.setY(y * mappingValue);
    }
}
