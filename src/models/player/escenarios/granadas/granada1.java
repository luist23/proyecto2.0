package models.player.escenarios.granadas;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import models.player.GameValues;
import models.player.PlayerRick.Gravedad;
import models.player.PlayerRick.Player;
import models.player.peldannos.Peldanno;

public class granada1 implements granada <granadaUno>{
    public static String[] granadaEfecto;
    ImageView granada = new ImageView();

    public granada1(){
        granadaEfecto=new String[]{"Rick_corriendo_1.png","Rick_corriendo_2_derecha.png"};
        granada.setLayoutX(Player.getPlayer().getLayoutX());
        granada.setLayoutY(Player.getPlayer().getLayoutY());
        granada.setFitHeight(50);

        granada.setPreserveRatio(true);
        activar();



    }

    @Override
    public void activar() {
        granada.setImage(new Image(this.getClass().getResource(granadaEfecto[0]).toExternalForm()));
        Player.getRoot().getChildren().addAll(granada);
        Thread uno = new Thread(()->{

            for (int i=1 ; i<15;i++){
                //GameValues.permitirSalto=false;

                Platform.runLater(() -> granada.setLayoutY(granada.getLayoutY() - 10));
                Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() + 5));
                Gravedad.sleeping(25);
                //}
            }
            int tiempoExplosion=1;
            boolean explosion=true;
            while(Gravedad.efectoGravedad(granada)){

                if((GameValues.dimension[1] - granadaUno.dimension[1]) > granada.getLayoutY() || Gravedad.efectoGravedad(granada)){



                    if (GameValues.dimension[0] - granadaUno.dimension[0] > granada.getLayoutX()){
                        Platform.runLater(() -> granada.setLayoutX(granada.getLayoutX() +
                                5));
                    }
                    Platform.runLater(() -> granada.setLayoutY(granada.getLayoutY() +
                            5));

                }

                tiempoExplosion++;
            Gravedad.sleeping(25);
                System.out.println(tiempoExplosion);

                if (tiempoExplosion>40){
                    explosion=false;
                    explosion();
                    break;
                }




        }


            Gravedad.sleeping(2500);
            if (explosion)
            explosion();


            //g.setPosicionFinal(posicionFinal);


            //imageView.setImage(new Image(values.getClass().getResource(posicionFinal[0]).toExternalForm()));

        });
        uno.setDaemon(true);
        //thread.start();
        uno.start();
    }

    @Override
    public ImageView getGranada() {
        return null;
    }

    public void explosion(){

        granada.setImage(new Image(this.getClass().getResource(granadaEfecto[1]).toExternalForm()));
        Gravedad.sleeping(200);

        //granada.relocate(-25,-25);

        granada.setImage(null);
    }


}
