package models.elementos.explosivos.granadas.veneno;

public class venenoDatos {
    //public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"veneno.gif","veneno.gif","venenoF.gif"};
    private int daño=15;
    private String [] audio={"HOLYGRENADE.WAV","Explosion1.WAV"};


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
