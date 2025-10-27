
package backend;
import java.util.Arrays;
public class Student {
    private String fullName;
    private int studentID;
    private String department;
    private String gender;
    private int age;
    private double gpa;
    public static final String[] Deps={"computer" ,"mechanical","electrical","architectural","industrial"};
    public static final String[] Genders={"female","male"};
    public Student(int studentID, String fullName, String department ,String gender,int age,double gpa){
        if (studentID < 0) {
            throw new IllegalArgumentException("Student ID must be positive numbers!");
        }
        if (fullName == null || fullName.isEmpty()||fullName.matches(".*\\d.*"))
            throw new IllegalArgumentException("Invalid Name");
        if (gender==null||gender.isEmpty()||!Arrays.asList(Genders).contains(gender.toLowerCase()))
            throw new IllegalArgumentException("Invalid Gender");
        if(department==null||department.isEmpty()||!Arrays.asList(Deps).contains(department.toLowerCase()))
            throw new IllegalArgumentException("Invalid Department");
        if( age <16)
            throw new IllegalArgumentException("Invalid Age");
        if (gpa<=0.0||gpa>4.0)
            throw new IllegalArgumentException("Invalid GPA");

        this.fullName=fullName;
        this.studentID=studentID;
        this.department=department.toLowerCase();
        this.gender=gender.toLowerCase();
        this.age=age;
        this.gpa=gpa;
    }

    public String getFullName(){
        return fullName;
    }
    public String getDepartment(){
        return department;
    }
    public int getStudentID(){
        return studentID;
    }
    public double getGPA(){
        return gpa;
    }
    //before calling any setter make sure that inputs are trimmed!!

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age){
        if( age <16)
            throw new IllegalArgumentException("Invalid Age");
        this.age=age;
    }
    public void setDepartment(String department){
        if(department==null||department.isEmpty()||!Arrays.asList(Deps).contains(department.toLowerCase()))
            throw new IllegalArgumentException("Invalid Department");
        this.department=department;
    }
    public void setFullName(String fullName){
        if (fullName == null || fullName.isEmpty()||fullName.matches(".*\\d.*"))
            throw new IllegalArgumentException("Invalid Name");
        this.fullName=fullName;
    }
    public void setGPA(double gpa){
        if (gpa<=0.0||gpa>4.0)
            throw new IllegalArgumentException("Invalid GPA");
        this.gpa=gpa;
    }

    public void setGender(String gender) {
        if (gender==null||gender.isEmpty()||!Arrays.asList(Genders).contains(gender.toLowerCase()))
            throw new IllegalArgumentException("Invalid Gender");
        this.gender = gender;
    }

    public String lineRepresentation(){
        return studentID + "," + fullName + "," + department + "," + gender + "," + age + "," + gpa;
    }
}
