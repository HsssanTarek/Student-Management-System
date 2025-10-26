package backend;

import java.io.IOException;
import java.util.ArrayList;

public class StudentService {
    private StudentDatabase database;
    public StudentService()  throws Exception {
        database = new StudentDatabase("Students.txt");
        database.readFromFile();
    }
    public void addStudent(Student s) throws Exception {
        database.insertRecord(s);
        database.saveToFile();
    }
    public void removeStudent(String id) throws Exception {
        database.deleteRecord(id);
        database.saveToFile();
    }
    public Student findStudent(String id) {
        return database.getRecord(id);
    }
    public ArrayList<Student> getAllStudents() {
        return database.returnAllRecords();
    }
    public void updateStudent(Student s) throws Exception {
        database.updateRecord(s);
        database.saveToFile();
    }
    public void logout() throws IOException{
        database.saveToFile();
    }
}
