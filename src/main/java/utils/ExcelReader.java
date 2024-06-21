package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private String filePath;

    public ExcelReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String[]> readExcelData() {
        List<String[]> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; 
                }

                List<String> cellData = new ArrayList<>();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            cellData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellData.add(cell.getDateCellValue().toString());
                            } else {
                                cellData.add(String.valueOf(cell.getNumericCellValue()));
                            }
                            break;
                        case BOOLEAN:
                            cellData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        default:
                            cellData.add("");
                    }
                }
                data.add(cellData.toArray(new String[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
