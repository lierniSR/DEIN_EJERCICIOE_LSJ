package es.liernisarraoa.gestiondepersonasmodal2.Controladores;

import es.liernisarraoa.gestiondepersonasmodal2.Modelo.Personas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ModificarPersonaController {
    private Personas p;
    private String errores = "";
    private TableView<Personas> tabla;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField edadTextField;

    public void guardarPersona(ActionEvent actionEvent) {
        verificacionPersona();
        if(errores.isEmpty()){
            Personas personaModificar = new Personas(nombreTextField.getText(), apellidoTextField.getText(), Integer.parseInt(edadTextField.getText()));
            if(p != null && !tabla.getItems().contains(personaModificar)){
                alertaModificarPersona();
                tabla.getItems().remove(p);
                tabla.getItems().add(personaModificar);
                tabla.getSelectionModel().clearSelection();
                ((Stage) nombreTextField.getScene().getWindow()).close();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Persona duplicada");
                alert.setContentText("La persona no se puede modificar ya que existe una Persona identica en la tabla.");
                alert.showAndWait();
            }
        } else {
            alertaError();
        }
    }

    private void alertaError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(errores);
        alert.showAndWait();
    }

    private void alertaModificarPersona() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Persona modificada");
        alert.setContentText("Persona modificada correctamente.");
        alert.showAndWait();
    }

    private void verificacionPersona() {
        errores = "";
        if (nombreTextField.getText().isEmpty()) {
            errores += "El campo nombre es obligatorio.\n";
        }
        if (apellidoTextField.getText().isEmpty()) {
            errores += "El campo apellidos es obligatorio.\n";
        }
        if (edadTextField.getText().isEmpty()) {
            errores += "El campo edad es obligatorio";
        } else {
            try {
                Integer edad = Integer.parseInt(edadTextField.getText());
            } catch (NumberFormatException e) {
                errores += "El campo edad tiene que ser númerico.\n";
            }
        }
    }

    public void cerrarModal(ActionEvent actionEvent) {
        tabla.getSelectionModel().clearSelection();
        ((Stage) nombreTextField.getScene().getWindow()).close();
    }

    public void setP(Personas p){
        this.p = p;
        inicializarCampos();
    }

    public void setTabla(TableView<Personas> tabla){
        this.tabla = tabla;
    }

    private void inicializarCampos() {
        if(p != null){
            nombreTextField.setText(p.getNombre());
            apellidoTextField.setText(p.getApellido());
            edadTextField.setText(String.valueOf(p.getEdad()));
        }
    }
}
