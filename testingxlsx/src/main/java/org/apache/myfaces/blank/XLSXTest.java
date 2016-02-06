package org.apache.myfaces.blank;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object[]> data = new HashMap<String, Object[]>();
		data.put("7", new Object[] { "Project", "Component", "Deployment", "Status", "Date" });
		data.put("8", new Object[] { "NRT", "Cassandra", "Development", "Stopped", "01/01/2014" });
		data.put("9", new Object[] { "Analytics", "Hazelcast", "Development", "Running", "01/01/2014" });

		// Set to Iterate and add rows into XLS file
		Set<String> newRows = data.keySet();

		// get the last row number to append new data
		int rownum = 0;
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Countries");
		int count = 0;
		for (String key : newRows) {

			// Creating a new Row in existing XLSX sheet
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (count == 0) {
					CellStyle cellStyle = workbook.createCellStyle();
//					XSSFColor colr = new XSSFColor();
//					colr.setRgb(new byte[]{50,50,50});
//					cellStyle.setFillBackgroundColor(colr.getIndexed());
					cellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
					cellStyle.setFillPattern(CellStyle.ALIGN_FILL);
					Font font = workbook.createFont();
					font.setColor(IndexedColors.WHITE.getIndex());
					font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
					cellStyle.setFont(font);
					cellStyle.setBorderLeft(CellStyle.BORDER_MEDIUM);
					cellStyle.setBorderRight(CellStyle.BORDER_MEDIUM);
					cellStyle.setBorderTop(CellStyle.BORDER_MEDIUM);
					cellStyle.setBorderBottom(CellStyle.BORDER_MEDIUM);
					cell.setCellStyle(cellStyle);
				}
				else
				{
					CellStyle cellStyle = workbook.createCellStyle();
					cellStyle.setBorderLeft(CellStyle.BORDER_THICK);
					cellStyle.setBorderRight(CellStyle.BORDER_THICK);
					cellStyle.setBorderTop(CellStyle.BORDER_THICK);
					cellStyle.setBorderBottom(CellStyle.BORDER_THICK);
					cell.setCellStyle(cellStyle);
				}
				if (obj instanceof String) {
					cell.setCellValue((String) obj);
				} else if (obj instanceof Boolean) {
					cell.setCellValue((Boolean) obj);
				} else if (obj instanceof Date) {
					cell.setCellValue((Date) obj);
				} else if (obj instanceof Double) {
					cell.setCellValue((Double) obj);
				}
			}
			count++;
		}

		// open an OutputStream to save written data into XLSX file
		FileOutputStream os = new FileOutputStream(
				"/home/impadmin/aeris-final/kush.xlsx");
		workbook.write(os);
		System.out.println("Writing on XLSX file Finished ...");

	}

}
