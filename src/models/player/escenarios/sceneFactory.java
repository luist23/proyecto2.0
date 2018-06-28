package models.player.escenarios;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.player.GameValues;

public class sceneFactory {
    private static sceneFactory ourInstance = new sceneFactory();
    public static sceneFactory getInstance() {return ourInstance;}
    private sceneFactory() {}

    public static Scene getScene(ScenesType type, Stage primaryStage){
        switch (type){
            case PLAYSCENE:
                playScene a= new playScene(new Pane(), GameValues.dimension[0],GameValues.dimension[1],primaryStage);
                //root.getChildren().addAll((a.getImageView()));
                return a;

        }
        return null;

    }




}
