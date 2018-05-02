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

public class UpdateController {

    @FXML
    private TextField idField;


    @FXML
    private TextField titleField;


    @FXML
    private TextArea descriptionArea;

    @FXML
    private void doUpdate(ActionEvent event){
        if( titleField.getText() != null && !titleField.getText().equals("") &&
                descriptionArea.getText() != null && !descriptionArea.getText().equals("")) {
            Integer id = null;
            try{
                id = Integer.parseInt(idField.getText());
                Session session = HibernateSessionFactory.getSessionFactory().openSession();
                session.beginTransaction();
                ProductEntity prod = new ProductEntity();
                prod.setTitle(titleField.getText());
                prod.setDescription(descriptionArea.getText());
                prod.setIdProd(id);
                session.update(prod);
                session.getTransaction().commit();
                session.close();
            }
            catch(Exception e){
                showAlert("You must enter valid value in field ID!", Alert.AlertType.ERROR);
            }

        } else {
            showAlert("Some fields are wrong! Please enter right values and try again!", Alert.AlertType.ERROR);
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
