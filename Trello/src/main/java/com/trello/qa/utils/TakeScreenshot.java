package com.trello.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.trello.qa.base.TestBase;

public class TakeScreenshot extends TestBase {

	public static void takeScreenshotAtEndOfTest(String testname) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// String currentDir = System.getProperty("user.dir");

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		// FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + testname
		// +currentDate + ".png"));
		FileUtils.copyFile(scrFile, new File("C:/seleniumTC/" + testname + currentDate + ".png"));
		System.out.println("File name is: " + testname + currentDate + ".png");

	}

	public static void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// String currentDir = System.getProperty("user.dir");

		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		FileUtils.copyFile(scrFile, new File("C:/seleniumerror/" + "screenshots" + currentDate + ".png"));
		System.out.println("Exception Screenshot is taken : " + "screenshots" + currentDate + ".png");
		// FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
		// "Screenshot" +currentDate + ".png"));

		// System.out.println("C:/seleniu/"+time1+"error.png");
		// FileUtils.copyFile(src, new File("C:/seleniumerror/"+time1+"error.png"));

	}
}
