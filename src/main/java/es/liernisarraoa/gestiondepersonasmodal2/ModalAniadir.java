package es.liernisarraoa.gestiondepersonasmodal2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ModalAniadir extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ModalAniadir.class.getResource("aniadirPersona.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 378, 225);
        stage.setTitle("Añadir persona");
        stage.getIcons().add(new Image(String.valueOf(ModalAniadir.class.getResource("/Imagenes/agenda.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
