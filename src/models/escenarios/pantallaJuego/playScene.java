package models.escenarios.pantallaJuego;

import input.Keyboard;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.controladores.hiloVentana;
import models.elementos.Habilidad.factory.habilidadFactory;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMBdatos;
import models.elementos.explosivos.granadas.factory.granadaFactory;
import models.elementos.explosivos.granadas.factory.granadaType;
import models.controladores.peldannoMaster;
import models.controladores.scenariosValues;
import models.escenarios.pantallaPausa.scenaPausa;
import models.players.Player;
import models.elementos.explosivos.enemigos.Base.roca;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMB;
import models.elementos.explosivos.enemigos.controlador.hiloRocas;
import models.elementos.peldannos.Peldanno;
import models.players.Base.Players;


import java.util.ArrayList;

public class playScene extends Scene {
    private Player player;
    private Players values;
    private Gravedad g;
    private static ArrayList<Peldanno> peldannos;
    private static ArrayList<roca> rocas;
    private hiloRocas rocashilo;
    private Keyboard input;
    private Boolean saltarin=true;
    private ImageView fondo=new ImageView();





    public playScene() {

        super(Player.getRoot(), GameValues.dimension[0],GameValues.dimension[1]);
        peldannos=new ArrayList<>();
        rocas =new ArrayList<>();
        player=Player.getInstance();
        values= Player.getPlayerBase();

        player.granadasDisponibles=new ArrayList<>();

        //-------------comprando granadas iniciales--------------
        player.granadasDisponibles.add(granadaType.VENENO);
        player.granadasDisponibles.add(granadaType.CONGELACION);
        player.granadasDisponibles.add(granadaType.HOLYGRANADE);
        player.granadasDisponibles.add(granadaType.BLACKHOLE);
        player.granadasDisponibles.add(granadaType.HOLYGRANADE);
        player.granadasDisponibles.add(granadaType.BLACKHOLE);
        player.granadasDisponibles.add(granadaType.HOLYGRANADE);
        player.granadasDisponibles.add(granadaType.HOLYGRANADE);
        player.granadasDisponibles.add(granadaType.BLACKHOLE);
        player.granadasDisponibles.add(granadaType.HOLYGRANADE);
        player.granadasDisponibles.add(granadaType.BLACKHOLE);
        player.granadasDisponibles.add(granadaType.HOLYGRANADE);
        //-----------------------------------------------------



        scenariosValues.primaryStage.setScene(this);
        content();

    }

    public void content(){

        //-------------caja Superior---------------------------------------------------------------
        player.textVida.setText("VIDA RESTANTE:  "+String.valueOf(player.getVida()));
        player.textDinero.setText("$$$:  "+player.dinero);
        ImageView granadaActual=new ImageView(granadaFactory.getGranadaImagen(player.granadasDisponibles.get(0)));
        ImageView cannon=new ImageView(new Image(this.getClass().getResource("cannon.gif").toExternalForm()));

        granadaActual.setFitWidth(50);
        granadaActual.setPreserveRatio(true);
        cannon.setFitWidth(50);
        cannon.setPreserveRatio(true);

        player.box.setLayoutX(0);
        player.box.setLayoutY(0);
        player.box.setAlignment(Pos.CENTER);


        //-----------------------------------------------------------------------------------------

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

        Player.box.getChildren().addAll(cannon,Player.textVida,granadaActual,player.textDinero);
        player.getRoot().getChildren().addAll(fondo,player.getPlayer());
        peldannoMaster.iniciar();
        player.getRoot().getChildren().addAll(Player.box);


        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long timestamp) {
                if(Gravedad.stop) {

                    if (input.iscPressed()) {
                        habilidadFactory.getHabilidad();
                    }
                    if (input.isaPressed()) {
                        pasoIzquierda(values.getPasoIzquierda(), values.getIzquierda());
                    }
                    if (input.isdPressed()) {
                        //input.update();
                        pasoderecha(values.getPasoDerecha(), values.getDerecha());
                    }
                    if (input.iswPressed()) {

                        player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 10);
                    }
                    if (input.issPressed()) {
                        //Player.getRoot().setTranslateY(Player.getRoot().getTranslateY()+10);
                        player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() + 10);
                    }
                    if (input.isSpacePressed()) {
                        Gravedad.sleeping(50);
                        saltin(values.getSaltoDerecha(), 1, values.getDerecha());

                    }

                    if (input.iszPressed()) {

                        Gravedad.sleeping(25);
                        try {
                            if (player.granadasDisponibles.size() > 0) {
                                granadaFactory.getGranada(player.granadasDisponibles.remove(0));
                                if (player.granadasDisponibles.size() > 0) {
                                    granadaActual.setImage(granadaFactory.getGranadaImagen(player.granadasDisponibles.get(0)));
                                } else {
                                    granadaActual.setImage(null);
                                }

                            }
                        } catch (Exception e) {
                            System.out.println("sin granadas");
                        }
                    }

                    if(input.isxPressed()) {     Gravedad.sleeping(50);
                        if(player.enemigos>1){       player.enemigos--;
                            System.out.println(player.enemigos);
                            rocas.add(new bombaOMB(new bombaOMBdatos()));}
                    }
                    if (input.isEscPressed()){ Gravedad.sleeping(100);
                        Gravedad.stop=false;
                        input.setSceState();
                        new scenaPausa(new Pane());
                        Gravedad.sleeping(500);
                    /*if(Gravedad.stop){ Gravedad.stop=false;
                    }else{ Gravedad.stop=true;                    }*/
                    }
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
        scenariosValues.primaryStage.setOnCloseRequest(new javafx.event.EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Gravedad.exit=false;
                hiloRocas.exit=false;
            }
        });


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

                    }

                    g.setPosicionFinal(posicionFinal);

                    player.salto=true;

                });
                thread2.setDaemon(true);

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


        rocashilo=new hiloRocas();
        rocashilo.start();

        try {
            g.start();
            hiloVentana.iterador=1;
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

}

