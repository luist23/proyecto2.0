package models.escenarios.pantallaPausa;

import input.Keyboard;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.WindowEvent;
import models.controladores.*;
import models.elementos.Habilidad.factory.habilidadFactory;
import models.elementos.explosivos.enemigos.Base.roca;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMB;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMBdatos;
import models.elementos.explosivos.enemigos.controlador.hiloRocas;
import models.elementos.explosivos.granadas.factory.granadaFactory;
import models.elementos.explosivos.granadas.factory.granadaType;
import models.elementos.peldannos.Peldanno;
import models.escenarios.factory.ScenesType;
import models.escenarios.factory.sceneFactory;
import models.players.Base.Players;
import models.players.Player;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class scenaPausa extends Scene {
    private ImageView fondo=new ImageView();
    private Pane root;
    private boolean cambiandoVentana=true;






    public scenaPausa(Pane root) {
        super(root, GameValues.dimension[0],GameValues.dimension[1]);
        this.root=root;
        //this.setRoot(root);
        //this.setFill( new Paint());
        scenariosValues.primaryStage.setScene(this);
        System.out.println(root);
        content();

    }

    public void content(){



        /*
        player.box.setLayoutX(0);
        player.box.setLayoutY(0);
        player.box.setAlignment(Pos.CENTER);*/
        HBox hbox=new HBox();
        hbox.setLayoutY(500);
        hbox.setLayoutY(500);

        ImageView continuar=new ImageView(new Image(this.getClass().getResource("continuar.jpg").toExternalForm()));
        continuar.setFitWidth(200);
        continuar.setPreserveRatio(true);
        continuar.setOnMouseClicked((MouseEvent event) -> {
            try {
                Thread.sleep(100);
                if(cambiandoVentana){
                    scenariosValues.primaryStage.setScene(Player.playScene);
                    Gravedad.stop=true;
                    cambiandoVentana=false;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        });

        ImageView shop=new ImageView(new Image(this.getClass().getResource("shop.gif").toExternalForm()));
        shop.setFitWidth(200);
        shop.setPreserveRatio(true);
        shop.setOnMouseClicked((MouseEvent event) -> {
            try {
                Thread.sleep(100);
                if(cambiandoVentana){
                    //Gravedad.stop=false;
                    //Thread.sleep(3000);
                    sceneFactory.getScene(ScenesType.TIENDA);
                    Gravedad.stop=true;
                    cambiandoVentana=false;
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("tienda");
        });

        hbox.getChildren().addAll(continuar,shop);


        //-----------------------------------------------------------------------------------------

        fondo.setImage(new Image(this.getClass().getResource("portada.jpg").toExternalForm()));
        fondo.setFitHeight(GameValues.dimension[1]);
        fondo.setFitWidth(GameValues.dimension[0]);
        fondo.setPreserveRatio(false);
        fondo.setLayoutX(0);fondo.setLayoutY(0);

        //new hiloVentana(fondo);

        //VideoTrack videoprueba;
        /*Media media=new Media(this.getClass().getResource("videoPrueba.mp4").toExternalForm());
        media.setOnError(()-> System.out.println("error video"));//ReadOnlyObjectProperty<Duration> durationReadOnlyObjectProperty = media.durationProperty();
        MediaPlayer playering = new MediaPlayer(media);
        playering.setOnError(()-> System.out.println("no play video"));
        MediaView view =new MediaView(playering);
        view.setPreserveRatio(true);
        view.setFitHeight(GameValues.dimension[1]);
        view.setFitWidth(GameValues.dimension[0]);
        view.setLayoutX(0);
        view.setLayoutY(0);*/
        //playering.play();//--reproducir

        //Player.box.getChildren().addAll(cannon,Player.textVida,granadaActual,player.textDinero);
        //player.getRoot().getChildren().addAll(fondo,player.getPlayer());
        //peldannoMaster.iniciar();
        root.getChildren().addAll(fondo,hbox);

        //scenariosValues.primaryStage.show();




    }



}