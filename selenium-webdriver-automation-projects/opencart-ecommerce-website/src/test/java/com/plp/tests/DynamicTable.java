package com.plp.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {
	private static WebDriver driver;
	
	public static void main(String[] args) {
		setUp();
		int numberOfRows = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr")).size();
		int numberOfCols = driver.findElements(By.xpath("//table[@id='countries']/tbody/tr[1]/td")).size();
		System.out.println("Number of Rows Identified = "+numberOfRows);
		System.out.println("Number of Columns Identified = "+numberOfCols);
		
		List<String> countries = new ArrayList<String>();
		countries.add("Andorra");
		countries.add("Argentina");
		countries.add("Australia");
		countries.add("Bahrain");
		countries.add("Bangladesh");
		countries.add("Barbados");
		countries.add("Zimbabwe");
		selectVisitedCountries(countries);
		getCapitalsOfVisitedCountries(countries);
		//getVisitedCountries()
		tearDown();
	}
	
	private static void getCapitalsOfVisitedCountries(List<String> countries) {
		String checkBoxLocator = "//table[@id='countries']/tbody/tr[%s]/td[1]/input[@type='checkbox']";
		String capitalsLocator = "//table[@id='countries']/tbody/tr[%s]/td[3]";
		String countriesLocator = "//table[@id='countries']/tbody/tr[%s]/td/strong | //table[@id='countries']/tbody/tr[%s]/td[2]";
		String countryName = "";
		String capitalName = "";
		try {
			for(int row =2; row<=197; row++) {
				if(driver.findElement(By.xpath(String.format(checkBoxLocator, row))).isSelected()) {
					countryName = driver.findElement(By.xpath(String.format(countriesLocator, row, row))).getText();
					capitalName = driver.findElement(By.xpath(String.format(capitalsLocator, row))).getText();
					System.out.println("Capital for Countries Visited Country = "+countryName+" Capital = "+ capitalName);
				}
			}
		}
		catch(NoSuchElementException e) {
		}
	}

	private static void selectVisitedCountries(List<String> countries) {
		String checkBoxLocator = "//table[@id='countries']/tbody/tr[%s]/td[1]/input[@type='checkbox']";
		String countriesLocator = "//table[@id='countries']/tbody/tr[%s]/td/strong | //table[@id='countries']/tbody/tr[%s]/td[2]";
		String countryFound;
		try {
			for(int row =2; row<=197; row++) {
				countryFound = driver.findElement(By.xpath(String.format(countriesLocator,row,row))).getText();
				if(countries.contains(countryFound)) {
					System.out.println("Country Found in Table = "+countryFound+" at Row = "+row);
					driver.findElement(By.xpath(String.format(checkBoxLocator,String.valueOf(row)))).click();
				}
			}
		}
		catch(NoSuchElementException e) {
		}
		
	}

	private static void tearDown() {
		driver.quit();
	}

	public static void setUp() {
		  WebDriverManager.chromedriver().setup();
		  driver=new ChromeDriver();
		  driver.get("https://cosmocode.io/automation-practice-webtable/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

}
