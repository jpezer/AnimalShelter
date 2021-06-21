package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;


import java.io.IOException;

public class StartView  {

    @FXML
    Button homeBtn;

    @FXML
    Button registrationBtn;

    @FXML
    Button loginBtn;


    @FXML
    public void changeScene(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/Registration.fxml",
                "Welcome to AnimalShelter", 600, 450);
    }
    @FXML
    public void changeSceneLogin(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/Login.fxml",
                "Welcome to AnimalShelter", 600, 450);
    }

}
