import java.io.File;  
import java.io.FileInputStream;  
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
import java.util.ArrayList;


public class Parse{
    public static void main(String[] args){
        parseRec();
    }
    public static void parseRec() { // parses through teacher recs
            
        ArrayList<Student> list = new ArrayList<Student>();
        
        ArrayList<Teacher> list2 = new ArrayList<Teacher>();
        try {  
        
        File file = new File("/workspaces/MSE-2024/datastore/Untitled spreadsheet.xlsx");   //creating a new file instance  
        FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
        //creating Workbook instance that refers to .xlsx file  
        XSSFWorkbook wb = new XSSFWorkbook(fis);   
        XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
        Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
        for(int i = 0; i < 1; i++){
            itr.next();
        } // set up the Apache POI

        while (itr.hasNext()) {  
        Row row = itr.next();  
        Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
        cellIterator.next(); //set up and iterate through rows
         
        Cell cell = cellIterator.next(); 
        if(!checkIfRowIsEmpty(row) /* || row.getCellType() == Cell.CELL_TYPE_BLANK*/) {
        String email;
        if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
            email = cell.getStringCellValue();
        } else {
            email = "";
        }
        
        cell = cellIterator.next();
        String teacher;
        if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
            teacher = cell.getStringCellValue();
        } else {
            teacher = "";
        }

        cell = cellIterator.next();
        String last;
        if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
            last = cell.getStringCellValue();
        } else {
            last = "";
        }

        cell = cellIterator.next();
        String first;
        if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
            first = cell.getStringCellValue();
        } else {
            first = "";
        }

        cell = cellIterator.next();
        int id;
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            id = (int)cell.getNumericCellValue();
        } else {
            id  = 0;
        }

        boolean real = false;
        ArrayList<Integer> rate = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            //if(row.getRowNum()==0 || row.getRowNum()==1){
            //continue; //just skip the rows if row number is 0 or 1
           //}
           
           if(i > 0){
            cell = cellIterator.next();
            if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                int num = (int)cell.getNumericCellValue();
                if(num < 4){
                    real = true;
                }
                rate.add(num);
            }
           } else {
            cellIterator.next();
           }
        }

        cell = cellIterator.next();
        String rec;
        if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
            rec = cell.getStringCellValue();
        } else {
            rec  = "";
        }
        boolean recs;
        if(rec.equals("")){
            recs = false;
        } else if (rec.substring(0,1).equals("Y")){
            recs = true;
        } else {
            recs = false;
        }


        Teacher teach = new Teacher(teacher, email,recs,rate);
        Student add = new Student(first, last, id);

        for(int k = 0; k < rate.size(); k++){
            if(rate.get(k) < 4){
                add.isSubThree();
            }
        }

        int loc = -1; // location of teacher in the teacher arraylist
        for(int i = 0; i < list.size(); i++){
           Student t = list.get(i);
            if(t.equals(add)){
                loc = i;
            }
        } 
        
        if(loc == -1){ // creates new teacher object if teacher not found, otherwise adds the student to existing teacher
        Student added = new Student(first, last, id);
            added.addTeach(teach);
            list.add(added);
        } else {
            list.get(loc).addTeach(teach);
        }

        /*switch (cell.getCellType()){  
        case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
        System.out.print(cell.getStringCellValue() + "\t\t\t");  
        break;  
        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
        System.out.print(cell.getNumericCellValue() + "\t\t\t");  
        break;  
        default:  
         }  */

         
        }  
        System.out.println("");  
        }  
        }  
        catch(Exception e)  
        {  
        e.printStackTrace();  
        }  
        for(int i = 0; i < list.size(); i++){
            list.get(i).printOut();
            System.out.println();
        }
    }

    public static void parseReq() { // parses through student requests
        ArrayList<Student> list = new ArrayList<Student>();
            
        ArrayList<Teacher> list2 = new ArrayList<Teacher>();
        try {  
            
            File file = new File("/workspaces/MSE-2024/datastore/Untitled spreadsheet (1).xlsx");   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
            //creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);   
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  `
            for(int i = 0; i < 1; i++){
                itr.next();
            } // set up the Apache POI
    
            while (itr.hasNext()) {  
            Row row = itr.next();  
            Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column 
            //cellIterator.next(); //set up and iterate through rows
             
            Cell cell = cellIterator.next(); 
            if(!checkIfRowIsEmpty(row) /* || row.getCellType() == Cell.CELL_TYPE_BLANK*/) {
            
            //cell = cellIterator.next();
            String last;
            if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                last = cell.getStringCellValue();
            } else {
                last = "";
            }

            cell = cellIterator.next();
            String first;
            if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                first = cell.getStringCellValue();
            } else {
                first = "";
            }

                
            cell = cellIterator.next();
            int id;
            if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                id = (int)cell.getNumericCellValue();
            } else {
                id  = 0;
            }
    
           
    
    

            for(int j = 0; j < 5; j++){
                cell = cellIterator.next();
                String email;
                if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    email = cell.getStringCellValue();
                } else {
                    email = "[NO EMAIL PROVIDED]";
                }

                if(email.indexOf('@')!=-1){
                    email = email.substring(0,email.indexOf('@'));
                } else if(email.lastIndexOf('2')!=-1) {
                    email = email.substring(0, email.indexOf('2'));
                } else {
                    email = "[POOR EMAIL FORMAT]" +email;
                }


                int loc = -1; // location of teacher in the teacher arraylist
                for(int i = 0; i < list2.size(); i++){
                  Teacher t = list2.get(i);
                    if(email.equals(t.getEmail())){
                    loc = i;
                    }
                } 
            
                Student add = new Student(first, last, id);
                if(loc == -1){ // creates new teacher object if teacher not found, otherwise adds the student to existing teacher
                   Teacher teach = new Teacher(email);
                   list2.add(teach);
                   teach.add(add);
                } else {
                    list2.get(loc).add(add);
                }
            }
            /*switch (cell.getCellType()){  
            case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
            System.out.print(cell.getStringCellValue() + "\t\t\t");  
            break;  
            case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
            System.out.print(cell.getNumericCellValue() + "\t\t\t");  
            break;  
            default:  
             }  */
             
            }  
            System.out.println("");  
            }  
            }  
            catch(Exception e)  
            {  
            e.printStackTrace();  
            }  
            for(int i = 0; i < list2.size(); i++){
                list2.get(i).print();
                System.out.println();
            }
            
    }

    private static boolean checkIfRowIsEmpty(Row row) { // checks if row is empty
        if (row == null) {
            return true;
        }
        if (row.getLastCellNum() <= 0) {
            return true;
        }
        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                return false;
            }
        }
        return true;
    }
}
