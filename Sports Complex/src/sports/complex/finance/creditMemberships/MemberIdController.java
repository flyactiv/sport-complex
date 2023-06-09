package sports.complex.finance.creditMemberships;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Database.*;
import java.sql.SQLException;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sports.complex.alert.AlertMaker;
import utilities.StageLoader;

/**
 * -
 */
public class MemberIdController implements Initializable {

    @FXML
    private JFXTextField memberId;
    @FXML
    private BorderPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleOkBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = memberId.getText();

        if (id.equals("")) {
            AlertMaker.showAlert("Error", "����������, ������� ������������� ������������");

        } else {
            if (DbQuery.isMember(DbQuery.getMemberCnic(id))) {
                if (!DbQuery.hasPaid(id)) {
                    AlertMaker.showAlert("Invalid", "������������ ��� �������� �� ���� �����.");
                } else {
                    TransactionFormController.id = id;
                    StageLoader.loadWindow(getClass().getResource("TransactionForm.fxml"), "Credit Membership", getStage());
                }
            } else {
                AlertMaker.showAlert("Invalid", "������������� ������������ ��������������");

            }
        }

    }

    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

}
