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
public class College implements School {

    private Student[] students; // create an attribute "students" (array of Student); also this way the two classes Student and College are linked
    private double budget;
    private int departmentCount; // count of the distinct department names
    private String collegeName;

    public College(Student[] students, String collegeName) {
        this.students = students;
        this.collegeName = collegeName;

        System.out.println(this.toString()); // print collegeName
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Student[] getStudents() {
        return students;
    }

    public String getCollegeName() {
        return collegeName;
    }

    @Override
    public double getBudget() {
        double debt = 0.0; // initialize and assign the value 0.0 to the debt variable 
        for (Student currentStudent : students) { // go through all elements of array students
            debt = debt + currentStudent.getTuitionDue(); // adding tuitionDue of each student to debt variable
        }
        return debt; // return sum of tuitionDue
    }

    @Override
    public int getDepartmentCount() {
        departmentCount = 1; // start from index [1] to comparing with index [0]
        for (int i = 1; i < students.length; i++) { // go through all indexes of array students, starting from index 1
            boolean depUnique = true; // boolean variable showing if value of specific element was not seen before
            for (int j = 0; j < i; j++) { // go through all indexes of array students, starting from index 0 and till index i (not incuding) 
                if ((students[i].getDepName()).equals(students[j].getDepName())) { // comparing element with index i with all elements before (using index j)
                    depUnique = false;  // if element with index i equels any element with indexes between 0 and (i-1) - element with index i was already seen before and is not unique
                    break; // exit for loop (j) as we already know that element with index i is not unique.
                }
            }
            if (depUnique) {
                departmentCount++;
            }
        }
        return departmentCount; // return count of the distinct department names
    }

    @Override
    public int getStudentCount() {
        return this.getStudents().length; // return the size of the array of students
    }

    @Override
    public String toString() {
        return String.format("\nCollege's name: %s", getCollegeName());
    }
}
