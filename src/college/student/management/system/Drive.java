/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college.student.management.system;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Kate
 */
public class Drive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        printSep(); // print the separate lines method
        System.out.println("\nCollege-Student Management System");
        printSep(); // print the separate lines method

        // Initialization (files and exceptions)
        Student[] studentsArray = new Student[5]; // create array of 5 Students
        int studentIndex = 0; // define initial index for future students
        try {
            File input = new File("students.txt"); // create File object "input"
            Scanner reader = new Scanner(input); // read into the file students.txt
            while (reader.hasNextLine()) { // while file has a next line
                String studentLine = reader.nextLine(); // read next line
                try {
                    String[] studentInfo = studentLine.split(","); //  converting a string to an array using (,) as a delimiter 

                    // store the separated elements in the attributes of the students
                    String studentName = studentInfo[0]; // assign value of studentInfo[0] to variable studentName
                    int studentId = Integer.parseInt(studentInfo[1]); // cast studentInfo[1] from String to int and assign value to variable studentId (NumberFormatException)
                    String depName = studentInfo[2]; // assign value of studentInfo[2] to variable depName
                    double tuitionDue = Double.parseDouble(studentInfo[3]); // cast studentInfo[3] from string to double and assign value to variable tuitionDue (NumberFormatException)
                    Student student = new Student(studentName, studentId, depName, tuitionDue); // create an object Student using variable cretaed above
                    studentsArray[studentIndex] = student; // assign current student to studentsArray
                    studentIndex++; // add one to variable studentIndex, so that next student is put into next index of the array
                } catch (NumberFormatException e) { // catch the thrown exeption if failed to make a cast of the String to int/double
                    System.out.println("\nNumberFormatException occured while parsing line \"" + studentLine + "\". " + e.getMessage() + " - type is incorrect."); // print the information message about the Exception and continue runnig the programm
                } catch (ArrayIndexOutOfBoundsException e) { // catch the thrown Exeption if the number of indexes not 4
                    System.out.println("\nArrayIndexOutOfBoundsException occured while parsing studentLine. Line contains " + e.getMessage() + " elements (" + studentLine + ") instead of 4."); // print the information message about the Exception and continue runnig the programm
                }
            } // end while
            reader.close(); // to close the stream and release the resources

            printSep(); // the separate lines method

            // Operations and file writing
            System.out.println("\nTotal:");
            College collegeVanier = new College(studentsArray, "Vanier"); // create object College named Vanier using constructor from College class
            System.out.printf("Budget: %,.2f$\n", collegeVanier.getBudget());
            System.out.printf("Number of students: %d\n", collegeVanier.getStudentCount());
            System.out.printf("Department count: %d\n", collegeVanier.getDepartmentCount());

            // Write the result to a file       
            try {
                PrintStream myWriter = new PrintStream("VanierOutPut.txt"); // create a new File named "VanierOutPut.txt"
                myWriter.println("College name: " + collegeVanier.getCollegeName()); // first line - collegeName
                myWriter.println("Count of unique departments: " + collegeVanier.getDepartmentCount()); // second line - distinct DepartmentCount
                myWriter.println("Count of students in college: " + collegeVanier.getStudentCount()); // third line StudentCount
                myWriter.close(); // to close the stream and release the resources
            } // end try
            catch (IOException e) { // catch the thrown exeption if write to file failed and in such case the program does not halt execution
                System.out.println("An error ocured while trying to write to the file. " + e.getMessage()); // print the information message about the Exception
            } // end catch

        } catch (IOException e) { // catch the thrown exeption if there are problems with reading the file
            System.out.println("\nIOException occured while reading a file: " + e.getMessage()); // print the information message about the Exception and continue runnig the programm
        }
    } // end main

    public static void printSep() {
        System.out.println("__________________________________");
    }
} // end Drive class