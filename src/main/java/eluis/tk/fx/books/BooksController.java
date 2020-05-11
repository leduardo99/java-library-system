package eluis.tk.fx.books;

import eluis.tk.fx.authors.Authors;
import eluis.tk.fx.publishers.Publishers;
import eluis.tk.models.Books;
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

public class BooksController implements Initializable {
    public TableView<Books> tblBooks;
    public TableColumn<Books, String> colIbsn;
    public TableColumn<Books, String> colTitle;
    public TableColumn<Books, Integer> colPublisher;
    public TableColumn<Books, Float> colPrice;
    public TextField ibsn;
    public TextField title;
    public TextField price;
    public Button btnDeleteBook;
    public Button btnUpdateBook;
    public Button btnNewBook;
    public Button btnSubmitBook;
    public TextField publisherId;
    public Button menuAutor;
    public Button menuEditoras;

    private final eluis.tk.controllers.BooksController _booksController = new eluis.tk.controllers.BooksController();
    private final Books book = new Books();
    private List<Books> books = new ArrayList<>();

    public void onClickTableBook(MouseEvent mouseEvent) {
        btnNewBook.setDisable(true);
        btnDeleteBook.setDisable(false);
        btnUpdateBook.setDisable(false);
        title.setDisable(false);
        publisherId.setDisable(false);
        price.setDisable(false);

        Books data = tblBooks.getSelectionModel().getSelectedItem();
        ibsn.setText(String.valueOf(data.getId()));
        title.setText(data.getTitle());
        publisherId.setText(String.valueOf(data.getPublisherId()));
        price.setText(String.valueOf(data.getPrice()));
    }

    public void handleDeleteBook(ActionEvent actionEvent) {
        try {
            _booksController.Delete(Integer.parseInt(ibsn.getText()));

            LoadAndToggleComponents();

            MakeAlert(Alert.AlertType.INFORMATION, "Livro removido com sucesso!");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível remover o livro");
        }
    }

    public void handleUpdateBook(ActionEvent actionEvent) {
        try {
            Books data = new Books();
            data.setId(Integer.parseInt(ibsn.getText()));
            data.setTitle(title.getText());
            data.setPublisherId(Integer.parseInt(publisherId.getText()));
            data.setPrice(Float.parseFloat(price.getText()));

            _booksController.Update(data);

            LoadAndToggleComponents();

            MakeAlert(Alert.AlertType.INFORMATION, "Livro editado com sucesso!");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível remover o autor");
        }
    }

    public void handleNewBook(ActionEvent actionEvent) {
        toggleComponents();
    }

    public void handleSubmitBook(ActionEvent actionEvent) {
        book.setId(Integer.parseInt(ibsn.getText()));
        book.setIBSN(ibsn.getText());
        book.setTitle(title.getText());
        book.setPrice(Float.parseFloat(price.getText()));
        book.setPublisherId(Integer.parseInt(publisherId.getText()));

        try {
            _booksController.Add(book);

            toggleComponents();

            LoadTableBook();

            MakeAlert(Alert.AlertType.INFORMATION, "Livro criado com sucesso!");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível adicionar o livro");
        }
    }

    public void toggleComponents() {
        ibsn.setText("");
        title.setText("");
        price.setText("");
        publisherId.setText("");

        ibsn.setDisable(!ibsn.isDisable());
        title.setDisable(!title.isDisable());
        price.setDisable(!price.isDisable());
        publisherId.setDisable(!publisherId.isDisable());
        btnSubmitBook.setDisable(!btnSubmitBook.isDisable());
    }

    private void LoadTableBook() {
        InitializeData();

        colIbsn.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<>("PublisherId"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tblBooks.setItems(FXCollections.observableArrayList(books));
    }

    private void InitializeData() {
        try {
            books = _booksController.GetAll();
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

    private void LoadAndToggleComponents() {
        LoadTableBook();

        btnNewBook.setDisable(false);
        btnDeleteBook.setDisable(true);
        btnUpdateBook.setDisable(true);
        ibsn.setText("");
        ibsn.setDisable(true);
        title.setText("");
        title.setDisable(true);
        publisherId.setText("");
        publisherId.setDisable(true);
        price.setText("");
        price.setDisable(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTableBook();

        menuAutor.setOnMouseClicked((MouseEvent e) -> {
            eluis.tk.fx.books.Books.getStage().close();

            try {
                new Authors().start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        menuEditoras.setOnMouseClicked((MouseEvent e) -> {
            eluis.tk.fx.books.Books.getStage().close();

            try {
                new Publishers().start(new Stage());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }
}
