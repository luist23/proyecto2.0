package models.controladores;

import javafx.stage.Stage;

public class GameValues {

    public static int[] dimension={1280,720};
    public static boolean gravedad=true;
    public static boolean permitirSalto =true;
    public static int direccion=1;
    private static Gravedad gravedadThread;
    //public  static Stage primaryStage;
    public static int alturaNivel=0;


    private static GameValues ourInstance = new GameValues();
    public static GameValues getInstance() {
        return ourInstance;
    }
    private GameValues() {}
    public static Gravedad getGravedadThread() {
        return gravedadThread;
    }

    public static void setGravedadThread(Gravedad gravedad) {
        GameValues.gravedadThread = gravedad;
    }
}
