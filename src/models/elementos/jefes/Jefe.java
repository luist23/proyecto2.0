package models.elementos.jefes;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public interface Jefe {
    javafx.scene.image.ImageView getJefe();

    int getVida();

    int getDaño();

    void setDaño(int daño);

    void setPausa(boolean pause);

}
