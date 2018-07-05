package models.player.escenarios.explosivos.granadas.holyGranade;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.player.PlayerRick.Gravedad;
import models.player.escenarios.explosivos.granadas.base.granada1;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public class holyGranade  extends granada1<granadaUno> {

    public holyGranade(granadaUno granda){
        granadaBase=granda;
        granadaEfecto=granadaBase.getVisual();
        dimensione=granadaBase.getDimension();
        implosion=new Media(this.getClass().getResource(granadaBase.getAudio()[1]).toExternalForm());
        implosionFinal=new Media(this.getClass().getResource(granadaBase.getAudio()[0]).toExternalForm());
        daño=granadaBase.getDaño();


        inicializar();
    }
    @Override
    protected void inicio() {
    }

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
