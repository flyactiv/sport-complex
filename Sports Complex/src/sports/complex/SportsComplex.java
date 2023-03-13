package sports.complex;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class SportsComplex extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void setStage(String fxml, boolean resize) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(fxml));

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(SportsComplex.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setStage(String fxml) {
        setStage(fxml, true);

    }

}
