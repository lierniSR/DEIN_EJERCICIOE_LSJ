package es.liernisarraoa.gestiondepersonasmodal2.Controladores;

import es.liernisarraoa.gestiondepersonasmodal2.GestionPersonas;
import es.liernisarraoa.gestiondepersonasmodal2.Modelo.Personas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Scene sceneAniadir;
    private Stage modalAniadir;
    private Scene sceneModificar;
    private Stage modalModificar;
    private Personas p;
    /** Tabla que muestra la lista de personas. */
    @FXML
    private TableView<Personas> tablaPersonas;

    /** Columna para mostrar el nombre de la persona. */
    @FXML
    private TableColumn<Personas, String> columnaNombre;

    /** Columna para mostrar el apellido de la persona. */
    @FXML
    private TableColumn<Personas, String> columnaApellido;

    /** Columna para mostrar la edad de la persona. */
    @FXML
    private TableColumn<Personas, Integer> columnaEdad;

    public void agregarPersona(ActionEvent actionEvent) throws Exception {
        //Esto si el controlador necesita hacer algo en la ventana principal
        // Cargar el FXML de la ventana modal
        FXMLLoader loader = new FXMLLoader(GestionPersonas.class.getResource("aniadirPersona.fxml"));
        Parent root = loader.load();

        // Obtener el controlador de la ventana modal
        AniadirPersonaController modalControlador = loader.getController();

        // Pasar el TableView al controlador de la ventana modal
        modalControlador.setTablaPersonas(this.tablaPersonas);

        // Crear y mostrar la ventana modal
        modalAniadir = new Stage();
        sceneAniadir = new Scene(root);
        modalAniadir.setScene(sceneAniadir);
        modalAniadir.initModality(Modality.APPLICATION_MODAL);
        modalAniadir.setTitle("Agregar Persona");
        modalAniadir.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        modalAniadir.showAndWait();
    }

    public void modificarPersona(ActionEvent actionEvent) throws IOException {
        //Esto si el controlador necesita hacer algo en la ventana principal
        // Cargar el FXML de la ventana modal
        FXMLLoader loader = new FXMLLoader(GestionPersonas.class.getResource("modificarPersona.fxml"));
        Parent root = loader.load();

        p = tablaPersonas.getSelectionModel().getSelectedItem();
        // Obtener el controlador de la ventana modal
        ModificarPersonaController modalControlador = loader.getController();

        // Pasar el TableView al controlador de la ventana modal
        modalControlador.setP(p);
        modalControlador.setTabla(tablaPersonas);

        // Crear y mostrar la ventana modal
        modalModificar = new Stage();
        sceneModificar = new Scene(root);
        modalModificar.setScene(sceneModificar);
        modalModificar.initModality(Modality.APPLICATION_MODAL);
        modalModificar.setTitle("Modificar persona");
        modalModificar.getIcons().add(new Image(String.valueOf(GestionPersonas.class.getResource("/Imagenes/agenda.png"))));
        modalModificar.showAndWait();
    }

    public void eliminarPersona(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tablaPersonas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        columnaEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnaNombre.prefWidthProperty().bind(tablaPersonas.widthProperty().multiply(0.4));
        columnaApellido.prefWidthProperty().bind(tablaPersonas.widthProperty().multiply(0.4));
        columnaEdad.prefWidthProperty().bind(tablaPersonas.widthProperty().multiply(0.2));
    }
}