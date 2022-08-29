package org.execution;

import java.io.IOException;

import org.baseutility.BaseUtility;
import org.pages.BursaMalaysiaHomePage;
import org.testng.Assert;

public class Assignment2_Bursa_Malaysia_Register extends BaseUtility{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String read_Data_From_PropertyFile = read_Data_From_PropertyFile(
				"H:\\Bursa_Malaysia\\src\\test\\resources\\Resources\\url.properties",
				"url1");
		String valueOf = String.valueOf(read_Data_From_PropertyFile);
		intialSetUp_WithBrowserLaunch(valueOf);
		BursaMalaysiaHomePage bursaMalaysiaHomePage = new BursaMalaysiaHomePage();
		Assert.assertTrue(bursaMalaysiaHomePage.getRegister().isEnabled());
		System.out.println("Register icon is Enabled");
		bursaMalaysiaHomePage.RegisterPage(read_Data_From_Excel(1, 0), read_Data_From_Excel(1, 1), read_Data_From_Excel(1, 2));
		Assert.assertTrue(bursaMalaysiaHomePage.getDisplayName().isDisplayed());
		System.out.println("User name text box is displayed");
		Assert.assertTrue(bursaMalaysiaHomePage.getEmailAddress().isDisplayed());
		System.out.println("email address text box is displayed");
		Assert.assertTrue(bursaMalaysiaHomePage.getPassword().isDisplayed());
		System.out.println("password text box is displayed");
		Assert.assertTrue(bursaMalaysiaHomePage.getCheckBox().isEnabled());
		System.out.println("Checkbox is enabled");
		//Assert.assertTrue(bursaMalaysiaHomePage.getCaptchaBox().isEnabled());
		System.out.println("Captcha checkbox is enabled");
	}

}
