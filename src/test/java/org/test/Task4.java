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

public class Task4 {
	public static void main(String[] args) throws IOException {
		Workbook w = new XSSFWorkbook();
		
		Sheet s = w.createSheet("Sheet1");
		
		for (int i = 0; i < 8; i++) {
			
			Row r = s.createRow(i);
			
			for (int j = 0; j < 1; j++) {
				
				Cell c = r.createCell(j);
				
				c.setCellValue("Greens");
				
				int type = c.getCellType();
				
				if (type==1) {
					
				}
				
			}
			
		}
		
		File f = new File("C:\\Users\\admin\\eclipse-workspace_UptoMaven\\MavenProjectSample\\Excel\\Task4.xlsx");
		
		FileOutputStream fout = new FileOutputStream(f);
		
		w.write(fout);
		
		System.out.println("Done");
	}

}
