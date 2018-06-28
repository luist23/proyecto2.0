package models.player.escenarios;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.PlayerRick.PlayerValuesRick;

public class playScene extends Scene {
    //private ImageView player.getPlayer();
    private Player player;
    private PlayerValuesRick values;
    private Gravedad g;
    //private Pane root;

    public playScene( double width, double height, Stage primaryStage) {

        super(Player.getRoot(), width, height);

        player=Player.getInstance();
        //this.root=root;
        //player.setRoot(root);
        primaryStage.setScene(this);
        values=PlayerValuesRick.getInstance();


        content();

    }

    //public ImageView getImageView() { return player.getPlayer();}

    public void content(){
        player.getPlayer().setImage(new Image(values.getClass().getResource(PlayerValuesRick.derecha[0]).toExternalForm()));

        //AnchorPane.
        player.getPlayer().setLayoutX(10);
        player.getPlayer().setLayoutY(103);
        //System.out.println("getScene");
        ImageView a=new ImageView();
        a.setImage(new Image(GameValues.getInstance().getClass().getResource("fondoPrueba.jpg").toExternalForm()));
        a.setFitHeight(GameValues.dimension[1]);
        a.setFitWidth(GameValues.dimension[0]);
        a.setPreserveRatio(true);
        a.setLayoutX(0);a.setLayoutY(0);

        player.getRoot().getChildren().addAll(a,player.getPlayer());


        this.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>(){

                    public void handle(KeyEvent ke){
                        if (ke.getCode()==KeyCode.A){
                            pasoIzquierda(values.pasoIzquierda,values.izquierda);

                            //avanzarJugador(values.pasoIzquierda,-1,values.izquierda);
                        }
                        else if(ke.getCode()==KeyCode.D){
                            //imageView.setImage(new Image(getClass().getResource(PlayerValuesRick.derecha[1]).toExternalForm()));
                            //avanzarJugador(values.pasoDerecha,1,values.derecha);
                            pasoderecha(values.pasoDerecha,values.derecha);

                            //overlaping();
                            //imageView.setLayoutX(imageView.getLayoutX()+10);

                        }
                        else if(ke.getCode()==KeyCode.W){
                            player.getPlayer().setLayoutY(player.getPlayer().getLayoutY()-10);
                        }
                        else if(ke.getCode()==KeyCode.S){

                            player.getPlayer().setLayoutY(player.getPlayer().getLayoutY()+10);}


                        else if(ke.getCode()==KeyCode.M){

                            salto(values.saltoDerecha,1,values.derecha);

                            try {
                                //new Granade(root).start(primaryStage);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //Granade!!!!
                            //imageView.setLayoutY(imageView.getLayoutY()+10);
                        }

                        else if(ke.getCode()==KeyCode.N){

                            salto(values.saltoIzquierda,-1,values.izquierda);

                            try {
                                //new Granade(root).start(primaryStage);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            //Granade!!!!
                            //imageView.setLayoutY(imageView.getLayoutY()+10);
                        }
                    }

                }

        );

        //scenariosValues.root.getChildren().addAll(imageView);
        setGravedad();
        //return this;
    }

    private void salto(String[] pasos, int discriminante, String[] posicionFinal) {
        if (PlayerValuesRick.action){

            PlayerValuesRick.action=false;


            player.getPlayer().setImage(new Image(values.getClass().getResource(pasos[0]).toExternalForm()));

            for (int i=1;i<2;i++){


                //Movimiento en Y
                Thread thread2 = new Thread(()->{
                    for (int j =1;j<13;j++){
                        Gravedad.sleeping(25);
                        Platform.runLater(() -> player.getPlayer().setLayoutY(player.getPlayer().getLayoutY() - 10));
                        //}
                    }GameValues.gravedad=true;
                    g.setPosicionFinal(posicionFinal);


                    //imageView.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));

                });
                thread2.setDaemon(true);
                //thread.start();
                thread2.start();

            }}
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

}

