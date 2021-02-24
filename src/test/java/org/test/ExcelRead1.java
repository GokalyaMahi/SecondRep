package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead1 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace_UptoMaven\\MavenProjectSample\\Excel\\ExcelRead.xlsx");

		FileInputStream fin = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fin);

		Sheet s = w.getSheet("Sheet1");

		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {

			Row r = s.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {

				Cell c = r.getCell(j);

				int type = c.getCellType();

				if (type == 1) {

					String name = c.getStringCellValue();
					System.out.println(name);
				}
				if (type == 0) {
					if (DateUtil.isCellDateFormatted(c)) {
						
//						Date d = c.getDateCellValue();
//						
//						SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
//						
//						String name = sim.format(d);

						String name = new SimpleDateFormat("dd-MM-yyyy").format(c.getDateCellValue());

						System.out.println(name);

					} else {
						
//						double d = c.getNumericCellValue();
//						
//						long l = (long)d;
//						
//						String name = String.valueOf(l);
//						
						String name = String.valueOf((long) c.getNumericCellValue());

						System.out.println(name);

					}

				}
			}

		}

	}

}
