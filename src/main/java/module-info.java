module es.liernisarraoa.gestiondepersonasmodal2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.liernisarraoa.gestiondepersonasmodal2 to javafx.fxml;
    exports es.liernisarraoa.gestiondepersonasmodal2;
    exports es.liernisarraoa.gestiondepersonasmodal2.Controladores;
    opens es.liernisarraoa.gestiondepersonasmodal2.Controladores to javafx.fxml;
}