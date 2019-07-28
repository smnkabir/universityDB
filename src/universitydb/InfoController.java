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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class InfoController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
        final String userName = "root";
        final String pass = "";
        final String DBName = "UniversityDB";
        final String hostName = "localhost:3306";
        final String Url = "jdbc:mysql://" + hostName + '/' + DBName;
    
    private String id="";
    //private String type="";
    
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private Label cgpaLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private AnchorPane detailsPane;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    public void getId(String uId ,String type){
        id = uId;
        try{
            Connection c = DriverManager.getConnection(Url, userName, pass);
            
            Statement s = c.createStatement();
            
            String query = "select * from " + type + " where id = " + "'" + id + "';";
            //System.out.println(query);
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                idLabel.setText(r.getString("id"));
                nameLabel.setText(r.getString("name"));
                addressLabel.setText(r.getString("address"));
                emailLabel.setText(r.getString("email"));
            }
            
        }   catch (SQLException ex) {
                Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
