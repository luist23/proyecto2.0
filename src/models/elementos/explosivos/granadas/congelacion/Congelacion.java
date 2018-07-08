package models.elementos.explosivos.granadas.congelacion;

import javafx.scene.image.Image;
import javafx.scene.media.Media;
import models.controladores.GameValues;
import models.controladores.Gravedad;
import models.elementos.explosivos.enemigos.Base.roca;
import models.elementos.explosivos.granadas.base.granadaBase;
import models.elementos.explosivos.granadas.blackHole.blackHoleDatos;
import models.escenarios.pantallaJuego.playScene;
import models.players.Player;

import java.util.ArrayList;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class Congelacion extends granadaBase<congelacionDatos> {

    public Congelacion(congelacionDatos granda) {
        granadaBase = granda;

        granadaEfecto = granadaBase.getVisual();
        dimensione = granadaBase.getDimension();
        daño = granadaBase.getDaño();


        implosion = new Media(this.getClass().getResource(granadaBase.getAudio()[0]).toExternalForm());
        implosionFinal = new Media(this.getClass().getResource(granadaBase.getAudio()[1]).toExternalForm());
        inicializar();
    }

    @Override
    protected void inicio() {
    }

    @Override
    protected boolean explotar(int i) {
        if (i == 41) {
            granada.setImage(new Image(this.getClass().getResource(granadaEfecto[1]).toExternalForm()));

        }
        if (i == 60) {
            player.play();
            //granada.setImage(new Image(this.getClass().getResource(granadaEfecto[3]).toExternalForm()));
            Gravedad.sleeping(100);
            granada.setFitHeight(dimensione[0] * 3);
            granada.setLayoutY(granada.getLayoutY() - dimensione[0] * 2);
            granada.setLayoutX(granada.getLayoutX() - dimensione[0]);
            Gravedad.sleeping(100);
            //playerFinal.play();
            granada.setImage(new Image(this.getClass().getResource(granadaEfecto[2]).toExternalForm()));
            destruir();
            return false;
        }
        return true;

    }

    @Override
    public void destruir() {

        ArrayList<roca> destruidos = new ArrayList<>();


        try {
            if (true) {
                for (roca r : playScene.getRocas()) {
                    if (Gravedad.overlapingImageView(r.getRoca(), granada)) {
                        destruidos.add(r);
                        r.setPausa(true);
                        //r.getRoca().setLayoutX(granada.getLayoutX()+70);
                        //r.getRoca().setLayoutY(granada.getLayoutY()+50);
                    }

                }
                if (Gravedad.overlapingImageView(granada, Player.enemigo.getJefe())) {
                    Player.enemigo.setPausa(true);
                }
                Thread.sleep(6000);
                for (roca d : destruidos) {
                    //d.getRoca().setLayoutX(-500);
                    //playScene.getRocas().remove(d);
                    d.setPausa(false);
                    //System.out.println("dañebombablckhole");

                }Thread.sleep(100);
                Player.enemigo.setPausa(false);
                Thread.sleep(100);
                destruidos.clear();

            }

        } catch (Exception e) {
            System.out.println("error en revision de enemigos");

        } finally {
            Gravedad.sleeping(100);
            player.stop();
            granada.setImage(null);
            granada.setLayoutX(-300);
        }
    }

}