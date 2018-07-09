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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import models.controladores.GameValues;
import models.controladores.scenariosValues;
import models.escenarios.factory.ScenesType;
import models.escenarios.factory.sceneFactory;
import models.players.Player;
import static models.players.Player.dinero;
import static models.players.Player.vida;
import models.players.factory.playerFactory;

/**
 *
 * @author marym
 */
public class Tienda extends Scene {
    //private Label btnVida,btnHabilidad, btnArma;
    private static boolean juego=true;
    private Pane root;
    private HBox boxMenu, boxRecursos, boxInfoSuperior,boxInfoArma,boxInfoVida, boxInfoPoder, boxInfoEspecial, boxOpcion;
    private VBox vboxMenu, vboxRecursos,vboxInfoSuperior, vboxInfoArma, vboxInfoVida, vboxInfoPoder, vboxInfoEspecial, vboxOpcion;
    private Image imgF, imgM1, imgM2,imgM3, imgM4,imgR1, imgR2, imgR3, imgA1, imgA2, imgA3, imgA4, imgV1, imgV2, imgV3, imgContinuar, imgRegreso, imgP1;
    private ImageView imgViewF,imgViewM1,imgViewM2,imgViewM3, imgViewM4,imgViewR1,imgViewR2,imgViewR3, imgViewA1, imgViewA2, imgViewA3, imgViewA4, imgViewV1, imgViewV2, imgViewV3, imgViewContinuar, imgViewRegreso, imgViewP1;
    private static int altoventana=650,anchoVentana=1010;
    public static TextField infoDinero, infoArma, infoVida, infoA, infoV, infoP, infoE;
    public static Stage Ventana;

    public Tienda(Pane root){
        super(root, anchoVentana,altoventana);
        this.root=root;
        start();

    }
    
    public int Compra (int Precio,int Dinero){

        if (Player.dinero>=Precio){
            Player.dinero-= Precio;
        }
        else{
            System.out.println(" no tienes dinero :(");
        }
        return Dinero; 
    }

