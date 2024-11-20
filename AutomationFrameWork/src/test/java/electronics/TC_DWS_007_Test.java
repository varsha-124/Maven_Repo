package electronics;

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
public class TC_DWS_007_Test extends BaseClass {
	@Test
	public void clickOnElectronics() throws EncryptedDocumentException, IOException {
		hp=new HomePage(driver);
		hp.getElectronicsLink().click();
		Assert.assertEquals(driver.getTitle(), eUtil.getStringDataFromExcelFile("Electronics",1,1),"Books page not displayed");
		test.log(Status.PASS, "Books page displayed");
		
	}
}
