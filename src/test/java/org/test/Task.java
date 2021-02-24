package org.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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

public class Task {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace_UptoMaven\\MavenProjectSample\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		WebElement txtSearch = driver.findElement(By.id("twotabsearchtextbox"));

		txtSearch.sendKeys("iphone", Keys.ENTER);

		List<WebElement> phoneList = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		Workbook w = new XSSFWorkbook();

		Sheet s = w.createSheet("Sheet1");

		Row r = s.createRow(0);

		Cell c = r.createCell(0);

		c.setCellValue("Product Names");

		for (int i = 1; i <= phoneList.size(); i++) {

			WebElement phone = phoneList.get(i-1);

			String text = phone.getText();

			System.out.println(text);

			Row r1 = s.createRow(i);

			Cell c1 = r1.createCell(0);

			c1.setCellValue(text);

		}

		File f = new File("C:\\Users\\admin\\eclipse-workspace_UptoMaven\\MavenProjectSample\\Excel\\Task.xlsx");

		FileOutputStream fout = new FileOutputStream(f);

		w.write(fout);

	}

}
