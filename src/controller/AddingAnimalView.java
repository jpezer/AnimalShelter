package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Animal;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class AddingAnimalView implements Initializable {
    @FXML
    Button homeBtn;
    @FXML
    Button logoutBtn;
    @FXML
    Button addAnimalBtn;

    @FXML
    Button deleteAnimalBtn;

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
    public void changeScene(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/StartView.fxml",
                "Welcome to AnimalShelter", 600, 450);
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

    @FXML
    public void  logOut(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/StartView.fxml",
                "AnimalShelter", 667, 469
        );
    }

    @FXML
    public void addAnimalToDatabase(ActionEvent ev) throws Exception {
        if(!this.nameTxt.getText().equals("") &&
                !this.speciesTxt.getText().equals("") &&
                !this.breedTxt.getText().equals("") &&
                !this.genderTxt.getText().equals("") &&
                !this.ageTxt.getText().equals("")){
            Animal a=new Animal();
            a.setName(this.nameTxt.getText());
            a.setSpecies(this.speciesTxt.getText());
            a.setBreed(this.breedTxt.getText());
            a.setGender(this.genderTxt.getText());
            a.setAge(this.ageTxt.getText());
            a.setShelterID_Fk(1);
            a.save();

            this.populateTableView();

            this.nameTxt.setText("");
            this.speciesTxt.setText("");
            this.breedTxt.setText("");
            this.genderTxt.setText("");
            this.ageTxt.setText("");
        }


    }

    @FXML
    public void deleteAnimalFromDatabase(ActionEvent ev) throws Exception {
        Animal a=tableView.getSelectionModel().getSelectedItem();
        a.delete();
        this.populateTableView();
    }
}
