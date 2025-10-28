package backend;

import java.io.IOException;
import java.util.ArrayList;

public class StudentService {
    private StudentDatabase database;
    public StudentService()  throws Exception {
        database = new StudentDatabase("Students.txt");
        database.readFromFile();
    }
    public void addStudent( String fullName, String department ,String gender,int age,double gpa) throws Exception {
        int studentID=generateNextID();
        Student s= new Student(studentID,fullName, department ,gender,age,gpa);
        database.insertRecord(s);
        database.saveToFile();
    }
    public void addStudent(int studentID, String fullName, String department ,String gender,int age,double gpa) throws Exception {
        Student s= new Student(studentID,fullName, department ,gender,age,gpa);
        database.insertRecord(s);
        database.saveToFile();
    }
    public void removeStudent(int id) throws Exception {
        database.deleteRecord(id);
        database.saveToFile();
    }
    public Student findStudent(String key) {
        if (key.matches("\\d+")) {
            int id = Integer.parseInt(key);
           return database.getRecord(id);}
        else
            return database.getRecord(key);}
    public ArrayList<Student> getAllStudents() {
        return database.returnAllRecords();
    }
    public void updateStudent(int studentID, String fullName, String department ,String gender,int age,double gpa)throws Exception {
        Student s= new Student(studentID,fullName, department ,gender,age,gpa);
        database.updateRecord(s);
        database.saveToFile();
    }
    public void logout() throws IOException{
        database.saveToFile();
    }
    private int generateNextID() {
        ArrayList<Student> students = getAllStudents();
        if (students.isEmpty()) return 1000;
        int lastID = students.get(students.size() - 1).getStudentID();
        return lastID + 1;
    }
}
