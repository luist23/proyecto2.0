package models.player.escenarios;

import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.PlayerRick.PlayerValuesRick;
import models.player.peldannos.Peldanno;
import sun.awt.GlobalCursorManager;

import java.util.ArrayList;

public class playScene extends Scene {
    private Player player;
    private PlayerValuesRick values;
    private Gravedad g;
    private static ArrayList<Peldanno> peldannos;


    public playScene( double width, double height, Stage primaryStage) {

        super(Player.getRoot(), width, height);
        peldannos=new ArrayList<>();
        player=Player.getInstance();
        values=PlayerValuesRick.getInstance();
        primaryStage.setScene(this);
        content();

    }

    public void content(){

        //probando un fondo
        ImageView a=new ImageView();
        a.setImage(new Image(GameValues.getInstance().getClass().getResource("fondoPrueba.jpg").toExternalForm()));
        a.setFitHeight(GameValues.dimension[1]);
        a.setFitWidth(GameValues.dimension[0]);
        a.setPreserveRatio(true);
        a.setLayoutX(0);a.setLayoutY(0);


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
        playering.play();//--reproducir




        player.getRoot().getChildren().addAll(view,player.getPlayer());


        peldannos.add(new Peldanno(0,300));
        peldannos.add(new Peldanno(600,400));
        peldannos.add(new Peldanno(190,500));
        peldannos.add(new Peldanno(0,GameValues.dimension[1]-25));


        //----------------------Definiendo eventos-----------------------
        this.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                if (ke.getCode()==KeyCode.A){
                    pasoIzquierda(values.pasoIzquierda,values.izquierda);
                }
                else if(ke.getCode()==KeyCode.D) {
                    pasoderecha(values.pasoDerecha, values.derecha);
                }
                else if(ke.getCode()==KeyCode.W){
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY()-10);
                }
                else if(ke.getCode()==KeyCode.S) {
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 10);
                }
                else if(ke.getCode()==KeyCode.M) {
                    salto(values.saltoDerecha, 1, values.derecha);
                }

                else if(ke.getCode()==KeyCode.N){
                    salto(values.saltoIzquierda,-1,values.izquierda);
                }
                else if(ke.getCode()==KeyCode.E) {
                    salto(values.saltoDerecha, 1, values.derecha);
                    pasoderecha(values.pasoDerecha, values.derecha);
                }
            }

        });setGravedad();//------------inicienado efecto de gravedad------------

    }



    private void salto(String[] pasos, int discriminante, String[] posicionFinal) {
        if (GameValues.permitirSalto){
            //Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 15));
            GameValues.permitirSalto=false;

            player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));

                //Movimiento en Y
                Thread thread2 = new Thread(()->{
                    for (int j =1;j<13;j++){
                        GameValues.permitirSalto=false;

                        Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 15));
                        Gravedad.sleeping(25);
                        //}
                    }//GameValues.gravedad=true;

                    g.setPosicionFinal(posicionFinal);


                    //imageView.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));

                });
                thread2.setDaemon(true);
                //thread.start();
                thread2.start();

            }
    }



    public void avanzarJugador(String[] pasos, int discriminante, String[] posicionfinal) {

        if (PlayerValuesRick.action) { PlayerValuesRick.action=false;
            Thread thread2 = new Thread(() -> {
                for (int j = 0; j < PlayerValuesRick.pasosTotales; j++) {

                    player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[j]).toExternalForm()));

                    //moviendo jugador derecha o izquierda
                    paso(pasos,discriminante,posicionfinal);


                    try { Thread.sleep(PlayerValuesRick.tiempoPaso / PlayerValuesRick.pasosTotales);} catch (InterruptedException e) {e.printStackTrace();}
                }
                //imageView.setImage(new Image(values.getClass().getResource(posicionfinal[0]).toExternalForm()));
                g.setPosicionFinal(posicionfinal);
                PlayerValuesRick.action=true;
            }); thread2.setDaemon(true); thread2.start();
        }else{
            paso(pasos,discriminante,posicionfinal);

        }

    }

    private void paso(String[] pasos, int discriminante, String[] posicionfinal){

        //moviendo jugador derecha o izquierda
        if(discriminante<1){
            if(player.getPlayer().getLayoutX()<0){
                Platform.runLater(() -> player.getPlayer().setLayoutX(0));
            }else{
                Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                        (PlayerValuesRick.distanciaPaso*discriminante)));
            }
        }else{
            if(player.getPlayer().getLayoutX()>GameValues.dimension[0]){
                Platform.runLater(() -> player.getPlayer().setLayoutX(GameValues.dimension[0]-values.sizePlayer[0]));
            }else{
                Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                        (PlayerValuesRick.distanciaPaso*discriminante)));
            }
        }
    }

    public void pasoderecha(String[] pasos, String[] posicionfinal){
        player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));

        if(player.getPlayer().getLayoutX()>GameValues.dimension[0]-values.sizePlayer[0]){
            Platform.runLater(() -> player.getPlayer().setLayoutX(GameValues.dimension[0]-values.sizePlayer[0]));
        }else{
            Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                    values.distanciaPaso));
        }
        g.setPosicionFinal(posicionfinal);

    }

    public void pasoIzquierda(String[] pasos, String[] posicionfinal){
        player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));

        if(player.getPlayer().getLayoutX()<0){
            Platform.runLater(() -> player.getPlayer().setLayoutX(0));
        }else{
            Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() -
                    values.distanciaPaso));
        }
        g.setPosicionFinal(posicionfinal);

    }


    public void overlaping(){
        //if(imageView.getBoundsInParent().intersects(imageView2.getBoundsInParent()))
            System.out.println("overlapping :v");
    }

    public void setGravedad(){
        g=new Gravedad(player.getPlayer(),values);
        g.setPosicionFinal(values.derecha);
        try {
            g.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Peldanno> getPeldannos(){
        return peldannos;
    }
}

