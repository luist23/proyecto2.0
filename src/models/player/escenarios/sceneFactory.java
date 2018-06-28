package models.player.escenarios;

import javafx.scene.Group;
import javafx.scene.Scene;
import models.player.GameValues;

public class sceneFactory {
    private static sceneFactory ourInstance = new sceneFactory();
    public static sceneFactory getInstance() {return ourInstance;}
    private sceneFactory() {}

    public static Scene getScene(ScenesType type,Group root){
        switch (type){
            case PLAYSCENE:
                playScene a= new playScene(root, GameValues.dimension[0],GameValues.dimension[1]);
                root.getChildren().addAll((a.getImageView()));
                return a;

        }
        return null;

    }




}
