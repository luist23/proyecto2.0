package models.player.escenarios.explosivos.enemigos.Base;

import javafx.scene.image.ImageView;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public interface roca <T> {

    void activar();
    ImageView getRoca();
    void explosion();
    Thread getUno();
    void setDaño(int daño);
    void setPausa(boolean pause);
    //void desactivar();

}
