package models.elementos.explosivos.enemigos.Base;

import javafx.scene.image.ImageView;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public interface roca <T> {

    void activar();
    ImageView getRoca();
    void explosion();
    //Thread getUno();
    void setDaño(int daño);
    void setPausa(boolean pause);
    /*void pausar();
    void resume();*/
    //void desactivar();

}