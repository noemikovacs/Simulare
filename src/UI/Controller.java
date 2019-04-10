package UI;

import Domain.MyClass;
import Service.MyClassService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {


    public TableView tableViewMyClass;
    public TableColumn tableColumnId;
    public TableColumn tableColumnName;
    public TableColumn tableColumnDate;
    public TableColumn tableColumnDuration;
    public TableColumn tableColumnStartDate;

    public Button btnMedAdd;
    public Button btnMedDelete;

    public MyClassService service;


    private ObservableList<MyClass> mc = FXCollections.observableArrayList();

    public void setService(MyClassService service){
        this.service = service;
    }

    @FXML
    private void initialize(){

        Platform.runLater(() ->{
            mc.addAll(service.getAll());
            tableViewMyClass.setItems(mc);
        });
    }

    public void btnMyClassAddClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("MyClassAdd.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 200);
            Stage stage = new Stage();
            stage.setTitle("Add myClass");
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            MyClassAddController controller = fxmlLoader.getController();
            controller.setService(service);
            stage.showAndWait();
            mc.clear();
            mc.addAll(service.getAll());
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window", e);
        }
    }

    public void btnMyClassDeleteClick(ActionEvent actionEvent) {
        MyClass selected = (MyClass) tableViewMyClass.getSelectionModel().getSelectedItem();
        if (selected != null ) {
            try {
                service.delete(selected.getId());
                mc.clear();
                mc.addAll(service.getAll());
            } catch (RuntimeException rex) {
                Common.showValidationError(rex.getMessage());
            }
        }
    }
}
