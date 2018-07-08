package menuSeleccion;

import Tienda.tienda.Tienda;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.controladores.GameValues;
import models.controladores.scenariosValues;
import models.escenarios.factory.ScenesType;
import models.escenarios.factory.sceneFactory;
import models.players.Player;
import models.players.factory.playerType;


public class MenuSect extends Scene {
    private int width =1080;int height =720; // se crean las dimensiones de la ventana
    private Pane root  = new Pane();


    public MenuSect(Pane root){
    super(root, GameValues.dimension[0],GameValues.dimension[1]);
    this.root=root;
        scenariosValues.primaryStage.setScene(this);

        content();
    }

    public void content(){
        //Pane root  = new Pane();

        //Scene scene = new Scene(root,width,height);
        HBox contenedorPersonajes=new HBox(); // para colocar las imagenes en horizontal
        VBox boxVertica=new VBox(); // para colocar las imagenes  en vertical
        contenedorPersonajes.setSpacing(25);
        contenedorPersonajes.setAlignment(Pos.CENTER);
        boxVertica.setLayoutX((GameValues.dimension[0]/2)-285);
        boxVertica.setLayoutY((height/2)-280);
        boxVertica.setAlignment(Pos.CENTER);
        //boxVertica.setSpacing(0);
        HBox boxfinal=new HBox();

        ImageView seleccionado=new ImageView(); // para mostrar imagen
        seleccionado.setPreserveRatio(true);
        seleccionado.setFitWidth(90); // para cambiar el tamaño de la imagen

        ImageView seleccionadoFondo=new ImageView(); // para mostrar imagen
        seleccionadoFondo.setPreserveRatio(true);
        seleccionadoFondo.setFitWidth(90); // para cambiar el tamaño de la imagen
//--------------------------------------boton play
        ImageView siguiente=new ImageView(new Image(this.getClass().getResource("play.png").toExternalForm())); // para mostrar imagen
        siguiente.setPreserveRatio(true);
        siguiente.setFitWidth(90); // para cambiar el tamaño de la imagen
        siguiente.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                //seleccionado.setImage(new Image(this.getClass().getResource("play.png").toExternalForm()));
                //seleccionadoFondo.setImage(new Image(this.getClass().getResource("select2.png").toExternalForm()));
                System.out.println("play");
                sceneFactory.getScene(ScenesType.PLAYSCENE);


                //Tienda menu=new Tienda();
                //ventanaP.menuP.main(primaryStage);
                //primaryStage.close();

            }
        });

        ImageView tienda=new ImageView(new Image(this.getClass().getResource("tienda.png").toExternalForm())); // para mostrar imagen
        tienda.setPreserveRatio(true);
        tienda.setFitWidth(90); // para cambiar el tamaño de la imagen

        //boxfinal.setAlignment(Pos.TOP_LEFT);
        boxfinal.getChildren().addAll(tienda,siguiente);
        boxfinal.setLayoutX(45);
        boxfinal.setLayoutY(height-110);
        boxfinal.setSpacing(GameValues.dimension[0]-270);


        //primaryStage.setTitle("JavaFx");
        ImageView imagenMario=new ImageView();
        imagenMario.setFitWidth(100);
        imagenMario.setPreserveRatio(true);
        imagenMario.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() { // cuando se le da clic a la imagen
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Player.personaje= playerType.MARIO;
                //System.out.println(";v");
                seleccionado.setImage(new Image(this.getClass().getResource("mario1.png").toExternalForm())); // se coloca imagen que quiere que aparezca
                seleccionadoFondo.setImage(new Image(this.getClass().getResource("select2.png").toExternalForm()));
            }
        });

        imagenMario.setImage(new Image(this.getClass().getResource("boton mario.png ").toExternalForm())); // para colocar otra imagen cuando se le da clic a la imagen anterior

        ImageView imagenPeach=new ImageView();
        imagenPeach.setFitWidth(100);
        imagenPeach.setPreserveRatio(true);
        imagenPeach.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Player.personaje= playerType.PEACH;
                seleccionado.setImage(new Image(this.getClass().getResource("peach.png").toExternalForm()));
                seleccionadoFondo.setImage(new Image(this.getClass().getResource("select2.png").toExternalForm()));
                //System.out.println("XD");
            }
        });

        imagenPeach.setImage(new Image(this.getClass().getResource("botonPeach.png").toExternalForm())); // para colocar otra imagen cuando se le da clic a la imagen anterior


        ImageView imagenGoku=new ImageView();
        imagenGoku.setFitWidth(100);
        imagenGoku.setPreserveRatio(true);
        imagenGoku.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Player.personaje= playerType.GOKU;
                seleccionado.setImage(new Image(this.getClass().getResource("goku2.png").toExternalForm()));
                seleccionadoFondo.setImage(new Image(this.getClass().getResource("select2.png").toExternalForm()));
                //System.out.println("goku");
            }
        });

        imagenGoku.setImage(new Image(this.getClass().getResource("botonGoku.png").toExternalForm()));

        ImageView ImagenMarco=new ImageView();
        ImagenMarco.setFitWidth(100);
        ImagenMarco.setPreserveRatio(true);
        ImagenMarco.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Player.personaje= playerType.MARCO;
                seleccionado.setImage(new Image(this.getClass().getResource("marco1.png").toExternalForm()));
                seleccionadoFondo.setImage(new Image(this.getClass().getResource("select2.png").toExternalForm()));
                //System.out.println("XD");
            }
        });

        ImagenMarco.setImage(new Image(this.getClass().getResource("botonMarco.png").toExternalForm()));

        ImageView imagenRick=new ImageView();
        imagenRick.setFitWidth(100);
        imagenRick.setPreserveRatio(true);
        imagenRick.setOnMouseClicked(new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent event) {
                Player.personaje= playerType.RICK;
                seleccionado.setImage(new Image(this.getClass().getResource("rick.png").toExternalForm()));
                seleccionadoFondo.setImage(new Image(this.getClass().getResource("select2.png").toExternalForm()));
                //System.out.println("XD");
            }
        });

        imagenRick.setImage(new Image(this.getClass().getResource("botonPepino.png").toExternalForm()));




        ImageView fondo = new ImageView();
        fondo.setFitHeight(height);
        fondo.setFitWidth(width);
        fondo.setImage(new Image(this.getClass().getResource("H.jpg").toExternalForm()));







        contenedorPersonajes.getChildren().addAll(imagenMario,imagenPeach,imagenGoku,ImagenMarco,imagenRick);  // se utiliza para mostrar las imagenes en la ventana
        boxVertica.getChildren().addAll(contenedorPersonajes,seleccionado,seleccionadoFondo);

        root.getChildren().addAll(fondo,boxVertica,boxfinal);


        //primaryStage.setTitle("java Fx");

        //primaryStage.show();

    }
}
