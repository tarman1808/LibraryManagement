
package library.management.ui.addbook;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void addbook(ActionEvent event) {
    }

    @FXML
    private void canceladdbook(ActionEvent event) {
    }
    
}
