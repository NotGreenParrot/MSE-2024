import java.util.ArrayList;
public class Teacher {


    private String lastName;
    private String email; // without @mcpsmd.xxx
    private ArrayList<Student> list;
    private boolean isRecommended;
    public ArrayList<Integer> ratings;


    public Teacher(String last, String address, boolean rec, ArrayList<Integer> rate){
        lastName = last;
        email = address;
        list = new ArrayList<Student>();
        isRecommended = rec;
        ratings = rate;
    }

    public Teacher(String address, boolean rec){
        lastName = "";
        email = address;
        list = new ArrayList<>();
        isRecommended = rec;
        ratings = new ArrayList<>();
    }

    public Teacher(String address){
        lastName = "";
        email = address;
        list = new ArrayList<>();
        ratings = new ArrayList<>();
    }

    public void add(Student g){
        list.add(g);
    }

    public void print(){
            System.out.println(lastName + " \n" + email + "@mcpsmd.org");
            for(Student i : list){
                System.out.println(i.toString());
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
    public boolean isRec(){
        return isRecommended;
    }

    public void addRate(int t){
        ratings.add(t);
    }

    public ArrayList<Integer> getRate(){
        return ratings;
    }
}
