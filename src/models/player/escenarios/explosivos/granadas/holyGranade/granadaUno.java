package models.player.escenarios.explosivos.granadas.holyGranade;

public class granadaUno {
    public static String[] fases;
    private int[] dimension={50,50};
    private String[] visual={"granadaDivina.gif","granadaDivinaTiempo.gif","granadaDivinaExplocion.gif"};


    public String[] getVisual() {
        return visual;
    }

    public int[] getDimension() {
        return dimension;
    }
}
