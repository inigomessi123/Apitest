package org.execution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.baseutility.BaseUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ExecutionClasss_Assignment1 extends BaseUtility {

	public static void main(String[] args) throws IOException {
		String read_Data_From_PropertyFile = read_Data_From_PropertyFile(
				"H:\\Bursa_Malaysia\\src\\test\\resources\\Resources\\url.properties",
				"url");
		String valueOf = String.valueOf(read_Data_From_PropertyFile);
		intialSetUp_WithBrowserLaunch(valueOf);
		WebElement table = driver.findElement(By.xpath("//div[@id='pills-active']"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", table);
		List<WebElement> values = driver.findElements(By.xpath("//div[@id='pills-active']//td[3]"));
		Set<String> s = new TreeSet();
		List<String> code = new ArrayList();
		List<String> name = new ArrayList();
		for (int i = 0; i < values.size(); i++) {
			String text = values.get(i).getText();
			String numberText = "";
			for (int j = 0; j < text.length(); j++) {
				if (text.charAt(j) >= 48 && text.charAt(j) <= 57) {
					numberText = numberText + text.charAt(j);
				}
			}
			s.add(numberText);
		}
		List<String> l = new ArrayList();
		l.addAll(s);

		List<WebElement> codeElement = driver
				.findElements(By.xpath("//div[@id='pills-active']//td[3]//preceding-sibling::td[2]"));
		for (int i = 0; i < codeElement.size(); i++) {
			code.add(codeElement.get(i).getText());
		}

		List<WebElement> nameElement = driver.findElements(By.xpath("//div[@id='pills-active']//a"));
		for (int i = 0; i < nameElement.size(); i++) {
			name.add(nameElement.get(i).getText());
		}

		for (int i = l.size() - 1; i >= 0; i--) {
			System.out.println(code.get(i) + "\t" + name.get(i) + "\t" + l.get(i));
		}
	}

}
