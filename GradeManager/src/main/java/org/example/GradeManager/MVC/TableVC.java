package org.example.pm2vier.MVC;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.pm2vier.Info.ExamResult;
import java.time.format.DateTimeFormatter;

public class TableVC extends MainVC {
    @FXML
    private TableView<ExamResult> resultTable;
    @FXML
    private TableColumn<ExamResult, String> firstCol = new TableColumn<>();
    @FXML
    private TableColumn<ExamResult, String> lastCol = new TableColumn<>();
    @FXML
    private TableColumn<ExamResult, Integer> matCol = new TableColumn<>();
    @FXML
    private TableColumn<ExamResult, String> moduleCol = new TableColumn<>();
    @FXML
    private TableColumn<ExamResult, String> dateCol = new TableColumn<>();
    @FXML
    private TableColumn<ExamResult, Integer> gradeCol = new TableColumn<>();


    @FXML
    protected void initialize() {
        resultTable.setItems(model.getExamResultsList());
        firstCol.setCellValueFactory(data ->
               new SimpleStringProperty(data.getValue().getStudent().getFirst()));
        lastCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getStudent().getLast()));
        matCol.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getStudent().getMat()).asObject());
        moduleCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getExam().getModule()));
        dateCol.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getExam().getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        gradeCol.setCellValueFactory(data ->
                new SimpleIntegerProperty(data.getValue().getGrade()).asObject());
    }
}
