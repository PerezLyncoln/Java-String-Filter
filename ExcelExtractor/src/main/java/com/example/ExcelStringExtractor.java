package com.example;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelStringExtractor {
    public static void main(String[] args) {
        String filePath = "mockdata.xlsx"; // Change this to your Excel file path

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            for (Sheet sheet : workbook) { // Iterate through sheets
                for (Row row : sheet) {    // Iterate through rows
                    for (Cell cell : row) { // Iterate through cells
                        if (cell.getCellType() == CellType.STRING) {
                            String cellValue = cell.getStringCellValue().trim();
                            if (cellValue.length() >= 5) {
                                System.out.println(cellValue);
                            }
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the Excel file: " + e.getMessage());
        }
    }
}
