package eluis.tk.fx.authors;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Authors extends javafx.application.Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/AuthorsFXML.fxml"));

        stage.setTitle("Library System - Authors");
        stage.setScene(new Scene(root));

        stage.show();

        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Authors.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}
