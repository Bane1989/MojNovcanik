import com.sun.jdi.event.ExceptionEvent;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Banka banka = new Banka("Banka - Rupa bez dna");
        while(true) {
            banka.glavniMeni();

            boolean running = true;
            while(running) {
                try {
                    banka.odabirOpcijaUBanci(banka.getUlogovanKorisnik());
                } catch (Exception e) {
                    running = false;
                }
            }
        }
    }












}
