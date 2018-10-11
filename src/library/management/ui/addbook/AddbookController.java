
package library.management.ui.addbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import library.management.database.DatabaseHelper;

public class AddbookController implements Initializable {

    @FXML
    private JFXTextField booktitletf;
    @FXML
    private JFXTextField bookidtf;
    @FXML
    private JFXTextField bookauthortf;
    @FXML
    private JFXTextField publishertf;
    @FXML
    private JFXButton saveaddbook;
    @FXML
    private JFXButton canceladdbook;

    DatabaseHelper databaseHelper;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        databaseHelper = new DatabaseHelper();
        
    }    

    @FXML
    private void addbook(ActionEvent event) {
        String bookID = bookidtf.getText();
        String bookAuthor = bookauthortf.getText();
        String bookTitle = booktitletf.getText();
        String bookPublisher = publishertf.getText();
        
        if(bookID.isEmpty()||bookAuthor.isEmpty()||bookTitle.isEmpty()||bookPublisher.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Enter in all fields");
            alert.showAndWait();
            return;
        }
        String qu = "INSERT INTO BOOK VALUES("+
                "'" +bookID +"'"+
                "'" +bookTitle +"'"+
                "'" +bookAuthor +"'"+
                "'" +bookPublisher +"'"+
                "" +bookID +""+
                ")";
        System.out.println("qu");
        if(databaseHelper.execAction(qu)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Success");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Failed");
            alert.showAndWait();
        }
        
        
    }
    
    @FXML
    private void canceladdbook(ActionEvent event) {
    }
    
}
