package books;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.ListenerUtility;
import objectrepository.HomePage;
@Listeners(ListenerUtility.class)
public class TC_DWS_005_Test extends BaseClass{
	@Test
public void clickOnBooks() throws EncryptedDocumentException, IOException {
	hp=new HomePage(driver);
	hp.getBooksLink().click();
	Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcelFile("Books",1,0),"Books page not displayed");
	test.log(Status.PASS, "Books page displayed");
	
}
}
