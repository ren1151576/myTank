package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        primaryStage.setTitle("myGame");
        Scene scene = new Scene(pane, 1000, 600);
        primaryStage.setScene(scene);

        Image image = new Image("FIle:image/自己.png");
        ImageView imageView = new ImageView(image);
        pane.getChildren().add(imageView);

        primaryStage.show();

        EventHandler<KeyEvent> keyEvent = e->{
           switch (e.getCode()) {
               case S:
                   moveDown(imageView);
                   break;
               default:
                   System.out.println(e.getCode());
           }
        };
        scene.setOnKeyPressed(keyEvent);

    }

    private void moveDown(ImageView imageView) {
        imageView.setY(imageView.getY() + 10);
    }

}
