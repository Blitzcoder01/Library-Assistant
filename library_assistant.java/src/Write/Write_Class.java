package Write;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write_Class {
    private static final String FILE_NAME = "Library.xlsx";

    public void write() {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Library database");
        Object[][] datatypes = {
                {"BOOK_TITLE", "AUTHOR", "QUANTITY", "LOCATION"},
                {"Effective Java", "Joshua Bloch", 10, 05},
                {"Core Java Volume I – Fundamentals", "Cay S. Horstmann", 14, 12},
                {" Java: A Beginner’s Guide", "Herbert Schildt", 06, 11},
                {"Java - The Complete Reference", "Herbert Schildt", 07, 06},
                {"Head First Java", "Kathy Sierra & Bert Bates", 21, 02},
                {"Test-Driven: TDD and Acceptance TDD for Java Developers", "Lasse Koskela", 23, 13}
        };

        int rowNum = 0;
        System.out.println("Creating excel");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Done");
    }


}
