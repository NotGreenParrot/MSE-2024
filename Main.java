import java.io.IOException;
import java.util.Properties;

public class Main{
    public static void main(String[] args ) throws IOException{
        System.out.println("Hello World!");
        //Parse.parseRec();
        Parse.parseReq();
        Properties properties = new Properties();
/*to access your filename.properties file */
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("filename.properties"));
        String  sServerLocation = properties.getProperty("server.upload.docs.path");
        System.out.println(sServerLocation);
    }
}