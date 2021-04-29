package com.homeworks.n_6.services;

import com.homeworks.n_6.models.Student;

public class StudentService {

    public void printFullNamesOfStudents(Student[] students) {
        for (Student student : students)
            System.out.println(student.getFirstName() + " " + student.getLastName());
    }


    public void printAllMaleStudents(Student[] students) {
        for (Student student : students)
            if (student.isMale())
                System.out.println(student);
    }

    public void printAllFemaleWhoHasMarkGreaterThen_504(Student[] students) {
        for (Student student : students)
            if (!student.isMale() && student.getMark() > 50.4)
                System.out.println(student);
    }

    public void printStudentInformationHavingMinimalMark(Student[] students) {
        if (students.length > 0) {
            Student minimalMarkStudent = students[0];
            for (int i = 0; i < students.length; i++) {
                if (students[i].getMark() < minimalMarkStudent.getMark())
                    minimalMarkStudent = students[i];
            }

            System.out.println(minimalMarkStudent);
        } else {
            System.out.println("No students");
        }
    }

    public void printBiggestMaleStudentInformation(Student[] students) {
        Student biggest = null;
        for (Student student : students) {
            if (student.isMale()) {
                if (biggest == null)
                    biggest = student;
                else if (student.getYear() < biggest.getYear())
                    biggest = student;
            }
        }

        if (biggest == null)
            System.out.println("No male student");
        else
            System.out.println(biggest);
    }

    public void printStudentsSortedByMark(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getMark() > students[j].getMark()) {
                    Student s = students[i];
                    students[i] = students[j];
                    students[j] = s;
                }
            }
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void printFemaleStudentsSortedByYear(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            if (students[i].isMale())
                continue;
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].isMale())
                    continue;
                if (students[i].getYear() > students[j].getYear()) {
                    Student s = students[i];
                    students[i] = students[j];
                    students[j] = s;
                }
            }
        }

        for (Student student : students) {
            if (!student.isMale())
                System.out.println(student);
        }
    }
}
