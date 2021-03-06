package bean.baseObject;

import bean.game.Game;
import bean.game.Type;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 地图上所有的元素基类
 */
public abstract class BaseObject {

    public final static int mappingValue = 60;  // 像素与地图数字映射值
    protected int x;  // 地图数组坐标x
    protected int y;  // 地图数组坐标y
    protected final ImageView imageView;
    public Type type;

    public BaseObject() {
        imageView = new ImageView();
    }

    public void initElement(Image image,int x, int y) {

        if (x > Game.weight || y > Game.height) {
            return;
        }

        if (Game.map[x][y] != null) {
           return;
        }

        this.x = x;
        this.y = y;
        imageView.setImage(image);
        imageView.setX(x * mappingValue);
        imageView.setY(y * mappingValue);
        Game.rootNode.add(imageView);
        type = setType();
        Game.map[x][y] = this;

    }

    protected abstract Type setType();

    protected void cleanOld() {
        Game.map[x][y] = null;
    }

    protected void deleteObj() {
        cleanOld();
        Platform.runLater(() -> Game.rootNode.remove(imageView));
    }
}
