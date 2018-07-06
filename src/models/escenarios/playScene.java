package models.escenarios;

import com.sun.javafx.geom.BoxBounds;
import input.Keyboard;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.players.Player1;
import models.players.PlayerRick.Player;
import models.controladores.gravedadAumentada;
import models.elementos.explosivos.enemigos.Base.roca;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMB;
import models.elementos.explosivos.enemigos.bombaOMG.rocaUno;
import models.elementos.explosivos.enemigos.controlador.hiloRocas;
import models.elementos.explosivos.granadas.holyGranade.holyGranadeDatos;
import models.elementos.explosivos.granadas.holyGranade.holyGranade;
import models.elementos.peldannos.Peldanno;
import models.players.Players;

import java.util.ArrayList;

public class playScene extends Scene {
    private Player player;
    private Players values;
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
        values= Player.getPlayerBase();

        primaryStage.setScene(this);
        content();

    }

    public void content(){

        //probando un fondo
        ImageView a=new ImageView();


        a.setImage(new Image(GameValues.getInstance().getClass().getResource("fondoPrueba.jpg").toExternalForm()));
        a.setFitHeight(GameValues.dimension[1]);
        a.setFitWidth(GameValues.dimension[0]);
        a.setPreserveRatio(false);
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





        player.getRoot().getChildren().addAll(a,player.getPlayer());


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

        //input.update();

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long timestamp) {
                if (input.isaPressed()){
                    pasoIzquierda(values.getPasoIzquierda(),values.getIzquierda());
                }
                if(input.isdPressed()) {
                    //input.update();
                    pasoderecha(values.getPasoDerecha(), values.getDerecha());
                }
                if(input.iswPressed()){
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY()-10);
                }
                if(input.issPressed()) {
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 10);
                }
                if(input.isSpacePressed()) {
                    Gravedad.sleeping(25);
                    salto(values.getSaltoDerecha(), 1, values.getDerecha());

                }

                /*else if(ke.getCode()==KeyCode.N){
                    salto(values.saltoIzquierda,-1,values.izquierda);
                }*/

                if(input.iszPressed()) {

                    Gravedad.sleeping(25);
                    //g.resumir();

                    //System.out.println("resume");
                    if(player.granadasEnPocesion>0) {
                        player.granadasEnPocesion--;
                        new holyGranade(new holyGranadeDatos());

                    }

                }
                if (input.isEscPressed()){
                    Gravedad.sleeping(50);
                    if(Gravedad.stop){
                        Gravedad.stop=false;
                    }else{
                        Gravedad.stop=true;
                    }
                }
                if(input.isxPressed()) {
                    Gravedad.sleeping(50);
                    if(player.enemigos>1){
                        player.enemigos--;
                    rocas.add(new bombaOMB(new rocaUno()));}

                }



            }
        };

        input=new Keyboard(timer);

        setOnKeyReleased(event -> {
            input.keyRealssed(event);
        });

        setOnKeyPressed(event -> {
            input.keyPressed(event);
        });

        /*if(false){
        //----------------------Definiendo eventos-----------------------
        this.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                if (ke.getCode()==KeyCode.A){
                    pasoIzquierda(values.pasoIzquierda,values.izquierda);
                }
                else if(ke.getCode()==KeyCode.D) {
                    //input.update();
                    pasoderecha(values.pasoDerecha, values.derecha);
                }
                else if(ke.getCode()==KeyCode.W){
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY()-10);
                }
                else if(ke.getCode()==KeyCode.S) {
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 10);
                }
                else if(ke.getCode()==KeyCode.M) {
                    //input.update();
                    salto(values.saltoDerecha, 1, values.derecha);
                }

                else if(ke.getCode()==KeyCode.N){
                    salto(values.saltoIzquierda,-1,values.izquierda);
                }

                else if(ke.getCode()==KeyCode.Z) {
                    new holyGranade(new holyGranadeDatos());
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

        });}*/
        setGravedad();//------------inicienado efecto de gravedad------------

    }



    private void salto(String[] pasos, int discriminante, String[] posicionFinal) {
        if (GameValues.permitirSalto){
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

        if (Player.action) { Player.action=false;
            Thread thread2 = new Thread(() -> {
                for (int j = 0; j < Player.pasosTotales; j++) {

                    player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[j]).toExternalForm()));

                    //moviendo jugador derecha o izquierda
                    paso(pasos,discriminante,posicionfinal);


                    try { Thread.sleep(Player.tiempoPaso / Player.pasosTotales);} catch (InterruptedException e) {e.printStackTrace();}
                }
                //imageView.setImage(new Image(values.getClass().getResource(posicionfinal[0]).toExternalForm()));
                g.setPosicionFinal(posicionfinal);
                Player.action=true;
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
                        (Player.distanciaPaso*discriminante)));
            }
        }else{
            if(player.getPlayer().getLayoutX()>GameValues.dimension[0]){
                Platform.runLater(() -> player.getPlayer().setLayoutX(GameValues.dimension[0]-values.getSizePlayer()[0]));
            }else{
                Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                        (Player.distanciaPaso*discriminante)));
            }
        }
    }

    public void pasoderecha(String[] pasos, String[] posicionfinal){
        GameValues.direccion=1;
        player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));

        if(player.getPlayer().getLayoutX()>GameValues.dimension[0]-values.getSizePlayer()[0]){
            Platform.runLater(() -> player.getPlayer().setLayoutX(GameValues.dimension[0]-values.getSizePlayer()[0]));
        }else{
            Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                    values.getDistanciaPaso()));
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
                    values.getDistanciaPaso()));
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
        g.setPosicionFinal(values.getDerecha());

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
        //players.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));
        for (int i=1;i<25;i++) {
            {
                Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() +
                        5*direccion));
            }
            if (player.getPlayer().getLayoutX() < 0 ) {
                player.getPlayer().setLayoutX(0);
                break;
            } else if (player.getPlayer().getLayoutX()>GameValues.dimension[0]-values.getSizePlayer()[0] ){
                player.getPlayer().setLayoutX(GameValues.dimension[0]-values.getSizePlayer()[0]);
                break;

            }

        }
        //g.setPosicionFinal(posicionfinal);

    }
}

