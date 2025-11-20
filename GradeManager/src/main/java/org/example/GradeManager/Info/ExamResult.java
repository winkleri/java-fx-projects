package org.example.pm2vier.Info;

public class ExamResult {
    private final Student student;
    private final Exam exam;
    private final int grade;

    ExamResult(Student student, Exam exam, int grade) {
        this.student = student;
        this.exam = exam;
        this.grade = grade;
    }

    public Student getStudent() {
        return this.student;
    }

    public Exam getExam() {
        return this.exam;
    }

    public int getGrade() {
        return this.grade;
    }
}
