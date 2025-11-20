package org.example.pm2vier.Info;
import java.time.LocalDate;

public class Exam {
    private final String module;
    private final LocalDate date;

    public Exam(String module, LocalDate date) {
        this.module = module;
        this.date = date;
    }

    public String getModule() {
        return this.module;
    }

    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public String toString() {
        return String.format("%s:%s",module,date);
    }
}
