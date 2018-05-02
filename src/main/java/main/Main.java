package main;

import dao.HibernateSessionFactory;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.ProductEntity;
import org.hibernate.Session;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Product table");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent event) {
                HibernateSessionFactory.shutdown();
            }
        });
    }
    public static void main(String... args){

        launch(args);

    }
}