    public void start() {
        
        this.Ventana= scenariosValues.primaryStage;
        
        
        imgF= new Image("Tienda/imagenes/imgF.png");
        imgViewF = new ImageView(imgF);
        imgViewF.setFitHeight(altoventana);
        imgViewF.setFitWidth(anchoVentana);
        
        root = new Pane(imgViewF);    
        
         //*** INFORMACION SUPERIOR ***//
        infoDinero=new TextField();
        infoDinero.setText(" "+dinero);
        infoDinero.setMaxWidth(70);
        infoDinero.setDisable(true);
        
        infoArma=new TextField();
        infoArma.setText("Arma");
        infoArma.setMaxWidth(70);
        infoArma.setDisable(true);
        
        infoVida=new TextField();
        infoVida.setText(""+vida);
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
    
        //*** RECURSOS .......R ***//
        
        //DINERO
        imgR1 = new Image (TiendaM.getInstance().getClass()
                .getResource("Dinero.gif").toExternalForm());
        imgViewR1 =new ImageView(imgR1);
        imgViewR1.setFitHeight(50);
        imgViewR1.setFitWidth(140);
        imgViewR1.setPreserveRatio(false);
        
        //ARMAS
        imgR2 = new Image (TiendaM.getInstance().getClass()
                .getResource("Granade.png").toExternalForm());
        imgViewR2 =new ImageView(imgR2);
        imgViewR2.setFitHeight(50);
        imgViewR2.setFitWidth(140);
        imgViewR2.setPreserveRatio(false);
        
        //VIDA
        imgR3 = new Image (TiendaM.getInstance().getClass()
                .getResource("life.png").toExternalForm());
        imgViewR3 =new ImageView(imgR3);
        imgViewR3.setFitHeight(50);
        imgViewR3.setFitWidth(140);
        imgViewR3.setPreserveRatio(false);
        
        //VBOX AND HBOX ......RECURSOS
        boxRecursos=new HBox();
        boxRecursos.setSpacing(5);
        boxRecursos.getChildren().addAll(imgViewR1, imgViewR2,imgViewR3);
  
        vboxRecursos= new VBox();
        vboxRecursos.setSpacing(10);
        vboxRecursos.setLayoutX(anchoVentana-450);
        vboxRecursos.setLayoutY(altoventana- 630);
        vboxRecursos.getChildren().addAll(boxRecursos);
        
        
         //***MENU......M ***//
        
        //ARMA
        imgM1 = new Image ("Tienda/imagenes/Arma_1.png");
        imgViewM1 =new ImageView(imgM1);
        imgViewM1.setFitHeight(70);
        imgViewM1.setFitWidth(77);
        imgViewM1.setPreserveRatio(false);
        
        //VIDA
        imgM2= new Image(TiendaM.getInstance().getClass()
                .getResource("c2.png").toExternalForm());
        imgViewM2 =new ImageView(imgM2);
        imgViewM2.setFitHeight(70);
        imgViewM2.setFitWidth(60);
        imgViewM2.setPreserveRatio(false);
        
        //PODER
        imgM3= new Image(TiendaM.getInstance().getClass()
                .getResource("Estrella.png").toExternalForm());
        imgViewM3 =new ImageView(imgM3);
        imgViewM3.setFitHeight(63);
        imgViewM3.setFitWidth(70);
        imgViewM3.setPreserveRatio(false);
        
        //ESPECIALIDAD
        imgM4= new Image(TiendaM.getInstance().getClass()
                .getResource("fire.png").toExternalForm());
        imgViewM4 =new ImageView(imgM4);
        imgViewM4.setFitHeight(63);
        imgViewM4.setFitWidth(80);
        imgViewM4.setPreserveRatio(false);
        
        //VBOX AND HBOX.....MENU
        boxMenu=new HBox();
        boxMenu.setSpacing(8);
        boxMenu.getChildren().addAll(imgViewM1,imgViewM2, imgViewM3, imgViewM4);
  
        vboxMenu= new VBox();
        vboxMenu.setSpacing(10);
        vboxMenu.setLayoutX(anchoVentana-345);
        vboxMenu.setLayoutY(altoventana-268);
        vboxMenu.getChildren().addAll(boxMenu);
              
        //ACCIONES BOTON//
        infoA = new TextField();
        infoV = new TextField();
        infoP = new TextField();
        infoE = new TextField();
       
        //BTN 1
        imgViewM1.setOnMouseClicked((MouseEvent event) -> {
            root.getChildren().remove(vboxInfoVida);
            root.getChildren().remove(vboxInfoPoder);
            root.getChildren().remove(vboxInfoEspecial);
            
            imgA1= new Image(TiendaM.getInstance().getClass()
                .getResource("Arma1.png").toExternalForm());
            imgViewA1 =new ImageView(imgA1);
            imgViewA1.setFitHeight(55);
            imgViewA1.setFitWidth(350);
            imgViewA1.setPreserveRatio(false);
            
            imgA2= new Image(TiendaM.getInstance().getClass()
                .getResource("Arma2.png").toExternalForm());
            imgViewA2 =new ImageView(imgA2);
            imgViewA2.setFitHeight(55);
            imgViewA2.setFitWidth(350);
            imgViewA2.setPreserveRatio(false);
            
            imgA3= new Image(TiendaM.getInstance().getClass()
                .getResource("Arma3.png").toExternalForm());
            imgViewA3 =new ImageView(imgA3);
            imgViewA3.setFitHeight(55);
            imgViewA3.setFitWidth(350);
            imgViewA3.setPreserveRatio(false);
            
            imgA4= new Image(TiendaM.getInstance().getClass()
                .getResource("Arma4.png").toExternalForm());
            imgViewA4 =new ImageView(imgA4);
            imgViewA4.setFitHeight(55);
            imgViewA4.setFitWidth(350);
            imgViewA4.setPreserveRatio(false);
     
 
            vboxInfoArma= new VBox();
            vboxInfoArma.setSpacing(20);
            vboxInfoArma.setLayoutX(anchoVentana-920);
            vboxInfoArma.setLayoutY(altoventana-500);
            vboxInfoArma.getChildren().addAll(imgViewA1, imgViewA2, imgViewA3, imgViewA4);
            
            root.getChildren().add(vboxInfoArma);
    
        });
        
        //BTN2
        imgViewM2.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            root.getChildren().remove(vboxInfoArma);
            root.getChildren().remove(vboxInfoPoder);
            root.getChildren().remove(vboxInfoEspecial);
            
            
            imgV1= new Image(TiendaM.getInstance().getClass()
                .getResource("Vida50.png").toExternalForm());
            imgViewV1 =new ImageView(imgV1);
            imgViewV1.setFitHeight(55);
            imgViewV1.setFitWidth(350);
            imgViewV1.setPreserveRatio(false);
            imgViewV1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    int DineroT= Compra(100,dinero);
                    infoDinero.setText(" " + DineroT);
                    int VidaT =vida +50;
                    infoVida.setText(""+VidaT);
                    
              
                }
            });
  
            imgV2= new Image(TiendaM.getInstance().getClass()
                .getResource("Vida100.png").toExternalForm());
            imgViewV2 =new ImageView(imgV2);
            imgViewV2.setFitHeight(55);
            imgViewV2.setFitWidth(350);
            imgViewV2.setPreserveRatio(false);
            imgViewV2.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    int DineroT= Compra(200,dinero);
                    infoDinero.setText("" + DineroT);
                    int VidaT =vida +100;
                    infoVida.setText(""+VidaT);
                }
            });
            
            imgV3= new Image(TiendaM.getInstance().getClass()
                .getResource("Vida200.png").toExternalForm());
            imgViewV3 =new ImageView(imgV3);
            imgViewV3.setFitHeight(55);
            imgViewV3.setFitWidth(350);
            imgViewV3.setPreserveRatio(false);
            imgViewV3.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    int DineroT= Compra(300,dinero);
                    System.out.println(DineroT);
                    infoDinero.setText("" + DineroT);
                    int VidaT =vida +200;
                    infoVida.setText(""+VidaT);
                }
            });
           
            vboxInfoVida= new VBox();
            vboxInfoVida.setSpacing(20);
            vboxInfoVida.setLayoutX(anchoVentana-920);
            vboxInfoVida.setLayoutY(altoventana-500);
            vboxInfoVida.getChildren().addAll(imgViewV1, imgViewV2, imgViewV3);
           
            root.getChildren().add(vboxInfoVida);
        });
        
        //BTN3
        imgViewM3.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            root.getChildren().remove(vboxInfoArma);
            root.getChildren().remove(vboxInfoVida);
            root.getChildren().remove(vboxInfoEspecial);
            
            imgP1= new Image(TiendaM.getInstance().getClass()
                .getResource("Laser.png").toExternalForm());
            imgViewP1 =new ImageView(imgP1);
            imgViewP1.setFitHeight(55);
            imgViewP1.setFitWidth(350);
            imgViewP1.setPreserveRatio(false);
            imgViewP1.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
               
                }
            });
            
            vboxInfoPoder= new VBox();
            vboxInfoPoder.setSpacing(20);
            vboxInfoPoder.setLayoutX(anchoVentana-920);
            vboxInfoPoder.setLayoutY(altoventana-500);
            vboxInfoPoder.getChildren().addAll(imgViewP1);
  
            root.getChildren().add(vboxInfoPoder);
        });
        
        //BTN4
        imgViewM4.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            root.getChildren().remove(vboxInfoArma);
            root.getChildren().remove(vboxInfoVida);
            root.getChildren().remove(vboxInfoPoder);
        
            boxInfoEspecial=new HBox();
            boxInfoEspecial.setSpacing(8);
            boxInfoEspecial.getChildren().addAll(infoE);

            vboxInfoEspecial= new VBox();
            vboxInfoEspecial.setSpacing(10);
            vboxInfoEspecial.setLayoutX(anchoVentana-600);
            vboxInfoEspecial.setLayoutY(altoventana-100);
            vboxInfoEspecial.getChildren().addAll(boxInfoEspecial);
            
            boxInfoEspecial=new HBox();
            boxInfoEspecial.setSpacing(8);
            boxInfoEspecial.getChildren().addAll(infoE);

             
            root.getChildren().add(vboxInfoEspecial);
            
        });
        
        //Botones de Regresar y continuar
                    
        imgRegreso= new Image(TiendaM.getInstance().getClass()
            .getResource("no.png").toExternalForm());
        imgViewRegreso =new ImageView(imgRegreso);
        imgViewRegreso.setFitHeight(80);
        imgViewRegreso.setFitWidth(80);
        imgViewRegreso.setPreserveRatio(false);
        
        imgContinuar= new Image(TiendaM.getInstance().getClass()
            .getResource("si.png").toExternalForm());
        imgViewContinuar =new ImageView(imgContinuar);
        imgViewContinuar.setFitHeight(80);
        imgViewContinuar.setFitWidth(80);
        imgViewContinuar.setPreserveRatio(false);
        
        boxOpcion=new HBox();
        boxOpcion.setSpacing(750);
        boxOpcion.getChildren().addAll(imgViewRegreso, imgViewContinuar);

        vboxOpcion= new VBox();
        vboxOpcion.setSpacing(10);
        vboxOpcion.setLayoutX(anchoVentana-950);
        vboxOpcion.setLayoutY(altoventana-100);
        vboxOpcion.getChildren().addAll(boxOpcion);
        
        //Accion de los botones de regreso y continuar
        //btn Regreso
        imgViewRegreso.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            sceneFactory.getScene(ScenesType.MENUSELECCION);
        });
        

        //btn Continuar
        imgViewContinuar.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            sceneFactory.getScene(ScenesType.PLAYSCENE);
        });
        
   
        //*** VENTANA **//
        root.getChildren().addAll(vboxMenu,vboxRecursos,vboxInfoSuperior,vboxOpcion);
    
        Scene s = new Scene(root, anchoVentana, altoventana);
        scenariosValues.primaryStage.setScene(s);
    
    }

    //public static void main(String[] args) {        launch(args);    }
    
}
