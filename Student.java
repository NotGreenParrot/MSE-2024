public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private boolean isRecommended;

    public Student(String first, String last, int ID){
        firstName = first;
        lastName = last;
        studentID = ID;
        isRecommended = false;
    }

    public Student(String first, String last, int ID, boolean rec){
        firstName = first;
        lastName = last;
        studentID = ID;
        isRecommended = rec;
    }

    public String toString(){
        if(isRecommended){
            return "YES, RECOMMENDED - " + firstName + " " + lastName + " ID: " + studentID;
        } else {
            return "NO, NOT RECOMMENDED - " + firstName + " " + lastName + " ID: " + studentID;
        }
            
    }

    
}
