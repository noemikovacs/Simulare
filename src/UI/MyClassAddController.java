package UI;

import Service.MyClassService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.awt.*;

public class MyClassAddController {

    @FXML
    public Spinner spnId;
    public TextField txtName;
    public TextField txtDate;
    public TextField txtDuration;
    public TextField txtStartDate;

    public Button btnAddMyClass;
    public Button btnCancel;
    private MyClassService service;

    public void setService(MyClassService service){
        this.service = service;
    }

    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String name = txtName.getText();
            String date = txtDate.getText();
            String duration = txtDuration.getText();
            String startDate = txtStartDate.getText();

            service.add(id,name,date,duration,startDate);
            btnCancelClick(actionEvent);

        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

}
