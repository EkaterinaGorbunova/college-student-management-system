/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package college.student.management.system;

/**
 *
 * @author Kate
 */
public class Student {

    private String studentName;
    private int studentId;
    private String depName;
    private double tuitionDue; // debt

    public Student(String studentName, int studentId, String depName, double tuitionDue) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.depName = depName;
        this.tuitionDue = tuitionDue;

        System.out.println(this.toString());
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setTuitionDue(double tuitionDue) {
        this.tuitionDue = tuitionDue;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getDepName() {
        return depName;
    }

    public double getTuitionDue() {
        return tuitionDue;
    }

    @Override
    public String toString() {
        return String.format("\nStudent's name: %s\nStudent's ID: %d\nStudent's department: %s\nStudent's tuitionDue: %,.2f$",
                getStudentName(), getStudentId(), getDepName(), getTuitionDue());
    } // end method @Override
} // end Student class
