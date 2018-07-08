import javafx.application.Application;
import javafx.stage.Stage;
import models.controladores.GameValues;
import models.escenarios.factory.ScenesType;
import models.escenarios.factory.sceneFactory;
import models.escenarios.scenariosValues;
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
        scenariosValues scenariosValue= models.escenarios.scenariosValues.getInstance();
        playerFactory.getPlayer(playerType.RICK);//escogiendoJugador
        Player player= Player.getInstance();
        scenariosValue.primaryStage=primaryStage;
        scenariosValue.primaryStage.setTitle("JavaFx");
        sceneFactory.getScene(ScenesType.PLAYSCENE,scenariosValue.primaryStage);

        scenariosValue.primaryStage.show();






    }
}
