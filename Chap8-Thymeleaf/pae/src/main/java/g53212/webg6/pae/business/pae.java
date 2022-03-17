package g53212.webg6.pae.business;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import g53212.webg6.pae.model.*;

@Service
public class pae {

    public static ArrayList<Course> createCourses() {
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("INT1", "Introductions", 10));
        courses.add(new Course("MAT1", "Mathématiques 2", 3));
        courses.add(new Course("CAI1", "Anglais 1", 2));
        courses.add(new Course("DEV1", "Développement 1", 10));
        courses.add(new Course("DEV2", "Développement 2", 10));
        return courses;
    }

    public static ArrayList<Student> createStudents() {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student(12345, "Mols", "GESTION"));
        students.add(new Student(54321, "Aetyh", "INDUSTRIELLE"));
        students.add(new Student(23456, "Getyu", "RESEAU"));
        students.add(new Student(65432, "Ckjhg", "INDUSTRIELLE"));
        students.add(new Student(34567, "Reau", "GESTION"));
        return students;
    }
}