package controllers;

import dao.HibernateSessionFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ProductEntity;
import org.hibernate.Session;


public class AddController {

    @FXML
    private TextField idField;


    @FXML
    private TextField titleField;


    @FXML
    private TextArea descriptionArea;

    @FXML
    public void doAdd(ActionEvent event){
        if( titleField.getText() != null && !titleField.getText().equals("") &&
            descriptionArea.getText() != null && !descriptionArea.getText().equals("")) {
            Integer id = null;
            try{
                id = Integer.parseInt(idField.getText());
            }
            catch(Exception e){
                showAlert("You have entered wrong id, so in database it will be default value", Alert.AlertType.WARNING);
            }
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            ProductEntity prod = new ProductEntity();
            prod.setTitle(titleField.getText());
            prod.setDescription(descriptionArea.getText());
            if(id != null){
                prod.setIdProd(id);
            }
            session.save(prod);
            session.getTransaction().commit();
            session.close();
        } else {
            showAlert("Some fields are wrong! Please change and try again!", Alert.AlertType.ERROR);
        }
        ((Stage)idField.getScene().getWindow()).close();
    }

    private void showAlert(String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setContentText(message);
        alert.setTitle("Something went wrong!");
        alert.showAndWait();
    }
}
