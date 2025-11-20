package org.example.pm2vier.MVC;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import org.example.pm2vier.Info.Exam;
import org.example.pm2vier.Info.ExamResult;
import org.example.pm2vier.Info.Student;

import java.time.LocalDate;

import static org.example.pm2vier.Info.ExamFactory.createExam;
import static org.example.pm2vier.Info.ResultFactory.createResult;
import static org.example.pm2vier.Info.StudentFactory.createStudent;

public class Model {
    private static final Model instance = new Model();
    @FXML
    private ObservableList<ExamResult> examResultsList = javafx.collections.FXCollections.observableArrayList();
    @FXML
    private ObservableList<Student> studentList = javafx.collections.FXCollections.observableArrayList();
    @FXML
    private ObservableList<Exam> examList = javafx.collections.FXCollections.observableArrayList();

    private Model() {}

    public static Model getModelInstance() {
        return instance;
    }

    @FXML
    public void addStudent(String first, String last, int id) {
        Student student = createStudent(first, last, id);
        studentList.add(student);
    }

    @FXML
    public void addExam(String name, LocalDate date) {
        Exam exam = createExam(name, date);
        examList.add(exam);
    }

    @FXML
    public void addResult(Student student, Exam exam, int grade) {
        ExamResult result = createResult(student, exam, grade);
        examResultsList.add(result);
    }

    public void prefill() {
        Student ilja = createStudent("Ilja", "Winkler", 2767765);
        Student hannes = createStudent("Hannes B", "Wilke", 2767642);
        Student demy = createStudent("Demy", "Abdulsalami", 2767777);
        Student ben = createStudent("Ben", "Bohrmann", 2767890);
        Exam pm2 = createExam("PM2", LocalDate.of(2025, 7, 22));
        Exam af = createExam("AF", LocalDate.of(2025, 7, 29));
        Exam ad = createExam("AD", LocalDate.now());
        Exam gka = createExam("GKA", LocalDate.now());
        ExamResult iljapm2res= createResult(ilja, pm2, 15);
        ExamResult iljaafres= createResult(ilja, af, 15);
        ExamResult iljaadres= createResult(ilja, ad, 15);
        ExamResult iljagkares= createResult(ilja, gka, 15);
        ExamResult demypm2res= createResult(demy, pm2, 15);
        ExamResult demyafres= createResult(demy, af, 15);
        ExamResult demyadres= createResult(demy, ad, 15);
        ExamResult demygkares= createResult(demy, gka, 15);
        studentList.addAll(ilja, hannes, demy, ben);
        examList.addAll(af, pm2, ad);
        examResultsList.addAll(iljapm2res, iljaadres, iljaafres, iljagkares, demyadres, demyafres, demygkares, demypm2res);
    }

    public ObservableList<Student> getStudentList() {
        return studentList;
    }

    public ObservableList<Exam> getExamList() {
        return examList;
    }

    public ObservableList<ExamResult> getExamResultsList() {
        return examResultsList;
    }
}
