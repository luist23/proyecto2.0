package models.escenarios;

import javafx.scene.Scene;
import javafx.stage.Stage;
import models.controladores.GameValues;

public class sceneFactory {
    private static sceneFactory ourInstance = new sceneFactory();
    public static sceneFactory getInstance() {return ourInstance;}
    private sceneFactory() {}

    public static Scene getScene(ScenesType type, Stage primaryStage){
        switch (type){
            case PLAYSCENE:
                playScene a= new playScene(GameValues.dimension[0],GameValues.dimension[1],primaryStage);
                //root.getChildren().addAll((a.getImageView()));
                return a;

        }
        return null;

    }




}
