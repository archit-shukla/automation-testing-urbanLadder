package com.urbanladder.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelRead {
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int RowCount(String xlfile,String xlsheet) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		int rowCount=sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
	}
	
	public static int cellCount(String xlfile,String xlsheet,int rownum) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		int cellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return cellCount;
	}
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter df=new DataFormatter();
			String cellData=df.formatCellValue(cell);
			return cellData;
		}catch (Exception e) {
			data="";
		}
		wb.close();
		fis.close();
		return data;
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException {
		fis=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(xlsheet);
		row=sh.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlfile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	

}
