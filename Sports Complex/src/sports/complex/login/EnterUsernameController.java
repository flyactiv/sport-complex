package sports.complex.login;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sports.complex.alert.AlertMaker;
import Database.DbQuery;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import utilities.StageLoader;

/**
 * FXML Controller class
 *
 * -
 */
public class EnterUsernameController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private BorderPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleNextBtn(ActionEvent event) throws SQLException, IOException, ClassNotFoundException {
        boolean valid;
        String uname = username.getText();

        if (username.getText().equals("")) {
            AlertMaker.showAlert("Try Again", "����������, ������� ��� ������������");
        } else {
            valid = DbQuery.isCorrectUsername(username.getText());

            if (valid) {
                PasswordRecoveryController.setUsername(uname);
                StageLoader.loadWindow(getClass().getResource("passwordRecovery.fxml"), "Password Recovery", getStage());
            } else {
                AlertMaker.showAlert("Try Again", "��� ������������ �� ����������");

            }
        }
    }
    
    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

}
