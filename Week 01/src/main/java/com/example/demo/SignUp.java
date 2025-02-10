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
    // This method is automatically called when the FXML file is loaded.
    @FXML
    public void initialize() {
        // Set up ToggleGroup for gender selection
        genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        // Optional: Set default selection for Male
        maleRadio.setSelected(true);

        // Add a listener to handle gender selection changes (optional)
        genderGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadio = (RadioButton) newValue;
                System.out.println("Selected gender: " + selectedRadio.getText());
            }
        });
    }

    // Method to get selected gender as a string
    public String getSelectedGender() {
        RadioButton selectedRadioButton = (RadioButton) genderGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText();
        }
        return null; // or return a default value like "Not specified"
    }

    // Clear all input fields when "Clear" button is clicked
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

        // Reset gender selection to default (Male)
        maleRadio.setSelected(true);
    }

}
