package models.escenarios.factory;

import Tienda.tienda.Tienda;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menuSeleccion.MenuSect;
import models.controladores.GameValues;
import models.escenarios.pantallaGano.scenaGano;
import models.escenarios.pantallaJuego.playScene;
import models.players.Player;

public class sceneFactory {
    private static sceneFactory ourInstance = new sceneFactory();
    public static sceneFactory getInstance() {return ourInstance;}
    private sceneFactory() {}

    public static Scene getScene(ScenesType type){
        //System.out.println(Player.personaje);
        switch (type){
            case PLAYSCENE:
                Player.setRoot();
                Player.playScene=new playScene();
                return Player.playScene;
            case MENUSELECCION:
                return new MenuSect(new Pane());
            case TIENDA:
                return new Tienda(new Pane());
            case PANTALLAGANO:
                return new scenaGano(new Pane());

        }
        return null;

    }




}
