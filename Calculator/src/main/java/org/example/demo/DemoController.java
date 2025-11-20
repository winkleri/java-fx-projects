package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.ls.LSOutput;

public class DemoController {
    private boolean invalid = false;
    @FXML
    private TextField firstField;
    @FXML
    private TextField secondField;
    @FXML
    private Label resLabel;


    @FXML
    public void add(ActionEvent event) {
        calculate("+");

    }

    @FXML
    public void subtract(ActionEvent event) {
        calculate("-");
    }

    @FXML
    public void divide(ActionEvent event) {
        calculate("/");
    }

    @FXML
    public void modulo(ActionEvent event) {
        calculate("%");
    }

    @FXML
    public void multiply(ActionEvent event) {
        calculate("*");
    }

    private void calculate(String operator) {
        double first = convertStringToNumber(firstField.getText());
        double second = convertStringToNumber(secondField.getText());
        double result = 0;

        switch(operator) {
            case "+" -> result = first + second;
            case "-" -> result = first - second;
            case "*" -> result = first * second;
            case "/" -> result = first / second;
            case "%" -> result = first % second;
        }

        resLabel.setText("Result: " + result);
        if(invalid) invalidText();
    }

    private Double convertStringToNumber(String txt) {
        double num = 0;
        try {
            num = Double.parseDouble(txt);
            invalid = false;
        } catch(NumberFormatException e) {
            invalid = true;
        }
        return num;
    }

    private void invalidText() {
        resLabel.setText("Invalid!");
    }
}
