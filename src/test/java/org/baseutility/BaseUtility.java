package org.baseutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUtility {

	public static WebDriver driver;

	public static void intialSetUp_WithBrowserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	public static String read_Data_From_PropertyFile(String filepath, String key) throws IOException {
		FileInputStream stream = new FileInputStream(filepath);
		Properties properties = new Properties();
		properties.load(stream);
		return properties.getProperty(key);
	}

	public static String read_Data_From_Excel(int rowIndex, int cellIndex) throws  IOException {
		Workbook w = new XSSFWorkbook(new FileInputStream(new File("H:\\Bursa_Malaysia\\src\\test\\resources\\Resources\\Book1.xlsx")));
		return w.getSheet("Sheet1").getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	}

}
