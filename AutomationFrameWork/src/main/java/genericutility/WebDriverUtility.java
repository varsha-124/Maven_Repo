package genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Varsha
 */

public class WebDriverUtility {
	//public WebDriver driver;
	public Actions act;
	
	/*public WebDriverUtility() {
		this.driver=driver;
		act=new Actions(driver);
	}*/

	/**
	 * This method is used to maximize the window.
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to capture the height and width of the window.
	 * @param driver
	 * @return
	 */
	
	public Dimension getWindowSize(WebDriver driver)
	{
		return driver.manage().window().getSize();
	}
	
	/**
	 * This method is used to switch the driver control wi window based on url.
	 * @param driver
	 * @param url
	 */
	
	public void switchToWindow(WebDriver driver ,String url)
	{
		//capture multiple window ids
		Set<String> ids = driver.getWindowHandles();
		
		//navigate through all windows
		for(String id:ids)
		{
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(url))
				break;
		}
	}
	/**
	 * This method is used to perform right click operation
	 * @param driver
	 */
	
	public void rightClick()
	{
		//Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method is used to perform click and hold on webelement
	 * @param driver
	 * @param ele
	 */
	public void clickAndHold(WebElement ele) {
		//Actions act=new Actions(driver);
		act.clickAndHold(ele).perform();
	}
	
	/**
	 * This method is used to perform mousehover action on webelement
	 * @param driver
	 * @param ele
	 */
	public void mouseHover(WebElement ele)
	{
		//Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	/**
	 * This method is used to perform drag and drop operation.
	 * @param driver
	 * @param source
	 * @param target
	 */
	
	public void dragAndDrop(WebElement source,WebElement target)
	{
		//Actions act=new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	/**
	 * This method is used to switch the driver control to frame.
	 * This is the concept of method overloading
	 * @param driver
	 * @param index
	 */
	
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(0);
	}
	
	public void switchToFrame(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	
	public void switchToFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	
	/**
	 * This method is used to switch back the driver control from the current window.
	 */
	public void switchBack(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	

	/**
	 * This method is used to select option from the dropDown using Index
	 * @param ele
	 * @param index
	 */
public void selectDropDownByIndex(WebElement ele,int index)
{
	Select opt=new Select(ele);
	opt.selectByIndex(index);
}

/**
 * This method is used to select option from the dropDown using Value
 * @param ele
 * @param index
 */
public void selectDropDownByValue(WebElement ele, String value)
{
	Select opt=new Select(ele);
	opt.selectByValue(value);
}

/**
 * This method is used to select option from the dropDown using VisibleText
 * @param ele
 * @param index
 */

public void selectDropDownByVisibleText(WebElement ele, String visibleTest)
{
	Select opt=new Select(ele);
	opt.selectByVisibleText(visibleTest);
}

/**
 * This method is used to handle alert
 * @return
 */
public Alert switchToAlert(WebDriver driver)
{
	return driver.switchTo().alert();
}

/**
 * This method is used to handle alert and click on accept.
 */
public void switchToAlertAndAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * This method is used to handle alert and click on dismiss
 */

public void switchToAlertAndDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
 * This method is used to handle alert and send data to textfield
 * @param data
 */

public void switchToAlertAndSenKeys(WebDriver driver,String data)
{
	driver.switchTo().alert().sendKeys(data);
}

/**
 * This method is used to handle the alert and get the alert text
 * @return
 */

public String switchToAlertAndGetText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}

/**
 * This method is used to capture screenshot of the webpage
 * @throws IOException
 */
public void takeScreenshot(WebDriver driver) throws IOException
{
	String timestamp = LocalDateTime.now().toString().replace(":","-");
	TakesScreenshot ts=(TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshots/"+timestamp+".png");
	FileHandler.copy(temp, temp);
}

/**
 * This method is used to doubleclick on webelement
 * @param ele
 */
public void doubleClick(WebElement ele)
{
	act.doubleClick(ele).perform();
}

/**
 * This method is used to click on element using JS executor
 * @param ele
 */
public void javaScriptClick(WebDriver driver,WebElement ele)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].click()", ele);
}
/**
 * This method is used to scroll the webpage from starting position of scrollbar.
 * @param x
 * @param y
 */

public void javaScriptScrollTo(WebDriver driver,int x,int y)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollTo("+x+","+y+")");
}

/**
 * This method is used to scroll the webpage from scrollbar position
 * @param x
 * @param y
 */
public void javaScriptScrollBy(WebDriver driver,int x,int y)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy("+x+","+y+")");
}

/**
 * This method is used to scroll the webpage till the bottom
 * @param x
 */
public void javaScriptScrollToBottom(WebDriver driver,int x)
{
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollTo("+x+",document.body.scrollHeight)");
}
}
