package models.escenarios;

import com.sun.media.jfxmedia.events.PlayerEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import models.controladores.GameValues;
import models.controladores.scenariosValues;

import java.beans.EventHandler;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class videoIntro extends Scene {
    public videoIntro(Parent root) {
        super(root);
        //VideoTrack videoprueba;
        Media media=new Media(this.getClass().getResource("videoPrueba.mp4").toExternalForm());
        media.setOnError(()-> System.out.println("error video"));//ReadOnlyObjectProperty<Duration> durationReadOnlyObjectProperty = media.durationProperty();
        MediaPlayer playering = new MediaPlayer(media);
        playering.setOnError(()-> System.out.println("no play video"));
        MediaView view =new MediaView(playering);
        view.setPreserveRatio(true);
        view.setFitHeight(GameValues.dimension[1]);
        view.setFitWidth(GameValues.dimension[0]);
        view.setLayoutX(0);
        view.setLayoutY(0);
        scenariosValues.primaryStage.setScene(this);
        playering.play();//--reproducir
        playering.onEndOfMediaProperty();

    }
}
