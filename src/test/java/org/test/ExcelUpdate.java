package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelUpdate {
	public static void main(String[] args) throws IOException {

		File f = new File("C:\\Users\\admin\\eclipse-workspace_UptoMaven\\MavenProjectSample\\Excel\\ExcelUpdate.xlsx");

		FileInputStream fin = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fin);

		Sheet s = w.getSheet("Sheet1");

		Row r = s.getRow(0);

		Cell c = r.getCell(0);

		String name = c.getStringCellValue();

		if (name.equals("FirstName")) {

			c.setCellValue("First");
		}

		FileOutputStream fout = new FileOutputStream(f);

		w.write(fout);
		
		System.out.println("Done");

	}

}
