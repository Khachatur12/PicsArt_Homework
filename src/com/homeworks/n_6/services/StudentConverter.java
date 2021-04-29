package com.homeworks.n_6.services;

import com.homeworks.n_6.models.Student;

public class StudentConverter {
    public Student[] convertHumans(String[] humansStr) {
        Student[] students = new Student[humansStr.length];
        for (int i = 0; i < humansStr.length; i++) {
            String[] humanDetails = humansStr[i].split(",");
            students[i] = new Student(
                    humanDetails[0],
                    humanDetails[1],
                    Integer.parseInt( humanDetails[2] ),
                    humanDetails[3].equals("m"),
                    Double.parseDouble( humanDetails[4] )
            );
        }
        return students;
    }


}
