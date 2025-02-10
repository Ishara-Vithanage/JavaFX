package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignUp {

    public Button backtoSigninButton;
    public Button clearButton;
    public TextField firstName;
    public TextField lastName;
    public DatePicker dateofBirth;
    public RadioButton maleRadio;
    public RadioButton femaleRadio;
    public TextField civilStatus;
    public TextField country;
    public TextField email;
    public TextField mobileNumber;
    public TextField username;
    public TextField password;
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

    public void initializeGenderInputs() {
        // Initialize radio buttons
        maleRadio = new RadioButton("Male");
        femaleRadio = new RadioButton("Female");

        // Create and set ToggleGroup
        genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);

        // Optional: Set default selection
        maleRadio.setSelected(true);
    }

    public String getSelectedGender() {
        RadioButton selectedRadioButton = (RadioButton) genderGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
            return selectedRadioButton.getText();
        }
        return null; // or return a default value like "Not specified"
    }

    public void handleGenderSelection() {
        String selectedGender = getSelectedGender();
        if (selectedGender != null) {
            System.out.println("Selected gender: " + selectedGender);
            // Add your logic here based on the selected gender
            if (selectedGender.equals("Male")) {
                // Handle male selection
            } else if (selectedGender.equals("Female")) {
                // Handle female selection
            }
        }
    }

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
    }
}
