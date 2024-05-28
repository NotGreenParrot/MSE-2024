public class Main{
    public static void main(String[] args){
        System.out.println("Hello World!");
        Parse.parseRec();
        for(int i = 0; i < Parse.list2.size(); i++){
            Parse.list2.get(i).print();
            System.out.println();
        }
    }
}