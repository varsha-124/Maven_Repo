package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Varsha
 */

public class ExcelUtility {
	
	/**
	 * This method is used to read String data from excel file.
	 * User need to pass sheetname, rowIndex and colIndex.
	 * @param sheet
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String getStringDataFromExcelFile(String sheet,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getStringCellValue();
}


public double getNumericDataFromExcelFile(String sheet,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
}

public boolean getBooleanDataFromExcelFile(String sheet,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
}

public LocalDateTime getLocalDateTimeFromExcelFile(String sheet,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
	
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/TestScriptData.xlsx");
	Workbook workbook = WorkbookFactory.create(fis);
	return workbook.getSheet(sheet).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
}
}
