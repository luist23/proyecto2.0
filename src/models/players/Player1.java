package models.players;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import models.players.PlayerRick.Player;
import models.players.PlayerRick.PlayerValuesRick;
import models.escenarios.ScenesType;
import models.escenarios.scenariosValues;
import models.escenarios.sceneFactory;

//import javax.swing.text.html.ImageView;

import static java.lang.Thread.sleep;
import static javafx.application.Application.launch;

public class Player1  extends Application /*implements Players <PlayerValuesRick>*/ {
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
        Player player= Player.getInstance();



        scenariosValues values=scenariosValues.getInstance();
        values.setPrimaryStage(primaryStage);
        //values.setRoot(root);
        Scene scene=sceneFactory.getScene(ScenesType.PLAYSCENE,primaryStage);

        //System.out.println("set scenarios values");

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
        imageView2.setPreserveRatio(true);
        imageView2.setLayoutX(300);
        imageView2.setLayoutY(103);
        //root.getChildren().addAll();

        primaryStage.show();


    }
}


