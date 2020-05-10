package eluis.tk.fx.books;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Books extends javafx.application.Application {
    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/BooksFXML.fxml"));

        stage.setTitle("Library System - Books");
        stage.setScene(new Scene(root));

        stage.show();

        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Books.stage = stage;
    }

    public static void main(String[] args) {
        launch();
    }
}
