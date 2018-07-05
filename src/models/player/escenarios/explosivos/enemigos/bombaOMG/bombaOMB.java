package models.player.escenarios.explosivos.enemigos.bombaOMG;

import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import models.player.escenarios.explosivos.enemigos.Base.rocaGigante;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public class bombaOMB extends rocaGigante <rocaUno> {
    //private rocaUno gran;

    public bombaOMB(rocaUno roca){
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
    }

}
