/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydb;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class TeacherPanelController implements Initializable {

    @FXML
    private BorderPane teacherPanel;

    /**
     * Initializes the controller class.
     */
    String id = "";
    @FXML
    private AnchorPane centerPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
       
    }  
    
    public void getId(String userId){
        id = userId;
        
    }

    @FXML
    private void handleInfoAction(ActionEvent event) throws IOException {
        loadUi("info");
        Stage stage = (Stage) teacherPanel.getScene().getWindow();
        stage.setTitle("Info");
         
    }

    @FXML
    private void handleGradeSubmissionAction(ActionEvent event) throws IOException {
        loadUi("gradeSubmission");
        Stage stage = (Stage) teacherPanel.getScene().getWindow();
        stage.setTitle("GradeSubmission");
    }

    @FXML
    private void handleQueryAction(ActionEvent event) throws IOException {
        loadUi("query");
        Stage stage = (Stage) teacherPanel.getScene().getWindow();
        stage.setTitle("Query");
    }

    @FXML
    private void handleSignOutAction(ActionEvent event) throws IOException {
         BorderPane root = FXMLLoader.load(getClass().getResource("loginPanel.fxml"));
        
        teacherPanel.getChildren().setAll(root);
    }
    
    private void loadUi(String ui) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        Pane root = loader.load(getClass().getResource(ui+".fxml").openStream());
        
        
        //teacherPanel.setCenter(root);
        
        centerPane.getChildren().setAll(root);
        if(ui.equals("info")){
            InfoController obj = (InfoController) loader.getController();
            obj.getId(id,"teacher");
        }
        else if (ui.equals("gradeSubmission")){
            GradeSubmissionController obj = (GradeSubmissionController) loader.getController();
            obj.getId(id);
        }
        else if (ui.equals("StudentDetails")){
            
        }
    }

    @FXML
    private void handleStudentDetailsAction(ActionEvent event) throws IOException {
        loadUi("StudentDetails");
    }
    
}
