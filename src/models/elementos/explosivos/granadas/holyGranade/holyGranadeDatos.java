package models.elementos.explosivos.granadas.holyGranade;

public class holyGranadeDatos {
    //public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"granadaDivina.gif","granadaDivinaTiempo.gif","granadaDivinaExplocion.gif"};
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
