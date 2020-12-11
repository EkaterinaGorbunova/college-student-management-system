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
public interface School {

    //methods are implemented in the College class
    double getBudget(); // method should return sum of the tuitionDue of all of the atudent
    int getDepartmentCount(); // method should return the count of the distinct department names of the students
    int getStudentCount(); // method should return the size of the array of students    
}
