package models.elementos.explosivos.granadas.congelacion;

/**
 * Created by LuisT23 on 8/7/2018.
 */
public class congelacionDatos {
    //public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"hielo.gif","hielo.gif","hielo2.gif","hielo2.gif"};
    private String [] audio={"efectoSonido.mp3","Explosion1.WAV"};
    private int daño=50;

    public String[] getVisual() {
        return visual;
    }
    public int[] getDimension() {
        return dimension;
    }
    public String[] getAudio() {
        return audio;
    }
    public int getDaño() {
        return daño;
    }
}