package com.example.week_02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.*;

public class HelloController {
    @FXML
    public TextField nameTextInput;

    @FXML
    public Label cmdText;

    @FXML
    public Button clickmeButton;

    @FXML
    public Button clearButton;

    @FXML
    public Button cmdInputButton;

    @FXML
    public Button cmdOutputButton;

    @FXML
    public Button calculateSumButton;

    @FXML
    public TextField firstNumInput;

    @FXML
    public TextField secondNumInput;

    @FXML
    public Label sumLabel;

    @FXML
    private Label welcomeText;

    @FXML
    public String textLine;

    @FXML
    public void initialize() {
        clickmeButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 10px;");
        clearButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 10px;");
        cmdInputButton.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-size: 10px;");
        cmdOutputButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white; -fx-font-size: 10px;");
    }

    @FXML
    protected void onHelloButtonClick() {
        if (nameTextInput.getText() == null || nameTextInput.getText().isEmpty()) {
            welcomeText.setText("Input required");
        }
        else {
            welcomeText.setText("Hello " + nameTextInput.getText());
        }
    }

    @FXML
    protected void onClearButtonClick(ActionEvent actionEvent) {
        welcomeText.setText(null);
        nameTextInput.clear();
    }

    @FXML
    public void onCmdInputButtonClick(ActionEvent actionEvent) {
        Scanner getInput = new Scanner(System.in);

        while (true) {
            System.out.print("Enter line of text: ");
            textLine = getInput.nextLine();
            if (textLine.isEmpty()) {
                System.out.println("Please enter input");
                continue;
            }
            else {
                cmdText.setText(textLine);
                break;
            }
        }
    }

    @FXML
    public void onCmdOutputButtonClick(ActionEvent actionEvent) {
        System.out.println(textLine);
    }

    @FXML
    public void calculateSumButtonClick(ActionEvent actionEvent) {
        if (firstNumInput.getText().isEmpty() || secondNumInput.getText().isEmpty()) {
            sumLabel.setText("Please enter both numbers and continue");
        }
        else {
            int sum = Integer.parseInt(firstNumInput.getText()) + Integer.parseInt(secondNumInput.getText());
            sumLabel.setText("Sum is " + String.valueOf(sum));
        }

    }


}