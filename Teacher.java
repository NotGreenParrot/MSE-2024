import java.util.ArrayList;
public class Teacher {


    private String firstName;
    private String lastName;
    private String email; // without @mcpsmd.xxx
    private ArrayList<Student> list;
    private String department;


    public Teacher(String first, String last, String address, String dept){
        firstName = first;
        lastName = last;
        email = address;
        list = new ArrayList<Student>();
        department = dept;
    }

    public void add(Student g){
        list.add(g);
    }

    public void print(){
            System.out.println(firstName + " " + lastName + " (" + department + ") \n" + email);
            for(Student i : list){
                System.out.println(i);
            }
    }
}
