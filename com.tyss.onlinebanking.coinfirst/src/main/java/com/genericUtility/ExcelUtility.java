package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * To read the data from excel
	 * @param Sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String Sheetname, int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream(IpathConstant.Excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(Sheetname);
		String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}
	/**
	 * To get the last row count
	 * @param Sheetname
	 * @return
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */



		public int getTotalRowCount(String Sheetname) throws EncryptedDocumentException, IOException {
			
		
			FileInputStream fis=new FileInputStream(IpathConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(Sheetname);
			int rowcount = sh.getLastRowNum();
			return rowcount;
		
		}
		
		/**
		 * Write data into excel sheet
		 * @param Sheetname
		 * @param rownum
		 * @param cellnum
		 * @param data
		 * @throws IOException 
		 * @throws EncryptedDocumentException 
		 */
		
		public void writeDataIntoExcel(String sheetname,int rownum,int cellnum,String data) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(IpathConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
		    Sheet sh = wb.getSheet(sheetname);
		    sh.getRow(rownum).getCell(cellnum).setCellValue(data);
		    
		    FileOutputStream fos=new FileOutputStream(IpathConstant.Excelpath);
		    wb.write(fos);
		    wb.close();
		   
		    
		   }
		
		public HashMap<String, String> readMultipleData(String Sheetname,int cellno) throws EncryptedDocumentException, IOException {
			FileInputStream fis=new FileInputStream(IpathConstant.Excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(Sheetname);
			int rowcount = sh.getLastRowNum();
			
			HashMap<String, String>map=new HashMap<>();
			
			for(int i=0;i<=rowcount;i++) {
				String key = sh.getRow(i).getCell(cellno).getStringCellValue();
				String value = sh.getRow(i).getCell(cellno+1).getStringCellValue();
				map.put(key, value);
			}
			return map;
		}
}	











	
		
