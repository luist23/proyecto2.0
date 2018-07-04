package models.player.escenarios.explosivos.granadas.veneno;

public class venenoDatos {
    public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"granadaDivina.gif","granadaDivinaTiempo.gif","granadaDivinaExplocion.gif"};
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
