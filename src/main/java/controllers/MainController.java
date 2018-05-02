package controllers;

import dao.HibernateSessionFactory;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ProductEntity;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;

public class MainController {

    private ObservableList<ProductEntity> obsList = FXCollections.observableArrayList();
    

    @FXML
    TableView<ProductEntity> table;

    @FXML
    TableColumn<ProductEntity, Integer> idColumn;

    @FXML
    TableColumn<ProductEntity, String> titleColumn;

    @FXML
    TableColumn<ProductEntity, String> descriptionColumn;

    @FXML
    private void initialize(){
        Thread t = new Thread(){
            @Override
            public void run(){
                while(true) {
                    initData();
                    idColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, Integer>("idProd"));
                    titleColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, String>("title"));
                    descriptionColumn.setCellValueFactory(new PropertyValueFactory<ProductEntity, String>("description"));
                    table.setItems(obsList);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }

    @FXML
    public void doDeleteProd(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/DeleteWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Delete Product");
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    public void doAddProd(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/AddWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Add new Product");
        stage.setScene(scene);
        stage.showAndWait();
    }

    @FXML
    public void doUpdateProd(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/UpdateWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Update Product");
        stage.setScene(scene);
        stage.showAndWait();
    }


    private void initData(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "From "+ ProductEntity.class.getSimpleName();
        List<ProductEntity> products = session.createQuery(sql).list();
        obsList.clear();
        obsList.addAll(products);
        session.getTransaction().commit();
        session.close();
    }
}
