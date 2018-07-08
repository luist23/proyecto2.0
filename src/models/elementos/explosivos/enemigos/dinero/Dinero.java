package models.elementos.explosivos.enemigos.dinero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.rocaGigante;
import models.elementos.explosivos.enemigos.bombaOMG.bombaOMBdatos;
import models.players.Player;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class Dinero extends rocaGigante<bombaOMBdatos> {
    //private bombaOMBdatos gran;

    public Dinero(bombaOMBdatos roca){
        //super();
        this.roca= new ImageView();
        gran=roca;
        inicio();
        inicializar();

    }

    @Override
    public void inicio() {
        rocaEfecto =gran.getVisual();
        roca.setFitHeight(gran.getDimension()[0]);
        dimensione=gran.getDimension();
        implosionFinal=new Media(this.getClass().getResource(gran.getAudio()[0]).toExternalForm());
        poder=0;
    }
    @Override
    public void explosion(){
        vida=false;
        Thread explosion= new Thread(()->{
            Gravedad.sleeping(10);
            roca.setImage(new Image(this.getClass().getResource(rocaEfecto[2]).toExternalForm()));
            playerFinal.play();
            Gravedad.sleeping(1400);
            Player.dinero+=25;
            Player.textVida.setText("$$$:  "+Player.dinero);
            //lebel.setText(String.valueOf(totalVida));
            roca.setImage(null);
        });
        explosion.setDaemon(true);
        explosion.start();
    }



}