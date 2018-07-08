/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tienda.tienda;

import Tienda.imagenes.TiendaM;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static models.players.Player.dinero;

/**
 *
 * @author marym
 */
public class Tienda extends Application {
    private Label btnVida,btnHabilidad, btnArma;
    private Pane root;
    private HBox boxMenu, boxRecursos, boxInfoSuperior;
    private VBox vboxMenu, vboxRecursos,vboxInfoSuperior;
    private Image imgF, imgM1, imgM2,imgM3, imgM4,imgR1, imgR2, imgR3;
    private ImageView imgViewF,imgViewM1,imgViewM2,imgViewM3, imgViewM4,imgViewR1,imgViewR2,imgViewR3;
    private int altoventana,anchoVentana;
    public static TextField infoDinero, infoArma, infoVida;
    public static Stage Ventana;
    
    @Override
    public void start(Stage Ventana) {
        this.Ventana= Ventana;
        
        anchoVentana=1010;
        altoventana=650;
        
        imgF= new Image("Tienda/imagenes/imgF.png");
        imgViewF = new ImageView(imgF);
        imgViewF.setFitHeight(altoventana);
        imgViewF.setFitWidth(anchoVentana);
        
         //***MENU......M ***
        
        imgM1 = new Image ("Tienda/imagenes/Arma_1.png");
        imgViewM1 =new ImageView(imgM1);
        imgViewM1.setFitHeight(70);
        imgViewM1.setFitWidth(77);
        imgViewM1.setPreserveRatio(false);
        
        imgM2= new Image(TiendaM.getInstance().getClass()
                .getResource("c2.png").toExternalForm());
        imgViewM2 =new ImageView(imgM2);
        imgViewM2.setFitHeight(70);
        imgViewM2.setFitWidth(60);
        imgViewM2.setPreserveRatio(false);
        
        imgM3= new Image(TiendaM.getInstance().getClass()
                .getResource("Estrella.png").toExternalForm());
        imgViewM3 =new ImageView(imgM3);
        imgViewM3.setFitHeight(63);
        imgViewM3.setFitWidth(70);
        imgViewM3.setPreserveRatio(false);
        
        imgM4= new Image(TiendaM.getInstance().getClass()
                .getResource("fire.png").toExternalForm());
        imgViewM4 =new ImageView(imgM4);
        imgViewM4.setFitHeight(63);
        imgViewM4.setFitWidth(80);
        imgViewM4.setPreserveRatio(false);
        
        
        boxMenu=new HBox();
        boxMenu.setSpacing(8);
        boxMenu.getChildren().addAll(imgViewM1,imgViewM2, imgViewM3, imgViewM4);
  
        vboxMenu= new VBox();
        vboxMenu.setSpacing(10);
        vboxMenu.setLayoutX(anchoVentana-345);
        vboxMenu.setLayoutY(altoventana-268);
        vboxMenu.getChildren().addAll(boxMenu);
   
        //Aciones del Boton
        imgViewM1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
              
                
            }
        });
        
        imgViewM2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                //****INFORMACION ****
                //infoVida=new TextField();
            }
        });
        
        imgViewM3.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                
                System.out.println("btn 3");
            }
        });
        
        imgViewM4.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                
                System.out.println("btn 4");
            }
        });
        
        
         //****INFORMACION SUPERIOR****
        infoDinero=new TextField();
        infoDinero.setText(dinero);
        infoDinero.setMaxWidth(70);
        infoDinero.setDisable(true);
        
        infoArma=new TextField();
        infoArma.setText("Arma");
        infoArma.setMaxWidth(70);
        infoArma.setDisable(true);
        
        infoVida=new TextField();
        infoVida.setText("Vida");
        infoVida.setMaxWidth(70);
        infoVida.setDisable(true);
        
        boxInfoSuperior=new HBox();
        boxInfoSuperior.setSpacing(80);
        boxInfoSuperior.getChildren().addAll(infoDinero, infoArma,infoVida);
  
        vboxInfoSuperior= new VBox();
        vboxInfoSuperior.setSpacing(30);
        vboxInfoSuperior.setLayoutX(anchoVentana-400);
        vboxInfoSuperior.setLayoutY(altoventana- 620);
        vboxInfoSuperior.getChildren().addAll(boxInfoSuperior);
    
        
        //*** RECURSOS .......R ***
        
        imgR1 = new Image (TiendaM.getInstance().getClass()
                .getResource("Dinero.gif").toExternalForm());
        imgViewR1 =new ImageView(imgR1);
        imgViewR1.setFitHeight(50);
        imgViewR1.setFitWidth(140);
        imgViewR1.setPreserveRatio(false);
        
        imgR2 = new Image (TiendaM.getInstance().getClass()
                .getResource("Granade.png").toExternalForm());
        imgViewR2 =new ImageView(imgR2);
        imgViewR2.setFitHeight(50);
        imgViewR2.setFitWidth(140);
        imgViewR2.setPreserveRatio(false);
        
        imgR3 = new Image (TiendaM.getInstance().getClass()
                .getResource("life.png").toExternalForm());
        imgViewR3 =new ImageView(imgR3);
        imgViewR3.setFitHeight(50);
        imgViewR3.setFitWidth(140);
        imgViewR3.setPreserveRatio(false);
        
        boxRecursos=new HBox();
        boxRecursos.setSpacing(5);
        boxRecursos.getChildren().addAll(imgViewR1, imgViewR2,imgViewR3);
  
        vboxRecursos= new VBox();
        vboxRecursos.setSpacing(10);
        vboxRecursos.setLayoutX(anchoVentana-450);
        vboxRecursos.setLayoutY(altoventana- 630);
        vboxRecursos.getChildren().addAll(boxRecursos);
        
        
       
        //ventana
        root = new Pane(imgViewF);
        root.getChildren().addAll(vboxMenu,vboxRecursos,vboxInfoSuperior);
    
        Scene s = new Scene(root, anchoVentana, altoventana);
        Ventana.setScene(s);
        Ventana.setTitle("Tienda");
        Ventana.show();
       
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
