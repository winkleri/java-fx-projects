package org.example.pm2vier.MVC;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.pm2vier.Info.Exam;
import org.example.pm2vier.Info.Student;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class SelectionVC extends MainVC {
    @FXML
    private Slider slider;
    @FXML
    private TextField grade;
    @FXML
    private TextField mat;
    @FXML
    private DatePicker date;
    @FXML
    private TextField first;
    @FXML
    private TextField last;
    @FXML
    private TextField module;
    @FXML
    private Label label;
    @FXML
    private ComboBox<Student> studentCombo;
    @FXML
    private ComboBox<Exam> examCombo;

    @FXML
    public void initialize() {
        model.prefill();
        studentCombo.setItems(model.getStudentList());
        examCombo.setItems(model.getExamList());
        dropdownHelper(studentCombo);
        dropdownHelper(examCombo);
    }

    @FXML
    protected void sliderBind(ActionEvent event) {
        checkValidityOfGrade(event);
        slider.setValue(Integer.parseInt(grade.getText()));
        grade.textProperty().bindBidirectional(
                slider.valueProperty(),
                NumberFormat.getNumberInstance());
    }

    @FXML
    protected boolean checkValidity(Pattern regex, TextField field, String debugText) {
        if(!field.getText().matches(String.valueOf(regex))) {
            field.setText("");
            label.setText(debugText);
            return false;
        } else return true;
    }

    @FXML
    protected boolean checkValidityOfMat(ActionEvent event) {
        //Matrikelnummern sind immer siebenstellige Zahlen
        Pattern regex = Pattern.compile("\\d{7}");
        return checkValidity(regex, mat, "Mat-Nr: siebenstelligeZahl");
    }

    @FXML
    protected boolean checkValidityOfName(TextField field) {
        //Namen sind immer Zeichenketten ohne Ziffern mit eventuellen Bindestrichen
        Pattern regex = Pattern.compile("[\\wöäü\\-]{1,50}");
        return checkValidity(regex, field, "Vorname: Buchstaben/Bindestrich max. Länge 50");
    }

    @FXML
    protected boolean checkValidityOfLast(ActionEvent event) {
        return checkValidityOfName(last);
    }

    @FXML
    protected boolean checkValidityOfFirst(ActionEvent event) {
        return checkValidityOfName(first);
    }

    @FXML
    protected boolean checkValidityOfModule(ActionEvent event) {
        //Modulnamen sind Abkürzungen bspw. PM2, GKA, AF
        Pattern regex = Pattern.compile("[\\w\\d]{2,3}");
        return checkValidity(regex, module, "Textfeld Module: zwei bis drei Zeichen");
    }
    @FXML
    protected boolean checkValidityOfGrade(ActionEvent event) {
        //Noten sind zweistellige Zahlen
        Pattern regex = Pattern.compile("^(1[0-5]|[0-9])$");
        return checkValidity(regex, grade, "Notenpunkte liegen im Bereich 0-15");
    }

    @FXML
    protected void handleAddStudent(ActionEvent event) {
        if(checkValidityOfFirst(event) && checkValidityOfLast(event) && checkValidityOfMat(event)) {
            String firstName = first.getText();
            String lastName = last.getText();
            int id = Integer.parseInt(mat.getText());
            model.addStudent(firstName, lastName, id);
        } else {
            label.setText("Achte auf die Vorgaben ;-)");
        }
    }

    @FXML
    protected void handleAddExam(ActionEvent event) {
        if(checkValidityOfModule(event)) {
            String name = module.getText();
            LocalDate dateVal = date.getValue();
            model.addExam(name, dateVal);
        }
    }

    @FXML
    protected void handleAddResult(ActionEvent event) {
        if(checkValidityOfGrade(event)) {
            Student student = studentCombo.getValue();
            Exam exam = examCombo.getValue();
            int gradeVal = Integer.parseInt(grade.getText());
            model.addResult(student, exam, gradeVal);
        } else {
            label.setText("Achte auf die Vorgaben ;-)");
        }
    }


    public <T> void dropdownHelper(ComboBox<T> combobox) {
        combobox.setCellFactory(lv -> new ListCell<T>() {
            protected void updateItem(T t, boolean empty) {
                super.updateItem(t, empty);
                if (empty || t == null) {
                    setText(null);
                } else {
                    setText(t.toString());
                }
            }
        });
        combobox.setButtonCell(combobox.getCellFactory().call(null));
    }
}
