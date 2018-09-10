import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.management.ManagementFactory;


public class monitorjbl {
    private static String fileName = "D://up1k.xlsx";
    public static void main(String[] args) throws IOException {
        System.out.println(ManagementFactory.getRuntimeMXBean().getName());
        long start = System.currentTimeMillis();
        System.out.println("start 111111");
        monotorjbl();
        System.out.println("end 11111 , time :" + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("start XSSF");
        XSSF();
        System.out.println("end XSSF , time :" + (System.currentTimeMillis() - start));

//        HSSF();
    }


    public static void monotorjbl() throws IOException {
        InputStream is = new FileInputStream(new File(fileName));
        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(500)    // number of rows to keep in memory (defaults to 10)
                .bufferSize(1024)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);            // InputStream or File for XLSX file (required)

        for (int i=0; i<  workbook.getNumberOfSheets(); ++i){
            Sheet sheet = workbook.getSheetAt(i);
            System.out.println(sheet.getSheetName());
            for (Row r : sheet) {
                for (Cell c : r) {
//                    System.out.println(c.getStringCellValue());
                }
            }
        }

        System.out.println("monotorjbl is running ...........");
    }

    public static void XSSF() throws IOException {
        InputStream is = new FileInputStream(new File(fileName));
        System.out.println("xssf 1111111111");
        Workbook workbook  = new XSSFWorkbook(is);
        System.out.println("xssf 222222222222");
        for (int i=0; i<  workbook.getNumberOfSheets(); ++i){
            Sheet sheet = workbook.getSheetAt(i);
            System.out.println(sheet.getSheetName());
            for (Row r : sheet) {
                for (Cell c : r) {
//                    System.out.println(c.getStringCellValue());
                }
            }
        }
    }




    public static void HSSF() throws IOException {
        InputStream is = new FileInputStream(new File(fileName));
        Workbook workbook  = new HSSFWorkbook(is);

        for (int i=0; i<  workbook.getNumberOfSheets(); ++i){
            Sheet sheet = workbook.getSheetAt(i);
            System.out.println(sheet.getSheetName());
            for (Row r : sheet) {
                for (Cell c : r) {
                    System.out.println(c.getStringCellValue());
                }
            }
        }
    }

}
