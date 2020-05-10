package eluis.tk.fx.authors;

import eluis.tk.controllers.AuthorController;
import eluis.tk.fx.books.Books;
import eluis.tk.models.Author;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AuthorsController implements Initializable {
    public TableColumn<Author, Integer> colIdAuthor;
    public TableColumn<Author, String> colNameAuhor;
    public TableColumn<Author, String> colFNameAuthor;
    public TableView<Author> tblAuthors;

    public TextField authorId;
    public TextField authorName;
    public TextField authorFName;
    public Button btnDeleteAuthor;
    public Button btnUpdateAuthor;
    public Button btnNewAuthor;
    public Button btnSubmitAuthor;
    public Button menuEditoras;
    public Button menuLivros;

    private final AuthorController _authorController = new AuthorController();
    private final Author author = new Author();
    private List<Author> authors = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTableAuthor();

        menuLivros.setOnMouseClicked((MouseEvent e) -> {
            Authors.getStage().close();

            try {
                new Books().start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    private void LoadTableAuthor() {
        InitializeData();

        colIdAuthor.setCellValueFactory(new PropertyValueFactory<Author, Integer>("Id"));
        colNameAuhor.setCellValueFactory(new PropertyValueFactory<Author, String>("Name"));
        colFNameAuthor.setCellValueFactory(new PropertyValueFactory<Author, String>("FName"));

        tblAuthors.setItems(FXCollections.observableArrayList(authors));
    }

    private void InitializeData() {
        try {
            authors = _authorController.GetAll();
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível buscar dados no banco de dados.");
        }
    }

    public void MakeAlert(Alert.AlertType type, String text) {
        Alert alert = new Alert(type);

        alert.setContentText(text);

        alert.show();
    }

    public void handleNewAuthor(ActionEvent actionEvent) {
        toggleComponentsAuthor();
    }

    public void toggleComponentsAuthor() {
        authorId.setText("");
        authorName.setText("");
        authorFName.setText("");

        authorName.setDisable(!authorName.isDisable());
        authorFName.setDisable(!authorFName.isDisable());
        btnSubmitAuthor.setDisable(!btnSubmitAuthor.isDisable());
    }

    public void handleSubmitAuthor(ActionEvent actionEvent) {
        author.setName(authorName.getText());
        author.setFName(authorFName.getText());

        try {
            _authorController.Add(author);

            toggleComponentsAuthor();

            LoadTableAuthor();

            MakeAlert(Alert.AlertType.INFORMATION, "Autor criado com sucesso!");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível adicionar o autor");
        }
    }

    public void onClickTableAuthor(MouseEvent mouseEvent) {
        btnNewAuthor.setDisable(true);
        btnDeleteAuthor.setDisable(false);
        btnUpdateAuthor.setDisable(false);
        authorName.setDisable(false);
        authorFName.setDisable(false);

        Author data = tblAuthors.getSelectionModel().getSelectedItem();
        authorId.setText(String.valueOf(data.getId()));
        authorName.setText(data.getName());
        authorFName.setText(data.getFName());
    }

    public void handleDeleteAuthor(ActionEvent actionEvent) {
        try {
            _authorController.Delete(Integer.parseInt(authorId.getText()));

            LoadAndToggleComponents();

            MakeAlert(Alert.AlertType.INFORMATION, "Autor removido com sucesso!");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível remover o autor");
        }
    }

    public void handleUpdateAuthor(ActionEvent actionEvent) {
        try {
            Author data = new Author();
            data.setId(Integer.parseInt(authorId.getText()));
            data.setName(authorName.getText());
            data.setFName(authorFName.getText());

            _authorController.Update(data);

            LoadAndToggleComponents();

            MakeAlert(Alert.AlertType.INFORMATION, "Autor editado com sucesso!");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível remover o autor");
        }
    }

    private void LoadAndToggleComponents() {
        LoadTableAuthor();

        btnNewAuthor.setDisable(false);
        btnDeleteAuthor.setDisable(true);
        btnUpdateAuthor.setDisable(true);
        authorId.setText("");
        authorName.setDisable(true);
        authorName.setText("");
        authorFName.setDisable(true);
        authorFName.setText("");
    }

    public void handleOpenBooks(ActionEvent actionEvent) {
        System.out.println("a");
        Authors.getStage().close();

        try {
            new Books().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
