package com.openorangehrm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public FileOutputStream fileOut = null;
	public String path;
	public FileInputStream fis;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	public ExcelReader(String path)
	{
		this.path =path;
		try
		{
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String[][] getDataFromSheet(String sheetName, String ExcelName)
	{
		String dataSets[][] = null;
		try
		{
			XSSFSheet sheet = workbook.getSheet(sheetName);
			//count no.of.active rows
			int totalRow =sheet.getLastRowNum()+1;
			//count no.of.active columns in Row
			int totalColumn =sheet.getRow(0).getLastCellNum();
			// Create array of Rows & Columns 	
			dataSets = new String[totalRow-1][totalColumn];			
			for(int i=1; i<totalRow; i++)
		    {
				XSSFRow rows = sheet.getRow(i);
				for(int j=0; j<totalColumn; j++)
				{
				    XSSFCell cell = rows.getCell(j);
				    if(cell.getCellType() == CellType.STRING)
				    {
				    	dataSets[i-1][j] = cell.getStringCellValue();
				    }else if(cell.getCellType() == CellType.NUMERIC)
				    {
				    	String cellText = String.valueOf(cell.getNumericCellValue());
				    	dataSets[i-1][j] = cellText;
				    }else
				    {
				    	dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				    }
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception in Reading xlxs file " + e.getMessage());
			e.printStackTrace();
		}		
		return dataSets;	
	}	
	// Reading Cell value from Excel
	public String getCellData(String sheetName, String colName, int rowNum) { 
	    try {            
	        int col_Num = -1; // Initialize to -1 to indicate that the column is not found
	        int index = workbook.getSheetIndex(sheetName);
	        sheet = workbook.getSheetAt(index);
	        XSSFRow row = sheet.getRow(0);
	        for (int i = 0; i < row.getLastCellNum(); i++) {
	            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
	                col_Num = i;
	                break;
	            }
	        }
	        if (col_Num != -1) {
	            row = sheet.getRow(rowNum);
	            XSSFCell cell = row.getCell(col_Num);
	            if (cell.getCellType() == CellType.STRING) {
	                return cell.getStringCellValue();
	            } else if (cell.getCellType() == CellType.BLANK) {
	                return "";
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }        
	    return null;
	}

}


