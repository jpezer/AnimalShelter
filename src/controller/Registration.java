package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.Main;
import model.User;

import java.io.IOException;

public class Registration {
    @FXML
    Button homeBtn;

    @FXML
    Button registrationBtn;

    @FXML
    Button loginBtn;

    @FXML
    TextField firstnameTxt;

    @FXML
    TextField lastnameTxt;

    @FXML
    TextField emailTxt;

    @FXML
    PasswordField passwordTxt;

    @FXML
    TextField RoleTxt;

    @FXML
    Button registerBtn;

    @FXML
    Label uspjehLbl;

    @FXML
    Label greskaLbl;

    @FXML
    public void changeScene(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/StartView.fxml",
                "Welcome to AnimalShelter", 600, 450);
    }

    @FXML
    public void changeSceneLogin(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/Login.fxml",
                "Welcome to AnimalShelter", 600, 450);
    }

    @FXML
    public void registration(ActionEvent ev) throws Exception {
        if(!this.firstnameTxt.getText().equals("") &&
        !this.lastnameTxt.getText().equals("") &&
        !this.emailTxt.getText().equals("") &&
        !this.passwordTxt.getText().equals("") ){
            User u=new User();
            u.setFirstname(this.firstnameTxt.getText());
            u.setLastname((this.lastnameTxt.getText()));
            u.setEmail(this.emailTxt.getText());
            u.setPassword(this.passwordTxt.getText());
            u.setRole("User");
            u.save();
            uspjehLbl.setVisible(true);
            greskaLbl.setVisible(false);

            this.firstnameTxt.setText("");
            this.lastnameTxt.setText("");
            this.emailTxt.setText("");
            this.passwordTxt.setText("");
        }else {
            greskaLbl.setVisible(true);
            uspjehLbl.setVisible(false);

            this.firstnameTxt.setText("");
            this.lastnameTxt.setText("");
            this.emailTxt.setText("");
            this.passwordTxt.setText("");
        }


    }
}
