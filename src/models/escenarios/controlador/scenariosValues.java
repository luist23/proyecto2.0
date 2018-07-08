package models.escenarios.controlador;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class scenariosValues {
    private static scenariosValues values;
    public static Stage primaryStage;
    //public static Group root;
    public static scenariosValues getInstance(){
        return values;
    }



    public static void setPrimaryStage(Stage primaryStages){
        primaryStage=primaryStages;
    }
    public static void addPrimaryStage(Scene scene) {
        primaryStage.setScene(scene);

    }
   // public static void setRoot(Group roots){root=roots;}
}
