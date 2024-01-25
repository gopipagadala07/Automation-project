package com.Examcenter.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Examcenter.Utils.ActionType;
import com.Examcenter.Utils.Base;

public class BulkUpload_Pages extends ActionType{

	private WebDriver driver;
	By Adminstrationbtn=By.xpath("//mat-icon[text()=' settings ']");
	By provisioning=By.xpath("//a[text()='Provisioning']");
	By Controllerbtn=By.xpath("//a[text()='Controllers']");
	By Proctorbtn=By.xpath("//div[text()='PROCTORS']");
	By Examtakerbtn=By.xpath("//div[text()='EXAM TAKERS']");
	By bulkUpload=By.xpath("//span[text()=' Bulk Upload ']");
	By template=By.xpath("//mat-icon[text()='cloud_download']");
	By toster=By.xpath("//button[@aria-label='Close']");


	public BulkUpload_Pages(WebDriver driver)
	{
		this.driver=driver;
	}

	public void Adminstarationbtn()
	{
		waitForElement(Adminstrationbtn);
		waitForPageLoad();
		StaticWait(2);
		driver.findElement(Adminstrationbtn).click();
		StaticWait(1);
	}
	public void provisioning()
	{
		waitForElement(provisioning);
		driver.findElement(provisioning).click();
	}
	public void Controllerbtn()
	{
		waitForElement(Controllerbtn);
		driver.findElement(Controllerbtn).click();
	}
	public void Proctorbtn()
	{
		waitForElement(Proctorbtn);
		driver.findElement(Proctorbtn).click();
	}
	public void Examtakersbtn()
	{
		waitForElement(Examtakerbtn);
		driver.findElement(Examtakerbtn).click();
	}

	public void bulkUpload(String Path) throws Exception
	{
		WebElement e = driver.findElement(bulkUpload);
		e.click();
		StaticWait(1);
		StringSelection ss=new StringSelection(Path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		String s="Successfully import the valid users.";
		waitForPageLoad();
		StaticWait(15);
		//waitTillElementInVisible(toster, null);
	}

	public void template()
	{
		driver.findElement(template).click();
	}
	public void Excel_Creation(String Path, String sheet, int cellno, String value, int rowno) throws EncryptedDocumentException, IOException
	{

		FileInputStream f=new FileInputStream(Path);
		Workbook wb = WorkbookFactory.create(f);
		Sheet sh = wb.getSheet(sheet);

		//		for(int i=1;i<=1500;i++)
		//		{
		//sh.createRow(rowno);
		//		}
		//		for(int j=1;j<=99;j++)
		//		{
		        sh.getRow(rowno).createCell(cellno).setCellValue(value);
		//		}

		FileOutputStream fo=new FileOutputStream(Path);
		wb.write(fo);
		wb.close();
	}
}
