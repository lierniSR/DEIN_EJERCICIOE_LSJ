package es.liernisarraoa.gestiondepersonasmodal2.Controladores;

import es.liernisarraoa.gestiondepersonasmodal2.Modelo.Personas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ModificarPersonaController {
    private TableView<Personas> tablaPersonas;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField edadTextField;

    public void guardarPersona(ActionEvent actionEvent) {
    }

    public void cerrarModal(ActionEvent actionEvent) {
    }

    public void setTablaPersonas(TableView<Personas> tabla){
        this.tablaPersonas = tabla;
    }
}
