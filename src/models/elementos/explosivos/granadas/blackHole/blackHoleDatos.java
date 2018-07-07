package models.elementos.explosivos.granadas.blackHole;

/**
 * Created by LuisT23 on 7/7/2018.
 */
public class blackHoleDatos {
    //public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"blackHoleLanzar.gif","blackHoleSuelo.gif","ejecucion.gif"};
    private String [] audio={"HOLYGRENADE.WAV","Explosion1.WAV"};
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
