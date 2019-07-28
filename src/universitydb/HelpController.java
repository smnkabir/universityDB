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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class HelpController implements Initializable {
    
        final String userName = "root";
        final String pass = "";
        final String DBName = "UniversityDB";
        final String hostName = "localhost:3306";
        final String Url = "jdbc:mysql://" + hostName + '/' + DBName;

    @FXML
    private TextField initialField;
    @FXML
    private Label nameLabel;
    @FXML
    private Label emailLabel;

    /**
     * Initializes the controller class.
     */
    private String id="";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private void handleSearchAction(ActionEvent event) {
        try{
            Connection c = DriverManager.getConnection(Url, userName, pass);
            
            Statement s = c.createStatement();
            
            String query = "select name,email from teacher where id = " + "'" + initialField.getText() + "';";
            //System.out.println(query);
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                nameLabel.setText("Name: " + r.getString("name"));
                emailLabel.setText("Email: " + r.getString("email"));
            }
            
        }   catch (SQLException ex) {
                Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
