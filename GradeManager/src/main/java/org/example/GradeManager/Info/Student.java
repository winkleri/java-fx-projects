package org.example.pm2vier.Info;

public class Student {
    //private static int maxMat = 99999;
    private final int mat;
    private final String first;
    private final String last;

    Student(String first, String last, int mat) {
        this.first = first;
        this.last = last;
        //this.mat = ++maxMat;
        this.mat = mat;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }

    public int getMat() {
        return this.mat;
    }

    @Override
    public String toString() {
        return String.format("%s,%s:%d",first,last,mat);
    }
}
