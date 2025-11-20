package org.example.pm2vier.Info;

public class StudentFactory {
    public static Student createStudent(String first, String last, int id) {
        return new Student (first, last, id);
    }
}
