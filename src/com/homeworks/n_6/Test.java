package com.homeworks.n_6;

import com.homeworks.n_6.services.FileService;
import com.homeworks.n_6.models.Student;
import com.homeworks.n_6.services.StudentConverter;
import com.homeworks.n_6.services.StudentService;

import java.nio.file.Paths;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        StudentConverter studentConverter = new StudentConverter();
        String[] studentsStr = fileService.getStringArray(Paths.get("src/com/homeworks/n_6/resources/text.txt"));
        Student[] students = studentConverter.convertHumans(studentsStr);
        StudentService studentService = new StudentService();

        for (Student student : students) {
            System.out.println(student);
        }

        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);

        while (isActive) {
            System.out.println("\n0: exit");
            System.out.println("1: Print full names of students");
            System.out.println("2: Print all male students");
            System.out.println("3: Print all female students who has mark greater then 50.4");
            System.out.println("4: Print student information having the minimal mark");
            System.out.println("5: Print biggest male student information");
            System.out.println("6: Print students sorted by mark");
            System.out.println("7: Print female students sorted by year");
            System.out.print("\nCommand number: ");
            String comm = scanner.next();

            switch (comm) {
                case "0":
                    isActive = false;
                    break;
                case "1":
                    studentService.printFullNamesOfStudents(students);
                    break;
                case "2":
                    studentService.printAllMaleStudents(students);
                    break;
                case "3":
                    studentService.printAllFemaleWhoHasMarkGreaterThen_504(students);
                    break;
                case "4":
                    studentService.printStudentInformationHavingMinimalMark(students);
                    break;
                case "5":
                    studentService.printBiggestMaleStudentInformation(students);
                    break;
                case "6":
                    studentService.printStudentsSortedByMark(students);
                    break;
                case "7":
                    studentService.printFemaleStudentsSortedByYear(students);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
