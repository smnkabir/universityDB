/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author nk
 */
public class FXMLDocumentController implements Initializable {
    
        final String userName = "root";
        final String pass = "";
        final String DBName = "UniversityDB";
        final String hostName = "localhost:3306";
        final String url = "jdbc:mysql://" + hostName + '/' + DBName;

    @FXML
    private BorderPane boarderPane;
    @FXML
    private TextField idField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label errorLevel;
    
    private String id="";
    
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    
    
    private void loadUi(String ui) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        BorderPane root = loader.load(getClass().getResource(ui+".fxml").openStream());
        boarderPane.getChildren().setAll(root);
        
        if(ui.equals("studentPanel")){
            StudentPanelController st = (StudentPanelController) loader.getController();
            st.getId(id);
            //System.out.println("done");
        }
        else if(ui.equals("teacherPanel")){
            TeacherPanelController st = (TeacherPanelController) loader.getController();
            st.getId(id);
        }
        
        
    }

    @FXML
    private void handleLoginAction(ActionEvent event) throws IOException {
        id = idField.getText();
        String password = passwordField.getText();
        
        String query = "select password from student where id = " + "'" + id + "';";
        String query1 = "select password from teacher where id = " + "'" + id + "';";
        
        String dbPass = "";
        
        if(!id.isEmpty() && !password.isEmpty()){
            
        
            try{
                Connection c = DriverManager.getConnection(url, userName, pass);
                Statement s = c.createStatement();
                ResultSet r = s.executeQuery(query);            

                while (r.next()){
                     dbPass = r.getString("password");
                }

                if (password.equals(dbPass)){
                    
                    loadUi("studentPanel");
                }

                else{
                        r = s.executeQuery(query1);            

                    while (r.next()){
                         dbPass = r.getString("password");                      /// teacher section
                    }

                    if (password.equals(dbPass)){
                        loadUi("teacherPanel");

                    }
                    
                    else{
                        errorLevel.setText("**Worng input");
                        idField.clear();
                        passwordField.clear();
                        System.err.println("wrong data");
                        
                    }
                }
                

                

            }   catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        else {
            errorLevel.setText("**Please fill up all the field ");
        }
        
        
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        Stage stage = (Stage) boarderPane.getScene().getWindow();
        stage.close();
    }

       
}    
    
    
