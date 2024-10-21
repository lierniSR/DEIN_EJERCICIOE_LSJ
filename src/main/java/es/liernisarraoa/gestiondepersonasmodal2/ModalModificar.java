package es.liernisarraoa.gestiondepersonasmodal2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ModalModificar extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(ModalModificar.class.getResource("modificarPersona.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 378, 225);
        stage.setTitle("Modificar persona");
        stage.getIcons().add(new Image(String.valueOf(ModalModificar.class.getResource("/Imagenes/agenda.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
