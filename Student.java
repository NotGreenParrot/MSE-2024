import java.util.ArrayList;;
public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private ArrayList<Teacher> list;

    public Student(String first, String last, int ID){
        firstName = first;
        lastName = last;
        studentID = ID;
        list = new ArrayList<Teacher>();
    }

    public boolean equals(Student other){
        return firstName.equals(other.firstName) && studentID == other.studentID;
    }

    public String toString(boolean rec){
        if(rec){
            return "YES, RECOMMENDED - " + firstName + " " + lastName + " ID: " + studentID;
        } else {
            return "NO, NOT RECOMMENDED - " + firstName + " " + lastName + " ID: " + studentID;
        }
            
    }

    public String toString(){
            return firstName + " " + lastName + " ID: " + studentID;
            
    }

    public void addTeach(Teacher t){
        list.add(t);
    }

    public void print(){
        System.out.println(toString());
        for(int i = 0; i < list.size(); i++){
            Teacher t = list.get(i);
            System.out.print(t.getLast());
            if(t.isRec()){
                System.out.println(" - YES, RECOMMENDED");
            } else {
                System.out.println(" - NO, NOT RECOMMENDED");
            }
        }
        
    }

    public void printOut(){
        System.out.println(first + last + id);
    }

    
}
