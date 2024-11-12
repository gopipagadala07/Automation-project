//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import com.Assessments.pages.CommonPages;
//import com.Utils.ActionType;
//import com.Utils.Base;
//import com.Utils.Wait;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//public class QuestionPage extends ActionType {
//	CommonPages cp=new CommonPages(Base.getDriver());
//	public WebDriver driver;
//	private Wait wait;
//
//	public QuestionPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		this.wait = new Wait(driver); 
//	}
//
//
//
//	  List<String> xpaths = Arrays.asList(
//              "(//div[@class='mdc-radio'])[1]", 
//              "//p[@class='ck-placeholder']"        
//      );
//
//    
//      for (int i = 0; i < numberOfQuestions; i++) {
//         
//          for (int j = 0; j < xpaths.size(); j++) {
//              String xpath = xpaths.get(j);
//              try {
//               
//                  WebElement element = driver.findElement(By.xpath(xpath));
//                  
//                  if (xpath.equals("(//div[@class='mdc-radio'])[1]")) {
//                  
//                      element.click();
//                      System.out.println("Clicked on radio button with XPath: " + xpath);
//                  } else if (xpath.equals("//p[@class='ck-placeholder']")) {
//                    
//                      String randomText = generateRandomText();
//                      element.sendKeys(randomText);
//                      System.out.println("Entered random text: " + randomText + " into input field with XPath: " + xpath);
//                  }
//              } catch (Exception e) {
//                  System.out.println("Element not found for XPath: " + xpath);
//              }
//}}
