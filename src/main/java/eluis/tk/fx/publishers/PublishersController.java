package eluis.tk.fx.publishers;

import eluis.tk.fx.authors.Authors;
import eluis.tk.fx.books.Books;
import eluis.tk.models.Author;
import eluis.tk.models.Publishers;
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

public class PublishersController implements Initializable {
    private final eluis.tk.controllers.PublishersController _publishersController = new eluis.tk.controllers.PublishersController();
    private final Publishers publisher = new Publishers();
    private List<Publishers> publishers = new ArrayList<>();

    public TableColumn<Publishers, Integer> colID;
    public TableColumn<Publishers, String> colNAME;
    public TableColumn<Publishers, String> colURL;
    public TableView<Publishers> tblPublishers;
    public TextField name;
    public Button menuAutor;
    public Button menuLivros;
    public Button btnSubmit;
    public Button btnNew;
    public Button btnUpdate;
    public Button btnDelete;
    public TextField id;
    public TextField url;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoadTable();
    }

    private void LoadTable() {
        InitializeData();

        colID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNAME.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colURL.setCellValueFactory(new PropertyValueFactory<>("URL"));

        tblPublishers.setItems(FXCollections.observableArrayList(publishers));
    }

    private void InitializeData() {
        try {
            publishers = _publishersController.GetAll();
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

    public void handleNew(ActionEvent actionEvent) {
        toggleComponents();
    }

    public void toggleComponents() {
        id.setText("");
        name.setText("");
        url.setText("");

        name.setDisable(!name.isDisable());
        url.setDisable(!url.isDisable());
        btnSubmit.setDisable(!btnSubmit.isDisable());
    }

    public void handleSubmit(ActionEvent actionEvent) {
        publisher.setName(name.getText());
        publisher.setURL(url.getText());

        try {
            _publishersController.Add(publisher);

            toggleComponents();

            LoadTable();

            MakeAlert(Alert.AlertType.INFORMATION, "Editora criado com sucesso!");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível adicionar o autor");
        }
    }

    public void onClickTable(MouseEvent mouseEvent) {
        btnNew.setDisable(true);
        btnDelete.setDisable(false);
        btnUpdate.setDisable(false);
        name.setDisable(false);
        url.setDisable(false);

        Publishers data = tblPublishers.getSelectionModel().getSelectedItem();
        id.setText(String.valueOf(data.getId()));
        name.setText(data.getName());
        url.setText(data.getURL());
    }

    public void handleDelete(ActionEvent actionEvent) {
        try {
            _publishersController.Delete(Integer.parseInt(id.getText()));

            LoadAndToggleComponents();

            MakeAlert(Alert.AlertType.INFORMATION, "Editora removido com sucesso!");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível remover a editora");
        }
    }

    public void handleUpdate(ActionEvent actionEvent) {
        try {
            Publishers data = new Publishers();
            data.setId(Integer.parseInt(id.getText()));
            data.setName(name.getText());
            data.setURL(url.getText());

            _publishersController.Update(data);

            LoadAndToggleComponents();

            MakeAlert(Alert.AlertType.INFORMATION, "Editora editado com sucesso!");
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            MakeAlert(Alert.AlertType.ERROR, "Não foi possível remover o autor");
        }
    }

    private void LoadAndToggleComponents() {
        LoadTable();

        btnNew.setDisable(false);
        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);
        id.setText("");
        name.setDisable(true);
        name.setText("");
        url.setDisable(true);
        url.setText("");
    }

    public void handleOpenBooks(ActionEvent actionEvent) {
        eluis.tk.fx.publishers.Publishers.getStage().close();

        try {
            new Books().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleOpenAuthors(ActionEvent actionEvent) {
        eluis.tk.fx.publishers.Publishers.getStage().close();

        try {
            new Authors().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
