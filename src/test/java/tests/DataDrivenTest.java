package tests;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDrivenTest  {
    
	@DataProvider(name = "userData")
    public Object[][] testData() throws IOException {
		System.out.println("@DataProvider");
        String filePath = utils.Config.TEST_DATA_PATH;
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0); 
        int rowCount = sheet.getLastRowNum(); 

        Object[][] data = new Object[rowCount][2]; 

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1); 
            Cell emailCell = row.getCell(0); 
            Cell passwordCell = row.getCell(1); 

            data[i][0] = emailCell.getStringCellValue();
            data[i][1] = passwordCell.getStringCellValue();
        }

        workbook.close();
        fis.close();
        return data;
    }

	@Test(dataProvider = "userData")
    public void testLogin(String email, String password , WebDriver driver) {
        System.out.println("Logging in with Email: " + email + " and Password: " + password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
	    loginPage.enterPassword(password);
    }
}
