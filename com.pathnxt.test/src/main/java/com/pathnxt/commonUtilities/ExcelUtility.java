package com.pathnxt.commonUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author -Priyaranjan Mohanty-
 *
 */
public class ExcelUtility implements Iconstants 
{
	/**
	 * Used to read  data from the excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileInputStream fileinputstream = new FileInputStream(Iconstants.excelpath);
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String data = cell.toString();
		return data;
	}
	/**
	 * Used to  write data to the excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 * @throws InvalidFormatException 
	 */
	public void writeDataaIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException, InvalidFormatException
	{
		FileInputStream fileinputstream = new FileInputStream(Iconstants.excelpath);
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileoutputstream = new FileOutputStream(Iconstants.excelpath);
		workbook.write(fileoutputstream);


	}
}
