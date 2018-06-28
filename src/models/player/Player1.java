package models.player;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.PlayerValuesRick;
import models.player.escenarios.ScenesType;
import models.player.escenarios.playScene;
import models.player.escenarios.scenariosValues;
import models.player.escenarios.sceneFactory;

//import javax.swing.text.html.ImageView;

import static java.lang.Thread.sleep;
import static javafx.application.Application.launch;

public class Player1  extends Application implements Players <PlayerValuesRick> {
    private Stage primaryStage;
    private BorderPane rootLayout;

    private ImageView imageView2;

    //private playScene scene;


    public static void main(String... args) {
        //ejecutar app(new constructor)
        launch(args);

    }


    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JavaFx");

        Group root = new Group();// nuevo grupo

        //escena
        //colocarFondo(root,"Rick_salto_1.png");

        //scene = new Scene(root, GameValues.dimension[0],GameValues.dimension[1]);//nueva scene
        //scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        //Background background=new Background();

        //BackgroundImage image=new BackgroundImage(new Image(getClass().getResource("fondoPrueba.jpg").toExternalForm()));


        //escenari
        scenariosValues values=scenariosValues.getInstance();


        values.setPrimaryStage(primaryStage);
        values.setRoot(root);
        System.out.println("set scenarios values");

        Button button = new Button("play");
        button.setDefaultButton(true);

        button.setPrefSize(100, 50);
        button.setLayoutX(105);
        button.setLayoutY(110);
        button.setOnAction(event -> {
                    System.out.println(":v");
                    primaryStage.close();
                }
        );

        VBox box = new VBox();
        //Button left = new Button("left");
        //left.setOnAction(event -> imageView.setLayoutX(imageView.getLayoutX()-10));
        Button raigth = new Button("rihgt");
        //raigth.setOnAction(event -> imageView.setLayoutX(imageView.getLayoutX()+10));
        //box.getChildren().addAll(left,raigth);


        imageView2 = new ImageView();

        //personaje pocicion inicial
        //imageView2.setImage(new Image(values.getClass().getResource(PlayerValuesRick.derecha[0]).toExternalForm()));
        imageView2.setPreserveRatio(true);

        imageView2.setLayoutX(300);
        imageView2.setLayoutY(103);
        //root.getChildren().addAll();

        primaryStage.show();


    }
}


