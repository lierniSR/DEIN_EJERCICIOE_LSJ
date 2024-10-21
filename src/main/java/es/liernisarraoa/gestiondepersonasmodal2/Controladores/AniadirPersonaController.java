package es.liernisarraoa.gestiondepersonasmodal2.Controladores;

import es.liernisarraoa.gestiondepersonasmodal2.Modelo.Personas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class AniadirPersonaController {
    private static Personas personaAgregada = null;
    private String errores = "";
    private Stage modal;
    private Scene escenaAplicacion;
    private TableView<Personas> tablaPersonas;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField edadTextField;

    public void guardarPersona(ActionEvent actionEvent) {
        verificacionPersona();
        if(errores.isEmpty()){
            personaAgregada = new Personas(nombreTextField.getText(), apellidoTextField.getText(), Integer.valueOf(edadTextField.getText()));
            if (!tablaPersonas.getItems().contains(personaAgregada) && personaAgregada != null) {
                alertaAniadirPersona();
                tablaPersonas.getItems().add(personaAgregada);
                tablaPersonas.getSelectionModel().clearSelection();
                ((Stage) nombreTextField.getScene().getWindow()).close();
            } else {
                if(personaAgregada != null){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Persona duplicada");
                    alert.setHeaderText(null);
                    alert.setContentText("La persona no se puede añadir ya que existe en la tabla.");
                    alert.showAndWait();
                }
            }
        } else {
            alertaError();
        }
    }

    private void alertaAniadirPersona() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Persona añadida");
        alert.setHeaderText(null);
        alert.setContentText("Persona añadida correctamente.");
        alert.showAndWait();
    }

    private void alertaError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errores);
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
        personaAgregada = null;
        ((Stage) nombreTextField.getScene().getWindow()).close();
    }

    public static Personas getPersonasAgregada(){
        return personaAgregada;
    }

    public void setScene(Scene scene){
        escenaAplicacion = scene;
    }

    public void setStage(Stage stage){
        modal = stage;
    }

    public void setTablaPersonas(TableView<Personas> tabla){
        this.tablaPersonas = tabla;
    }
}
