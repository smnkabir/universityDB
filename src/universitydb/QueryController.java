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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author nk
 */
public class QueryController implements Initializable {

    final String userName = "root";
    final String pass = "";
    final String DBName = "UniversityDB";
    final String hostName = "localhost:3306";
    final String url = "jdbc:mysql://" + hostName + '/' + DBName;

    @FXML
    private TextField studentIdField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField semIdField;
    @FXML
    private VBox resultVBox;
    @FXML
    private Label nameLabel;
    @FXML
    private ListView<String> courseTitleListView;
    private ObservableList<String> courseTitleListViewItem;
    @FXML
    private ListView<String> creditListView;
    private ObservableList<String> creditListViewItem;
    @FXML
    private ListView<String> gpaListView;
    private ObservableList<String> gpaListViewItem;
    @FXML
    private ListView<String> idListView;
    private ObservableList<String> idListViewItem;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        courseTitleListViewItem = FXCollections.observableArrayList();
        creditListViewItem = FXCollections.observableArrayList();
        gpaListViewItem = FXCollections.observableArrayList();
        idListViewItem = FXCollections.observableArrayList();
    }

    @FXML
    private void handleSearchAction(ActionEvent event) {
        String id = studentIdField.getText();
        String code = codeField.getText();
        String semId = semIdField.getText();
        String query = "";
        if (!id.isEmpty() && code.isEmpty() && semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and stId = '" + id + "';";
        } else if (!id.isEmpty() && code.isEmpty() && !semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and stId = '" + id + "' and semId = '" + semId + "';";
        } else if (id.isEmpty() && !code.isEmpty() && semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and result.code = '" + code + "';";
        } else if (id.isEmpty() && !code.isEmpty() && !semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and code = '" + code + "' and semId = '" + semId + "';";
        } else if (id.isEmpty() && code.isEmpty() && !semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and semId = '" + semId + "';";
        } else if (!id.isEmpty() && !code.isEmpty() && semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and stId = '" + id + "' and code = '" + code + "';";
        } else if (!id.isEmpty() && !code.isEmpty() && !semId.isEmpty()) {
            query = "select * from result,course where result.code = course.code and stId = '" + id + "' and code = '" + code + "' and semId = '" + semId + "';";
        }

        //System.out.println(query);
        idListViewItem.clear();
        courseTitleListViewItem.clear();
        creditListViewItem.clear();
        gpaListViewItem.clear();

        try {
            Connection c = DriverManager.getConnection(url, userName, pass);
            Statement s = c.createStatement();

            if (!id.isEmpty()) {
                String q = "select * from student where id = '" + id + "';";
                ResultSet st = s.executeQuery(q);

                while (st.next()) {

                    nameLabel.setText("  " + st.getString("name") + "\n\n");

                }
            }

            ResultSet r = s.executeQuery(query);

            while (r.next()) {

                String studentId = r.getString("stId");
                String courseCode = r.getString("code");
                String semesterId = r.getString("semId");
                String gpa = r.getString("gpa");
                String title = r.getString("title");
                String credit = r.getString("credit");

                idListViewItem.add(studentId);
                courseTitleListViewItem.add(title);
                creditListViewItem.add(credit);
                gpaListViewItem.add(gpa);

            }

            idListView.setItems(idListViewItem);
            courseTitleListView.setItems(courseTitleListViewItem);
            creditListView.setItems(creditListViewItem);
            gpaListView.setItems(gpaListViewItem);

        } catch (SQLException ex) {
            Logger.getLogger(QueryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
