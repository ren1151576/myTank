package bean.baseObject;

import bean.game.Game;
import bean.game.Type;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 地图上所有的元素基类
 */
public abstract class BaseObject {

    protected final int mappingValue = 10;  // 像素与地图数字映射值
    private int x;  // 地图数组坐标x
    private int y;  // 地图数组坐标y
    private final ImageView imageView = new ImageView();
    private Type type;

    public void initElement(Image image,int x, int y) {

        if (x > Game.map.length || y > Game.map[0].length) {

        }

        if (Game.map[x][y] != Type.empty) {
        }

        this.x = x;
        this.y = y;
        imageView.setImage(image);
        imageView.setX(x * mappingValue);
        imageView.setY(y * mappingValue);
        Game.rootNode.add(imageView);
        Game.map[x][y] = getType();
        type = getType();
    };

    protected abstract Type getType();
}
