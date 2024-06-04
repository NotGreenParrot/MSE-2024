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
    @SuppressWarnings("resource")
    public static void parseRec() {
        try {  
            
        ArrayList<Student> list = new ArrayList<Student>();
        
        ArrayList<Teacher> list2 = new ArrayList<Teacher>();
        File file = new File("/workspaces/MSE-2024/datastore/_2023 NHS Teacher Recommendation Form (Responses for Project) .xlsx");   //creating a new file instance  
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

        for(int i = 0; i < 7; i++){
            if(row.getRowNum()==0 || row.getRowNum()==1){
            continue; //just skip the rows if row number is 0 or 1
           }
            cell = cellIterator.next();
        }

        //cell = cellIterator.next();
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


        Student add = new Student(first, last, id, recs);

        int loc = -1; // location of teacher in the teacher arraylist
        for(int i = 0; i < list2.size(); i++){
           Teacher t = list2.get(i);
            if(teacher.equals(t.getLast())){
                loc = i;
            }
        } 
        
        if(loc == -1){ // creates new teacher object if teacher not found, otherwise adds the student to existing teacher
            Teacher teach = new Teacher(teacher, email);
            list2.add(teach);
            teach.add(add);
        } else {
            list2.get(loc).add(add);
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

         for(int i = 0; i < list2.size(); i++){
            list2.get(i).print();
            System.out.println();
        }
        }  
        System.out.println("");  
        }  
        }  
        catch(Exception e)  
        {  
        e.printStackTrace();  
        }  
    }

    public static void parseReq() {
        
        try {  
            ArrayList<Student> list = new ArrayList<Student>();
            
            ArrayList<Teacher> list2 = new ArrayList<Teacher>();
            File file = new File("/workspaces/MSE-2024/datastore/NHS Teacher Rec Requests .xlsx");   //creating a new file instance  
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
    
           
    
    

            System.out.println(id);
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
