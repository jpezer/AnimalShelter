package controller;

import javafx.scene.control.PasswordField;
import main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;

public class Login {
    public static User logggedInUser;

    @FXML
    Button homeBtn;

    @FXML
    Button registrationBtn;

    @FXML
    Button loginBtn;

    @FXML
    TextField emailTxt;

    @FXML
    PasswordField passwordTxt;

    @FXML
    Label greskaLbl;


    @FXML
    public void signIn(ActionEvent ev){
        String userName=this.emailTxt.getText().toString();
        String userPassword=this.passwordTxt.getText().toString();

        if(userName.equals("") || userPassword.equals("")){
            greskaLbl.setVisible(true);

        }else {
            try {
                Login.logggedInUser=User.login(userName,userPassword);
                if(Login.logggedInUser.getRole().equals("Admin")){
                    Main.showWindow(
                            getClass(),
                            "../view/AddingAnimalView.fxml",
                            "AnimalShelter", 667, 469);
                }else if(Login.logggedInUser.getRole().equals("User")){
                    Main.showWindow(
                            getClass(),
                            "../view/UserView.fxml",
                            "AnimalShelter", 667, 469);
                }else{
                    greskaLbl.setText("Enter valid data");
                    greskaLbl.setVisible(true);
                }

            }catch (Exception e){
                System.out.println("Nastala je greška "+e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void changeScene(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/StartView.fxml",
                "Welcome to AnimalShelter", 600, 450);
    }

    public void changeSceneRegistration(ActionEvent ev) throws IOException {
        Main.showWindow(
                getClass(),
                "../view/Registration.fxml",
                "Welcome to AnimalShelter", 600, 450);
    }

}
