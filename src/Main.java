import Domain.MyClassValidator;
import Repository.InMemoryRepository;
import Service.MyClassService;
import UI.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UI/sample.fxml"));
            Parent root = fxmlLoader.load();

            Controller controller =  fxmlLoader.getController();

            MyClassValidator validator = new MyClassValidator();
            InMemoryRepository repository = new InMemoryRepository(validator);
            MyClassService service = new MyClassService(repository);

            service.add("52","test","20.11.2013","2h","11");
            service.add("2","test1","28.11.2018", "5h","15");

            controller.setService(service);


            primaryStage.setTitle("MyClass manager");
            primaryStage.setScene(new Scene(root, 650, 500));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }

}
