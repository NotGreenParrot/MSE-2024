import java.util.ArrayList;
public class Teacher {


    private String lastName;
    private String email; // without @mcpsmd.xxx
    private ArrayList<Student> list;


    public Teacher(String last, String address){
        lastName = last;
        email = address;
        list = new ArrayList<Student>();
    }

    public Teacher(String address){
        lastName = "";
        email = address;
        list = new ArrayList<>();
    }

    public void add(Student g){
        list.add(g);
    }

    public void print(){
            System.out.println(lastName + " \n" + email);
            for(Student i : list){
                System.out.println(i);
            }

            String out = "";
            for(Student i : list){
                
            }
    }

    public String getLast(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }
}
