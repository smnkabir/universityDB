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
import java.text.DecimalFormat;
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
public class StudentDetailsController implements Initializable {

    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label addressLabel;
    @FXML
    private Label emailLabel;
    @FXML
    private Label cgpaLabel;
    @FXML
    private Label creditLabel;
    
    String id;

    /**
     * Initializes the controller class.
     */
        final String userName = "root";
        final String pass = "";
        final String DBName = "UniversityDB";
        final String hostName = "localhost:3306";
        final String Url = "jdbc:mysql://" + hostName + '/' + DBName;
    @FXML
    private TextField studentIdTextField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    

    @FXML
    private void handleSearchAction(ActionEvent event) {
        
        if(!studentIdTextField.getText().isEmpty()){
            id = studentIdTextField.getText();
            
            try{
            Connection c = DriverManager.getConnection(Url, userName, pass);
            
            Statement s = c.createStatement();
            
            String query = "select * from student where id = " + "'" + id + "';";
            System.out.println(query);
            ResultSet r = s.executeQuery(query);
            while(r.next()){
                idLabel.setText(r.getString("id"));
                nameLabel.setText(r.getString("name"));
                addressLabel.setText(r.getString("address"));
                emailLabel.setText(r.getString("email"));
            }
            
            query = "select sum(gpa*(select credit from course where result.code = course.code))'sum' from result where stId = '" + id + "';";
            r = s.executeQuery(query);
            double cgpa = 0;
            while(r.next())
                cgpa = r.getDouble("sum");
            double credit = 0;
            query = "select sum(credit) from course  where code in  (select code from result where stId = '" + id + "');";
            r = s.executeQuery(query);
            while(r.next())
                credit = r.getDouble("sum(credit)");
            
            cgpa/=credit;
            DecimalFormat dec = new DecimalFormat("#0.00");
            
            cgpaLabel.setText("CGPA : " + dec.format(cgpa));
            creditLabel.setText("" + credit);
        }   catch (SQLException ex) {
                Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
