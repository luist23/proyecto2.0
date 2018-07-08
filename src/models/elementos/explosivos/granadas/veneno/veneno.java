package models.elementos.explosivos.granadas.veneno;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.escenarios.pantallaJuego.playScene;
import models.players.Player;

import java.util.ArrayList;

public class veneno extends models.elementos.explosivos.granadas.base.granadaBase<venenoDatos> {
    public veneno (venenoDatos granda){
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
        }
        return true;

    }
    @Override
    public void destruir() {
        Gravedad.sleeping(10);
        granada.setFitHeight(dimensione[0]*3);
        Gravedad.sleeping(10);
        granada.setLayoutY(granada.getLayoutY()-dimensione[0]*2);
        granada.setLayoutX(granada.getLayoutX()-dimensione[0]);
        Gravedad.sleeping(10);
        ArrayList<roca> destruidos=new ArrayList<>();

        try {
            for(int s=1;s<5;s++){
            for (roca r : playScene.getRocas()) {
                if (Gravedad.overlapingImageView(r.getRoca(), granada)) {
                    destruidos.add(r);
                    r.getRoca().setLayoutX(-300);
                }

            }

            for(roca d:destruidos){
                playScene.getRocas().remove(d);
                d.setDaño(daño);

            }
            destruidos.clear();
            if (Gravedad.overlapingImageView(granada, Player.getPlayer())) {
                Player.setDaño(daño);
            }
            if (Gravedad.overlapingImageView(Player.enemigo.getJefe(), Player.getPlayer())) {
                Player.enemigo.setDaño(daño);


            }}Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error en revision de enemigos");

        }
        finally {
            Gravedad.sleeping(1100);
            granada.setImage(null);
            granada.setLayoutX(-300);
        }
    }
}
