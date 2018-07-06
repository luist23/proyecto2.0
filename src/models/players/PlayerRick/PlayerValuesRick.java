package models.players.PlayerRick;

public class PlayerValuesRick {

    public static int[] sizePlayer= {40,40};
    public static int distanciaPaso=5;
    public static int pasosTotales=4;
    public static int tiempoPaso=300;
    public static boolean action=true;

    public static String[] derecha={"Rick_derecha.png"};
    public static String[] pasoDerecha={"Rick_corriendo_derecha.png","Rick_corriendo_3_derecha.png",
            "Rick_corriendo_2_derecha.png","Rick_corriendo_1_derecha.png"};
    public static String[] saltoDerecha={"Rick_salto_1_derecha.png"};


    public static String[] izquierda={"Rick.png"};
    public static String[] pasoIzquierda={"Rick_corriendo.png","Rick_corriendo_3.png",
            "Rick_corriendo_2.png","Rick_corriendo_1.png"};
    public static String[] saltoIzquierda={"Rick_salto_1.png"};




    private static PlayerValuesRick ourInstance = new PlayerValuesRick();
    public static PlayerValuesRick getInstance() {
        return ourInstance;
    }
    private PlayerValuesRick() {    }



}
