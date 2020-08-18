package bean.game;

import bean.baseObject.BaseObject;
import bean.tank.MyTank;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {

    public static final int weight = 30;

    public static final int height = 30;

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

        new MyTank();

    }

    public static void main(String[] args) {
        Game.startGame();
    }
}
