/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentgrade;
import java.util.*;
/**
 *
 * @author Admin
 */
public class StudentGrade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> students = new ArrayList<>();

        students.add("Nithi");
        students.add("Mahi");
        students.add("Ifna");
        students.add("Maureen");

        Set<String> subjects = new HashSet<>();

        subjects.add("Java");
        subjects.add("Python");
        subjects.add("Data Structures");
        subjects.add("C");

        Map<String, String> grades = new HashMap<>();

        grades.put("Nithi", "A");
        grades.put("Mahi", "A+");
        grades.put("Ifna", "B");
        grades.put("Maureen", "A");

        Queue<String> queue = new LinkedList<>();

        queue.add("Nithi");
        queue.add("Mahi");
        queue.add("Ifna");
        queue.add("Maureen");

        System.out.println("===== STUDENT GRADE MANAGEMENT SYSTEM =====");

        System.out.println("\nStudent List:");
        for (String student : students) {
            System.out.println(student);
        }

        System.out.println("\nSubjects:");
        for (String subject : subjects) {
            System.out.println(subject);
        }

        System.out.println("\nStudent Grades:");
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.println(
                    entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nProcessing Queue:");

        while (!queue.isEmpty()) {
            System.out.println(
                    "Processing: " + queue.poll());
        }

        String searchStudent = "Nithi";

        System.out.println("\nSearching for: " + searchStudent);

        if (grades.containsKey(searchStudent)) {
            System.out.println(
                    "Grade of " + searchStudent +
                    " = " + grades.get(searchStudent));
        } else {
            System.out.println("Student not found.");
        }

        students.add("Nisha");
        grades.put("Nisha", "B+");

        System.out.println("\nAfter adding Nisha:");

        System.out.println("Students: " + students);
        System.out.println("Grades: " + grades);
    }

    }
    

