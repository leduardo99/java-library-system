package eluis.tk.fx.publishers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Publishers extends Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/PublishersFXML.fxml"));

        stage.setTitle("Library System - Publishers");
        stage.setScene(new Scene(root));

        stage.show();

        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Publishers.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}
