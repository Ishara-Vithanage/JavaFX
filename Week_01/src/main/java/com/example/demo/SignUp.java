package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class SignUp {

    @FXML
    public Button backtoSigninButton;
    @FXML
    public Button clearButton;
    @FXML
    public TextField firstName;
    @FXML
    public TextField lastName;
    @FXML
    public DatePicker dateofBirth;
    @FXML
    public RadioButton maleRadio;
    @FXML
    public RadioButton femaleRadio;
    @FXML
    public TextField civilStatus;
    @FXML
    public TextField country;
    @FXML
    public TextField email;
    @FXML
    public TextField mobileNumber;
    @FXML
    public TextField username;
    @FXML
    public TextField password;
    @FXML
    public TextField confirmPassword;

    private ToggleGroup genderGroup;

    public void backtoSigninClick() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Sign in");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void initialize() {
        genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        maleRadio.setSelected(true);

        genderGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadio = (RadioButton) newValue;
                System.out.println("Selected gender: " + selectedRadio.getText());
            }
        });
    }

    public String getSelectedGender() {
        RadioButton selectedRadioButton = (RadioButton) genderGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText();
        }
        return null;
    }

    @FXML
    public void clearButtonClick() {
        firstName.clear();
        lastName.clear();
        civilStatus.clear();
        country.clear();
        email.clear();
        mobileNumber.clear();
        username.clear();
        password.clear();
        confirmPassword.clear();
        maleRadio.setSelected(true);
        dateofBirth.setValue(null);
    }

}
