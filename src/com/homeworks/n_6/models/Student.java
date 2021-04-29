package com.homeworks.n_6.models;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private boolean isMale;
    private double mark;

    public Student() {}

    public Student(String firstName, String lastName, int year, boolean isMale, double mark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.isMale = isMale;
        this.mark = mark;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName +
                ", lastName='" + lastName +
                ", year=" + year +
                ", gender=" + (isMale ? "male" : "female") +
                ", weight=" + mark +
                '}';
    }
}
