package backend;

import java.io.IOException;
import java.sql.Struct;
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
    public boolean removeStudent(String id) throws Exception {
        database.deleteRecord(id);
        database.saveToFile();
        return true;
    }
    public Student findStudent(String id) {
        return database.getRecord(id);
    }
    public ArrayList<Student> getAllStudents() {
        return database.returnAllRecords();
    }
    public boolean updateStudent(Student s) throws Exception {
        database.updateRecord(s);
        database.saveToFile();
        return true;
    }
    public void logout() throws IOException{
        database.saveToFile();
    }
}
