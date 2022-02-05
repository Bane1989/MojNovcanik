import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Excel {

    static XSSFWorkbook wb = new XSSFWorkbook();
    static XSSFSheet sheet;
    static OutputStream fajl;

    static {
        try {
            fajl = new FileOutputStream("mojFajl.xlsx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
