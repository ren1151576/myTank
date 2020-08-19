package bean.game;

import bean.baseObject.BaseObject;
import bean.baseObject.Iron;
import bean.tank.MyTank;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {

    public static final int weight = 30;

    public static final int height = 15;

    public static final Type map[][] = new Type[weight][height];

    public static ObservableList<Node> rootNode;

    public static Scene scene;

    public static void startGame() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        primaryStage.setTitle("myGame");
        scene = new Scene(pane, weight * BaseObject.mappingValue, height * BaseObject.mappingValue);
        Game.rootNode = pane.getChildren();
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int i = 0; i < weight; i ++) {
            for (int j = 0; j < height; j ++) {
                map[i][j] = Type.empty;
            }
        }

        // 初始化地图边界
        for (int i = 0; i < weight; i++) {
            new Iron(i, 0);
            new Iron(i, height - 1);
        }

        for (int i = 1; i < height - 1; i++) {
            new Iron(0, i);
            new Iron(weight - 1, i);
        }

        new MyTank();

    }

    public static void main(String[] args) {
        Game.startGame();
    }
}
