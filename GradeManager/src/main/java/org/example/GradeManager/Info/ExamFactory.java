package org.example.pm2vier.Info;

import java.time.LocalDate;

public class ExamFactory {
    public static Exam createExam(String modul, LocalDate date) {
        return new Exam (modul, date);
    }
}