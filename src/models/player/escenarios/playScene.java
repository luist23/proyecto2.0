package models.player.escenarios;

import input.Keyboard;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.PlayerRick.PlayerValuesRick;
import models.player.escenarios.explosivos.enemigos.Base.roca;
import models.player.escenarios.explosivos.enemigos.bombaOMG.bombaOMB;
import models.player.escenarios.explosivos.enemigos.bombaOMG.rocaUno;
import models.player.escenarios.explosivos.enemigos.hiloRocas;
import models.player.escenarios.explosivos.granadas.holyGranade.granadaUno;
import models.player.escenarios.explosivos.granadas.holyGranade.holyGranade;
import models.player.peldannos.Peldanno;

import java.util.ArrayList;

public class playScene extends Scene {
    private Player player;
    private PlayerValuesRick values;
    private Gravedad g;
    private static ArrayList<Peldanno> peldannos;
    private static ArrayList<roca> rocas;
    private gravedadAumentada g2;
    private hiloRocas rocashilo;
    private Keyboard input;


    public playScene( double width, double height, Stage primaryStage) {

        super(Player.getRoot(), width, height);
        peldannos=new ArrayList<>();
        rocas =new ArrayList<>();
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





        player.getRoot().getChildren().addAll(player.getPlayer());


        peldannos.add(new Peldanno(0,300));
        peldannos.add(new Peldanno(600,400));
        peldannos.add(new Peldanno(230,500));
        peldannos.add(new Peldanno(190,900));
        peldannos.add(new Peldanno(700,600));
        peldannos.add(new Peldanno(80,600));
        peldannos.add(new Peldanno(290,500));
        peldannos.add(new Peldanno(700,250));
        peldannos.add(new Peldanno(600,200));
        peldannos.add(new Peldanno(0,GameValues.dimension[1]-25));
        input=new Keyboard();
        input.update();


        //----------------------Definiendo eventos-----------------------
        this.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                if (ke.getCode()==KeyCode.A){
                    pasoIzquierda(values.pasoIzquierda,values.izquierda);
                }
                else if(ke.getCode()==KeyCode.D) {
                    input.update();
                    pasoderecha(values.pasoDerecha, values.derecha);
                }
                else if(ke.getCode()==KeyCode.W){
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY()-10);
                }
                else if(ke.getCode()==KeyCode.S) {
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 10);
                }
                else if(ke.getCode()==KeyCode.M) {
                    input.update();
                    salto(values.saltoDerecha, 1, values.derecha);
                }

                else if(ke.getCode()==KeyCode.N){
                    salto(values.saltoIzquierda,-1,values.izquierda);
                }
                /*else if(ke.getCode()==KeyCode.E) {
                    salto(values.saltoDerecha, 1, values.derecha);
                    pasoderecha(values.pasoDerecha, values.derecha);
                }*/
                /*else if(ke.getCode()==KeyCode.SPACE) {
                    if (playering.getStatus().equals(PLAYING))
                    playering.pause();
                    else
                        playering.play();

                }*/
                else if(ke.getCode()==KeyCode.Z) {
                    new holyGranade(new granadaUno());
                }
                else if(ke.getCode()==KeyCode.X) {
                    rocas.add(new bombaOMB(new rocaUno()));
                }
                else if(ke.getCode()==KeyCode.E) {

                    slash(1);
                }
                else if(ke.getCode()==KeyCode.Q) {

                    slash(-1);
                }
            }

        });setGravedad();//------------inicienado efecto de gravedad------------

    }



    private void salto(String[] pasos, int discriminante, String[] posicionFinal) {
        if (GameValues.permitirSalto){
            //Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 15));
            GameValues.permitirSalto=false;



                //Movimiento en Y
                Thread thread2 = new Thread(()->{
                    player.salto=false;
                    player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));
                    for (int j =1;j<13;j++){
                        GameValues.permitirSalto=false;

                        Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 15));
                        Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() + (5*GameValues.direccion)));
                        Gravedad.sleeping(25);
                        //}
                    }//GameValues.gravedad=true;

                    g.setPosicionFinal(posicionFinal);

                    player.salto=true;



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
        GameValues.direccion=1;
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
        GameValues.direccion=-1;
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
        GameValues.setGravedadThread(g);
        g.setPosicionFinal(values.derecha);

        g2=new gravedadAumentada();
        rocashilo=new hiloRocas();
        rocashilo.start();

        try {
            g.start();
            //g2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Peldanno> getPeldannos(){
        return peldannos;
    }
    public static ArrayList<roca> getRocas(){
        return rocas;
    }

    public void slash(int direccion){
        GameValues.direccion=1;
        //player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));
        for (int i=1;i<25;i++) {
            {
                Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                        5*direccion));
            }
            if (player.getPlayer().getLayoutX() < 0 ) {
                player.getPlayer().setLayoutX(0);
                break;
            } else if (player.getPlayer().getLayoutX()>GameValues.dimension[0]-values.sizePlayer[0] ){
                player.getPlayer().setLayoutX(GameValues.dimension[0]-values.sizePlayer[0]);
                break;

            }

        }
        //g.setPosicionFinal(posicionfinal);

    }
}

