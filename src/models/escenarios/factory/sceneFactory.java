package models.escenarios.factory;

import javafx.scene.Scene;
import javafx.stage.Stage;
import models.controladores.GameValues;
import models.escenarios.pantallaJuego.playScene;

public class sceneFactory {
    private static sceneFactory ourInstance = new sceneFactory();
    public static sceneFactory getInstance() {return ourInstance;}
    private sceneFactory() {}

    public static Scene getScene(ScenesType type){
        switch (type){
            case PLAYSCENE:
                return new playScene();


        }
        return null;

    }




}
