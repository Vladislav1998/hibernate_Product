package controllers;

import dao.HibernateSessionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ProductEntity;
import org.hibernate.Session;

public class DeleteController {

    @FXML
    private TextField idField;

    @FXML
    public void doDelete(ActionEvent event){
        int id;
        try{
           id = Integer.parseInt(idField.getText());
        } catch(Exception e){
            showAlert("Please enter correct value.", Alert.AlertType.ERROR);
            return;
        }
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery("delete from "+ProductEntity.class.getSimpleName() +" where id = :id").
                setParameter("id", id).
                executeUpdate();
        session.getTransaction().commit();
        session.close();
        ((Stage)idField.getScene().getWindow()).close();
    }

    private void showAlert(String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.setTitle("Something went wrong!");
        alert.showAndWait();
    }
}
