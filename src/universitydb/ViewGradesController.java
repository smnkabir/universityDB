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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class ViewGradesController implements Initializable {

    @FXML
    private Label cgpaLabel;
    @FXML
    private Label creditLabel;
    @FXML
    private TextField semIdTextField;
    @FXML
    private ListView<String> codeListView;
    private ObservableList<String> codeListViewItem;
    @FXML
    private ListView<String> courseTitleListView;
    private ObservableList<String> courseTitleViewItem;

    @FXML
    private ListView<String> creditListView;
    private ObservableList<String> creditListViewItem;

    @FXML
    private ListView<String> gpaListView;
    private ObservableList<String> gpaListViewItem;

    
    String id;
    
    
        final String userName = "root";
        final String pass = "";
        final String DBName = "UniversityDB";
        final String hostName = "localhost:3306";
        final String Url = "jdbc:mysql://" + hostName + '/' + DBName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        courseTitleViewItem = FXCollections.observableArrayList();
        creditListViewItem = FXCollections.observableArrayList();
        gpaListViewItem = FXCollections.observableArrayList();
        codeListViewItem = FXCollections.observableArrayList();
    }  

    @FXML
    private void handleSearchAction(ActionEvent event) {
                    courseTitleViewItem.clear();
                    creditListViewItem.clear();
                    gpaListViewItem.clear();
                    codeListViewItem.clear();
                    
                    
            
        try{   
                Connection c = DriverManager.getConnection(Url, userName, pass);
                Statement s = c.createStatement();
                
        
                String query = "select * from result,course where course.code=result.code and stId = '" 
                        + id + "' and semId = '" + semIdTextField.getText() +"'";
                
                ResultSet r = s.executeQuery(query);
                
                while(r.next()){
                    
                    String studentId = r.getString("stId");
                    String courseCode = r.getString("code");
                    String semesterId = r.getString("semId");
                    String gpa = r.getString("gpa");
                    String title = r.getString("title");
                    String credit = r.getString("credit");
                    
                    codeListViewItem.add(courseCode);
                    courseTitleViewItem.add(title);
                    creditListViewItem.add(credit);
                    gpaListViewItem.add(gpa);
                    
                    
                }
                
                codeListView.setItems(codeListViewItem);
                courseTitleListView.setItems(courseTitleViewItem);
                creditListView.setItems(creditListViewItem);
                gpaListView.setItems(gpaListViewItem);
            
        }   catch (SQLException ex) {
                Logger.getLogger(QueryController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public void getId(String id){
        this.id = id;
        try{
            Connection c = DriverManager.getConnection(Url, userName, pass);
            
            Statement s = c.createStatement();
            
            String query = "select sum(gpa*(select credit from course where result.code = course.code))'sum' from result where stId = '"
                    +id + "';";
            ResultSet r = s.executeQuery(query);
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
            creditLabel.setText("Credit Completed : " + credit);
        }   catch (SQLException ex) {
                Logger.getLogger(InfoController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
