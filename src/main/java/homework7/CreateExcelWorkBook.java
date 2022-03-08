package homework7;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

public class CreateExcelWorkBook {
    private HSSFWorkbook workbook = new HSSFWorkbook();
    private HSSFSheet sheet = workbook.createSheet("Storage sheet");
    private Storage storage;

    private int rowNum = 0;
    private Cell cell;
    private Row row;

    public CreateExcelWorkBook(Storage storage) throws IOException {
        this.storage = storage;
        createCellsAndRows();
        fillCellsAndRows();
        createAndWriteToFile();
    }

    private HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    private void createCellsAndRows() {
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rowNum);

        // Name
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Name");
        cell.setCellStyle(style);
        // Amount
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Amount");
        cell.setCellStyle(style);
        // Price
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Price");
        cell.setCellStyle(style);
    }

    private void fillCellsAndRows() {
        Map<String, Product> toExcel = storage.getAllProducts();
        for (Map.Entry<String, Product> entry : toExcel.entrySet()) {
            rowNum++;
            row = sheet.createRow(rowNum);

            // Name
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(entry.getValue().name);
            // Amount
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(entry.getValue().amount);
            // Price
            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(entry.getValue().price);
        }
    }

    private void createAndWriteToFile() throws IOException {
            File file = new File("C:/demo/storage.xls");
            file.getParentFile().mkdirs();

            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            outFile.flush();
            outFile.close();
            System.out.println("Excel файл доступен по адресу: " + file.getAbsolutePath());
            System.out.println();


    }
}
