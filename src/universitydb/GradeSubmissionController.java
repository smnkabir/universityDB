/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class GradeSubmissionController implements Initializable {
    
        final String userName = "root";
        final String pass = "";
        final String DBName = "UniversityDB";
        final String hostName = "localhost:3306";
        final String url = "jdbc:mysql://" + hostName + '/' + DBName;

    @FXML
    private TextField idField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField semIdField;
    @FXML
    private TextField gpaField;
    
    String userid = "";
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void getId(String id){
        this.userid = id;
    }

    @FXML
    private void handleSubmitAction(ActionEvent event) {
            
            if(!idField.getText().isEmpty() && !codeField.getText().isEmpty() && !semIdField.getText().isEmpty() && !gpaField.getText().isEmpty())
            
            {try{   
                Connection c = DriverManager.getConnection(url, userName, pass);
                Statement s = c.createStatement();
                
                String id = idField.getText();
                String code = codeField.getText();
                int semId = Integer.parseInt(semIdField.getText());
                double gpa = Double.parseDouble(gpaField.getText());
                
                String query = "insert into result values ('" + id + "','" + code + "','" + semId + "','" + userid + "','"+ gpa + "');";
                //System.out.println(query);
                s.executeUpdate(query);  
                
                idField.clear();
                codeField.clear();
                semIdField.clear();
                gpaField.clear();
                
            } catch (SQLException ex) {
                Logger.getLogger(GradeSubmissionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else {
                // error
                errorLabel.setText("Pleas fill up all the section");
            }

    }
    
}
