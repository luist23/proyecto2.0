package models.elementos.explosivos.granadas.holyGranade;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import models.controladores.Gravedad;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public class holyGranade  extends models.elementos.explosivos.granadas.base.granadaBase<holyGranadeDatos> {

    public holyGranade(holyGranadeDatos granda){
        granadaBase=granda;
        granadaEfecto=granadaBase.getVisual();
        dimensione=granadaBase.getDimension();
        daño=granadaBase.getDaño();

        implosion=new Media(this.getClass().getResource(granadaBase.getAudio()[0]).toExternalForm());
        implosionFinal=new Media(this.getClass().getResource(granadaBase.getAudio()[1]).toExternalForm());
        inicializar();
    }
    @Override
    protected void inicio() {}

    @Override
    protected boolean explotar(int i) {
        if(i==41){
            granada.setImage(new Image(this.getClass().getResource(granadaEfecto[1]).toExternalForm()));}
        if(i==120)
            player.play();
        if(i==190){
            Gravedad.sleeping(300);
            playerFinal.play();
            granada.setImage(new Image(this.getClass().getResource(granadaEfecto[2]).toExternalForm()));
            destruir();
            return false;
        }
        return true;

    }


}
