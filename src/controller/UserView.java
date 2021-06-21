package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Animal;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class UserView implements Initializable {
    @FXML
    Button logoutBtn;

    @FXML
    Label loggedUserLbl;

    @FXML
    TableView<Animal> tableView;

    @FXML
    TableColumn<Animal,String> nameTblCol;
    @FXML
    TableColumn<Animal,String> speciesTblCol;
    @FXML
    TableColumn<Animal,String> breedTblCol;
    @FXML
    TableColumn<Animal,String> genderTblCol;
    @FXML
    TableColumn<Animal,String> ageTblCol;

    @FXML
    TextField nameTxt;
    @FXML
    TextField speciesTxt;
    @FXML
    TextField breedTxt;
    @FXML
    TextField genderTxt;
    @FXML
    TextField ageTxt;

    @FXML
    public void  logOut(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/StartView.fxml",
                "AnimalShelter", 667, 469
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loggedUserLbl.setText(Login.logggedInUser.getFirstname()+" "+Login.logggedInUser.getLastname());

        this.nameTblCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.speciesTblCol.setCellValueFactory(new PropertyValueFactory<>("species"));
        this.breedTblCol.setCellValueFactory(new PropertyValueFactory<>("breed"));
        this.genderTblCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        this.ageTblCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        this.populateTableView();
    }

    private void populateTableView(){
        try {
            this.tableView.getItems().setAll((Collection<? extends Animal>) Animal.list(Animal.class));
        } catch (Exception e) {
            System.out.println("nismo uspjeli dohvatiti podatke");
        }
    }
}
