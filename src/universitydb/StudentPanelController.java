/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class StudentPanelController implements Initializable {

    @FXML
    private BorderPane studentPanel;

    /**
     * Initializes the controller class.
     */
    
    private String id = "";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void getId(String userId){
        id = userId;
    }
    @FXML
    private void handleInfoAction(ActionEvent event) throws IOException {
        loadUi("info");
        Stage stage = (Stage) studentPanel.getScene().getWindow();
        stage.setTitle("Info");
        
    }

    @FXML
    private void handleViewGradesAction(ActionEvent event) throws IOException {
        
        loadUi("viewGrades");
        Stage stage = (Stage) studentPanel.getScene().getWindow();
        stage.setTitle("ViewGrades");
       
        
    }

    @FXML
    private void handleSignOutAction(ActionEvent event) throws IOException {
        BorderPane root = FXMLLoader.load(getClass().getResource("loginPanel.fxml"));
        
        studentPanel.getChildren().setAll(root);
    }
    
    private void loadUi(String ui) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource(ui+".fxml").openStream());
        
        
        if(ui.equals("info")){
            InfoController obj = (InfoController) loader.getController();
            obj.getId(id,"student");
            
        }
        else if(ui.equals("help")){
            
        }
        else if(ui.equals("viewGrades")){
            ViewGradesController obj = (ViewGradesController) loader.getController();
            obj.getId(id);
        }
        
        studentPanel.setCenter(root);
        
        
    }

    @FXML
    private void handlehelpAction(ActionEvent event) throws IOException {
        loadUi("help");
        Stage stage = (Stage) studentPanel.getScene().getWindow();
        stage.setTitle("Help");
    }
    
}
