import java.util.ArrayList;
import java.util.List;

// College System

/* College System is a project which implement a concept
of OOP : Association, Aggregation, Cohesion, Coupling,
and it has 'HAS A' relationship between classes
this project is provide basic information about college,
and it has three different classes' student, department and
Institute which is in relation which each other without
inheritance.
 */

//Class Student which holds three parameter name, id and department.
class Student {

    //data members of class
    private final String name;
    private final int id;
    private final String dept;

    //parameterized constructor
    public Student(String name, int id, String dept) {
        this.name = name;
        this.id = id;
        this.dept = dept;
    }

    // method for returning string data to objects
    public String toString() {
        return "Name : " + name + " | ID : " + id + " | Department : " + dept;
    }

}

//class Department which contain list of all student and department name
class Department {

    // data members of class
    private final List<Student> students;
    private final String d_name;

    //parameterized constructor
    public Department(String name, List<Student> students) {
        this.d_name = name;
        this.students = students;
    }


    //method for returning list of student to institute class
    public List<Student> getStudents() {
        return students;
    }


    // method for returning string data to objects
    public String toString() {
        return d_name;
    }

    // used to return the name of department
    public String getName() {
        return d_name;
    }
}

// institute class which consist of list of departments and name of institute
class Institute {

    // data members of class
    private final String iname;
    private final List<Department> departments;

    //parameterized constructor
    public Institute(String name, List<Department> departments) {
        this.iname = name;
        this.departments = departments;
    }

    /* this method is used for return no of student
    in institute using student and department class object
     */
    public int getNoOfStudentsInInstitue() {
        int totalNoOfStudent = 0;
        List<Student> students;

        for (Department dept : departments) {
            students = dept.getStudents();

            for (Student s : students) {
                totalNoOfStudent++;
            }
        }
        return totalNoOfStudent;
    }


    // this method is used for returning name of institute
    public String getName() {
        return iname;
    }
}

//main class which calls and assign values to above 3 classes
public class Main {

    //main driver method
    public static void main(String[] args) {


        // constructing object and passing all details of student
        Student student1 = new Student("harsh", 114, "IT");
        Student student2 = new Student("bhargav", 115, "IT");
        Student student3 = new Student("arpit", 116, "IT");
        Student student4 = new Student("neel", 117, "EE");
        Student student5 = new Student("moin", 118, "EE");
        Student student6 = new Student("jaydip", 119, "MECH");
        Student student7 = new Student("darshan", 120, "MECH");

        //3 different arraylist for 3 different department
        ArrayList<Student> ITstu = new ArrayList<>();
        ArrayList<Student> EEstu = new ArrayList<>();
        ArrayList<Student> MECHstu = new ArrayList<>();

        // adding student objects in department arraylist
        ITstu.add(student1);
        ITstu.add(student2);
        ITstu.add(student3);
        EEstu.add(student4);
        EEstu.add(student5);
        MECHstu.add(student6);
        MECHstu.add(student7);

        /* constructing object of department class and passing name
        and department arraylist which contain student objects
         */
        Department department1 = new Department("IT", ITstu);
        Department department2 = new Department("EE", EEstu);
        Department department3 = new Department("MECH", MECHstu);

        // arraylist for passing list of department to institute classs
        List<Department> dept_list = new ArrayList<>();
        dept_list.add(department1);
        dept_list.add(department2);
        dept_list.add(department3);

        //constructing object of institute class and passing name and list of department list
        Institute institute = new Institute("Shantilal Shah Engineering College", dept_list);

        // displaying all details about college in nice way
        System.out.println("Name of Institute is : " + institute.getName());
        System.out.println("Total no of students in Institute is : " + institute.getNoOfStudentsInInstitue());
        System.out.println("Students in " + department1.getName() + " Department is :");
        for (Student stu : ITstu) {
            System.out.println(stu);
        }
        System.out.println("Students in " + department2.getName() + " Department is :");
        for (Student stu : EEstu) {
            System.out.println(stu);
        }
        System.out.println("Students in " + department3.getName() + " Department is :");
        for (Student stu : MECHstu) {
            System.out.println(stu);
        }
    }
}
