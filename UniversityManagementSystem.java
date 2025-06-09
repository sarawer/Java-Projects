package com.mycompany.universitymanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class UniversityManagementSystem  {
    
    static ArrayList<Student> studentList = new ArrayList<>();
    static ArrayList<Faculty> facultieList = new ArrayList<>();
    static ArrayList<Course> courseList = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- University Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Faculty");
            System.out.println("4. View Faculties");
            System.out.println("5. Add Course");
            System.out.println("6. View Courses");
            System.out.println("7. Update Student");
            System.out.println("8. Delete Student");
            System.out.println("9. Search Student");
            System.out.println("10. Update Faculty");
            System.out.println("11. Delete Faculty");
            System.out.println("12. Search Faculty");
            
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            if(choice==1){
                System.out.println("Enter Name: ");
                String name=scanner.nextLine();
                System.out.println("Enter Id:");
                String id=scanner.nextLine();
                System.out.println("Enter Department: ");
                String dpt=scanner.nextLine();
                System.out.println("credit completed: ");
                int cc=scanner.nextInt();
                studentList.add(new Student(name,id, dpt,cc));
                System.out.println("Student data added successfully");
                
            }else if(choice==2){
                if (studentList.isEmpty()) {
                    System.out.println("No students available.");
                    } else {
                    for(Student u : studentList){
                        u.displayinfo();
                    }
                }
            }else if(choice==3){
                System.out.println("Enter Name: ");
                String name=scanner.nextLine();
                System.out.println("Enter Id:");
                String id=scanner.nextLine();
                System.out.println("Specialization:");
                String Specialization=scanner.nextLine();
                facultieList.add(new Faculty(name,id,Specialization));
            }else if(choice==4){
                  if (facultieList.isEmpty()) {
                    System.out.println("No faculty members available.");
                    } else {
                        for(Faculty u : facultieList){
                            u.displayinfo();
                        }
                    }
            }else if(choice==5){
                System.out.println("Enter Course Title: ");
                String CourseTitle=scanner.nextLine();
                System.out.println("Enter Course Code:");
                String CourseCode=scanner.nextLine();
                courseList.add(new Course(CourseTitle,CourseCode));
            }else if(choice==6){
                  if (courseList.isEmpty()) {
                    System.out.println("No courses available.");
                } else {
                    for(Course u : courseList){
                        u.displayinfo();
                    }
                }
            }else if(choice==7){
                System.out.print("Enter Student ID to update: ");
                String id = scanner.nextLine();
                boolean found = false;
                for (Student s : studentList) {
                    if (s.id.equals(id)) {
                        System.out.print("Enter New Name: ");
                        s.name = scanner.nextLine();
                        System.out.print("Enter New Department: ");
                        s.department = scanner.nextLine();
                        System.out.print("Enter New Credit Completed: ");
                        s.CreditsCompleted = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.println("Student updated successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            }else if(choice==8){
                System.out.print("Enter Student ID to delete: ");
                String id = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).id.equals(id)) {
                        studentList.remove(i);
                        System.out.println("Student deleted successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            }else if(choice==9){
                System.out.print("Enter Student ID to search: ");
                String id = scanner.nextLine();
                boolean found = false;
                for (Student s : studentList) {
                    if (s.id.equals(id)) {
                        s.displayinfo();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Student not found.");
                }
            }else if(choice==10){
                System.out.print("Enter Faculty ID to update: ");
                String id = scanner.nextLine();
                boolean found = false;
                for (Faculty f : facultieList) {
                    if (f.id.equals(id)) {
                        System.out.print("Enter New Name: ");
                        f.name = scanner.nextLine();
                        System.out.print("Enter New Specialization: ");
                        f.Specialization = scanner.nextLine();
                        System.out.println("Faculty updated successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Faculty not found.");
                }
            }else if(choice==11){
                System.out.print("Enter Faculty ID to delete: ");
                String id = scanner.nextLine();
                boolean found = false;
                for (int i = 0; i < facultieList.size(); i++) {
                    if (facultieList.get(i).id.equals(id)) {
                        facultieList.remove(i);
                        System.out.println("Faculty deleted successfully.");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Faculty not found.");
                }
            }else if(choice==12){
                System.out.print("Enter Faculty ID to search: ");
                String id = scanner.nextLine();
                boolean found = false;
                for (Faculty f : facultieList) {
                    if (f.id.equals(id)) {
                        f.displayinfo();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Faculty not found.");
                }
            }else if (choice == 0) {
                System.out.print("Are you sure you want to exit? (yes/no): ");
                String confirmation = scanner.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    System.out.println("Exiting system. Goodbye!");
                    break; 
                } else {
                    System.out.println("Exit canceled. Returning to main menu.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
     
        }
    }
    
    public static class Student {
    String name;
    String id;
    String department;
    int CreditsCompleted;
    Student( String name,String id,String department,int CreditsCompleted){
        this.name=name;
        this.department=department;
        this.id=id;
        this.CreditsCompleted=CreditsCompleted;
    }
    
    void displayinfo(){
    System.out.println("======================================");
    System.out.println("         Student Information          ");
    System.out.println("======================================");
    System.out.println("Name               : " + name);
    System.out.println("ID                 : " + id);
    System.out.println("Department         : " + department);
    System.out.println("Credits Completed  : " + CreditsCompleted);
    System.out.println("Status             : " + (CreditsCompleted > 150 ? "Graduated" : "Running Student"));
    System.out.println("======================================");
}

    
    }
    
    public static class Faculty {
    String name;
    String id;
    String Specialization;
    
    Faculty(String name,String id, String Specialization){
        this.name=name;
        this.id=id;
        this.Specialization=Specialization;
    }
    
    void displayinfo(){
    System.out.println("======================================");
    System.out.println("         Faculty Information          ");
    System.out.println("======================================");
    System.out.println("Name           : " + name);
    System.out.println("ID             : " + id);
    System.out.println("Specialization : " + Specialization);
    System.out.println("======================================");
    }

    
}
    
    public static class Course {
    String CourseTitle;
    String CourseCode;
    
    Course( String CourseTitle,String CourseCode){
        this.CourseCode=CourseCode;
        this.CourseTitle=CourseTitle;
    }
    
    void displayinfo(){
    System.out.println("======================================");
    System.out.println("         Course Information           ");
    System.out.println("======================================");
    System.out.println("Title : " + CourseTitle);
    System.out.println("Code  : " + CourseCode);
    System.out.println("======================================");
}

    
}

}
