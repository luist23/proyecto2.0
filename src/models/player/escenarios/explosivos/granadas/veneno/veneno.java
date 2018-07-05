package models.player.escenarios.explosivos.granadas.veneno;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import models.player.PlayerRick.Gravedad;
import models.player.escenarios.explosivos.granadas.base.granada1;
import models.player.escenarios.explosivos.granadas.holyGranade.granadaUno;

public class veneno extends granada1<venenoDatos> {
    public veneno (venenoDatos granda){
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
            granada.setImage(new Image(this.getClass().getResource(granadaEfecto[1]).toExternalForm()));}//aqui es cuando cae
        if(i==120)
            player.play();//cada cierto tiempo suena aleluya antes de explotar
        if(i==190){

            Gravedad.sleeping(300);
            playerFinal.play();//sonido explocion
            granada.setImage(new Image(this.getClass().getResource(granadaEfecto[2]).toExternalForm()));//explotando, la imagen
            for(int k=1;k<5;k++){
                destruir();//dañando, esa funcion buscatodo lo que toca el elemento,en el hielo en lugar de esto pongo set pause==true
                Gravedad.sleeping(500);//retraso para daño

            }

            //Gravedad.sleeping(1100);
            granada.setImage(null);
            return false;
        };        return true;

    }
}
