package bean.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Game extends Application {

    public static final Type map[][] = new Type[30][30];

    public static void startGame() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        primaryStage.setTitle("myGame");
        Scene scene = new Scene(pane, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Game.startGame();
    }
}
