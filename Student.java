import java.util.ArrayList;;
public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private ArrayList<Teacher> list;
    private boolean subThree;

    public Student(String first, String last, int ID){
        firstName = first;
        lastName = last;
        studentID = ID;
        list = new ArrayList<Teacher>();
        subThree = false;
    }

    public String getLast(){
        return lastName;
    }

    public boolean equals(Student other){
        return this.lastName.equals(other.lastName) && this.studentID == other.studentID;
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
        if(subThree == true){
            System.out.print("[HAS RATING OF 3 OR LOWER]");
        }
        System.out.println(firstName + " " + lastName + " (" + studentID + ") Recs:");
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).isRec()){
                System.out.print("DOES NOT RECOMMEND - ");
            }
            
            System.out.print(list.get(i).getLast() + "(");
            for(int j = 0; j < list.get(i).getRate().size(); j++){
                for(int k = 0; k < list.get(i).getRate().size(); k++){
                    if(list.get(i).getRate().get(k) < 4){
                    }
                }

                System.out.print(list.get(i).getRate().get(j) + " ");
            }
            
            System.out.println(")");
        }
    }

    public void isSubThree(){
        subThree = true;
    }

    
}
