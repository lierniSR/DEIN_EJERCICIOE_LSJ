package es.liernisarraoa.gestiondepersonasmodal2.Controladores;

import es.liernisarraoa.gestiondepersonasmodal2.Modelo.Personas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ModificarPersonaController {
    private Personas p;
    private String errores = "";

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField edadTextField;

    public void guardarPersona(ActionEvent actionEvent) {
        verificacionPersona();
        if(errores.isEmpty()){
            
        }
    }

    public void cerrarModal(ActionEvent actionEvent) {
    }

    public void setP(Personas p){
        this.p = p;
        inicializarCampos();
    }

    private void inicializarCampos() {
        if(p != null){
            nombreTextField.setText(p.getNombre());
            apellidoTextField.setText(p.getApellido());
            edadTextField.setText(String.valueOf(p.getEdad()));
        }
    }
}
