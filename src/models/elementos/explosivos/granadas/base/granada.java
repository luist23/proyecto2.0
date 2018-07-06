package models.elementos.explosivos.granadas.base;

import javafx.scene.image.ImageView;

public interface granada <T>{

    //Media implosion=null;

    void activar();
    ImageView getGranada();
    boolean explosion(int i);
    void destruir();

}
