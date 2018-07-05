package models.player.escenarios.explosivos.enemigos.bombaOMG;

/**
 * Created by LuisT23 on 4/7/2018.
 */
public class rocaUno {
    public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"bombaOmbDerecha.gif","bombaOmb.gif","granadaDivinaExplocion.gif"};
    private String[] audio={"explosion3.WAV"};


    public String[] getVisual() {
        return visual;
    }

    public int[] getDimension() {
        return dimension;
    }

    public String[] getAudio() {  return audio;    }
}
