package org.example.pm2vier.Info;

public class ResultFactory {
    public static ExamResult createResult(Student student, Exam exam, int grade) {
        return new ExamResult(student, exam, grade);
    }
}