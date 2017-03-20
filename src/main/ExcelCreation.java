package main;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCreation {

	private String fileName;
	HSSFWorkbook workbook;

	public ExcelCreation(String fileName) {

		this.fileName = fileName;
		this.workbook = new HSSFWorkbook();
	}

	public HSSFSheet createSheet(String sheetName) {

		return workbook.createSheet(sheetName);
	}

	// public HSSFRow createRow(HSSFSheet sheet, int rowNum) {
	//
	// return sheet.createRow(rowNum);
	// }
	//
	// public void createNumCell(HSSFRow row, int cellIndex, int cellValue) {
	//
	// row.createCell(cellIndex, CellType.NUMERIC).setCellValue(cellValue);
	// }
	//
	// public void createStringCell(HSSFRow row, int cellIndex, String
	// cellValue) {
	//
	// row.createCell(cellIndex, CellType.STRING).setCellValue(cellValue);
	// }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public HSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

}
