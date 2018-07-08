package models.elementos.explosivos.enemigos.dinero;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class dineroDatos {
    public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"bombaOmbDerecha.gif","bombaOmb.gif","Explocion.gif"};
    private String[] audio={"explosion3.WAV"};






    public String[] getVisual() {

        return visual;

    }

    public int[] getDimension() {
        return dimension;
    }

    public String[] getAudio() {  return audio;    }


}