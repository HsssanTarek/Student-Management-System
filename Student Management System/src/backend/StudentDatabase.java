
package backend;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StudentDatabase {
    private ArrayList<Student> records = new ArrayList<>();
    private String filename;

    public StudentDatabase(String filename)
    {
        this.filename=filename;
    }
    public void readFromFile()throws Exception {
        File f = new File(filename);
        if (!f.exists()) {
            throw new IOException("File not found: " + filename);
        }
        Scanner file = new Scanner(f);
        while(file.hasNextLine())
        {
            String line = file.nextLine();
            if(!line.isEmpty())
            {
                Student record=createRecordFrom(line);
                if (record!=null)
                    records.add(record);
            }
        }
        file.close();

    }
    public Student createRecordFrom(String line){
        String[] record = line.split(",");
        if (record.length==6) {
            String studentID = record[0].trim();
            String fullName = record[1].trim();
            String department = record[2].trim();
            String gender=record[3].trim();
            int age = Integer.parseInt(record[4].trim());
            double gpa = Double.parseDouble(record[5].trim());
            return new Student(studentID,fullName,department,gender, age, gpa);
        }
        else return null;
    }
    public ArrayList<Student> returnAllRecords(){
        return records;
    }
    public boolean contains(String Id ){
        for(Student record : records)
        {
            if (record.getStudentID().equals(Id)){
        
                return true;
            }
        }
        return  false;
    }
    public Student  getRecord(String Id){
        for(Student record : records)
        {
            if (record.getStudentID().equals(Id))
            {
                return record;
            }
        }
        return null;
    }
    public void insertRecord(Student record) throws Exception {
        if (contains(record.getStudentID()))
            throw new Exception("Record already exists!");
        records.add(record);
    }
    public void deleteRecord(String Id) throws Exception {
        Student record = getRecord(Id);
        if(record ==null)
            throw new Exception("Record not found!");
        records.remove(record);
    }
    public void updateRecord(Student bro)throws Exception{//MIGHT NEED TO CHANGE THIS ONEE
        Student record =getRecord(bro.getStudentID());
        if(record==null){
            throw new Exception("Record does not exist!");
        }
        
            record.setFullName(bro.getFullName());
            record.setDepartment(bro.getDepartment());
            record.setAge(bro.getAge());
            record.setGPA(bro.getGPA());
            }


    public void saveToFile() throws IOException{
        PrintWriter fw = new PrintWriter(new FileWriter(filename));
        for (Student record : records)
        {
            fw.println(record.lineRepresentation());
        }
        fw.close();
    }
}
