public class Student {
    private String firstName;
    private String nickName;
    private String lastName;
    private int studentID;

    public Student(String first, String nick, String last, int ID){
        firstName = first;
        nickName = nick;
        lastName = last;
        studentID = ID;
    }

    public Student(String first, String last, int ID){
        firstName = first;
        nickName = first;
        lastName = last;
        studentID = ID;
    }

    public String toString(){
        if(firstName.equals(nickName)){
            return firstName + " " + lastName + " ID: " + studentID;
        }
        return firstName + " \"" + nickName + "\" " + lastName + " ID: " + studentID;
    }

    
}
