package org.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static void main(String[] args) throws IOException  {
		Workbook w = new XSSFWorkbook();
		
		Sheet s = w.createSheet("Sheet1");
		
		Row r = s.createRow(0);
		
		Cell c = r.createCell(0);
		
		c.setCellValue("Java");
		
		File f = new File("C:\\Users\\admin\\eclipse-workspace_UptoMaven\\MavenProjectSample\\Excel\\ExcelWrite.xlsx");
		
		FileOutputStream fout = new FileOutputStream(f);
		
		w.write(fout);
		
		System.out.println("Done");
		
		
		
		
		
	}

}
