package models.escenarios;

import input.Keyboard;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.controladores.hiloVentana;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMBdatos;
import models.elementos.explosivos.granadas.blackHole.blackHole;
import models.elementos.explosivos.granadas.blackHole.blackHoleDatos;
import models.elementos.peldannos.controlador.peldannoMaster;
import models.players.Player1;
import models.players.Player;
import models.controladores.gravedadAumentada;
import models.elementos.explosivos.enemigos.Base.roca;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMB;
import models.elementos.explosivos.enemigos.controlador.hiloRocas;
import models.elementos.peldannos.Peldanno;
import models.players.Players;

//import java.awt.event.WindowEvent;
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
    private Boolean saltarin=true;
    private ImageView fondo=new ImageView();





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

        //StringProperty a=new SimpleStringProperty(String.valueOf(player.getVida()));
        player.textVida.setText("VIDA RESTANTE:  "+String.valueOf(player.getVida()));



        player.box.setLayoutX(0);
        player.box.setLayoutY(0);



        fondo.setImage(new Image(GameValues.getInstance().getClass().getResource("fondoPrueba.jpg").toExternalForm()));
        fondo.setFitHeight(GameValues.dimension[1]);
        fondo.setFitWidth(GameValues.dimension[0]);
        fondo.setPreserveRatio(false);
        fondo.setLayoutX(0);fondo.setLayoutY(0);



        new hiloVentana(fondo);



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

        Player.box.getChildren().addAll(Player.textVida);

        player.getRoot().getChildren().addAll(fondo,player.getPlayer(),Player.box);
        peldannoMaster.iniciar();







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
                    //Player.getRoot().setTranslateY(Player.getRoot().getTranslateY()+10);
                    player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 10);
                }
                if(input.isSpacePressed()) {

                    //Gravedad.sleeping(50);
                    saltin(values.getSaltoDerecha(), 1, values.getDerecha());

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
                        new blackHole(new blackHoleDatos());

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
                    rocas.add(new bombaOMB(new bombaOMBdatos()));}

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
        Player1.getPrimaryStage().setOnCloseRequest(new javafx.event.EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Gravedad.exit=false;
                hiloRocas.exit=false;
            }
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
                    rocas.add(new bombaOMB(new bombaOMBdatos()));
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

                        if(!Gravedad.efectoGravedad(Player.getPlayer())&& j>4){
                            Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 35));
                            break;
                        }
                        else{Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 15));}
                        Platform.runLater(() -> player.getPlayer().setLayoutX(player.getPlayer().getLayoutX() + (5*GameValues.direccion)));
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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


    public void saltin(String[] pasos, int discriminante, String[] posicionFinal){
        if(saltarin){
            saltarin=false;
            Thread temp=new Thread(()->{
                try {
                    salto(pasos,discriminante,posicionFinal);
                    Thread.sleep(200);
                    saltarin=true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
            temp.start();
    }}
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

