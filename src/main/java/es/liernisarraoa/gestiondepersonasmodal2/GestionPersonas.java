package es.liernisarraoa.gestiondepersonasmodal2;

import es.liernisarraoa.gestiondepersonasmodal2.Controladores.AniadirPersonaController;
import es.liernisarraoa.gestiondepersonasmodal2.Controladores.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionPersonas extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionPersonas.class.getResource("gestionDePersonas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Gestion de personas");
        stage.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}