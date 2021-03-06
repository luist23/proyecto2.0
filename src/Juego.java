import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import menuSeleccion.MenuSect;
import models.controladores.GameValues;
import models.escenarios.factory.ScenesType;
import models.escenarios.factory.sceneFactory;
import models.controladores.scenariosValues;
import models.players.Player;
import models.players.factory.playerFactory;
import models.players.factory.playerType;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class Juego extends Application{


    public static void main(String... args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameValues gameValues=GameValues.getInstance();
        scenariosValues scenariosValue= scenariosValues.getInstance();
        Player.personaje=playerType.PEACH;

        playerFactory.getPlayer();//escogiendoJugador

        Player player= Player.getInstance();
        scenariosValue.primaryStage=primaryStage;
        scenariosValue.primaryStage.setTitle("JavaFx");
        //sceneFactory.getScene(ScenesType.PLAYSCENE);
        sceneFactory.getScene(ScenesType.MENUSELECCION);
        //new scenaPausa();

        scenariosValue.primaryStage.show();






    }
}
