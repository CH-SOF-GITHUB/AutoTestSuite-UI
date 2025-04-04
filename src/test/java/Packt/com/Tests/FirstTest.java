package Packt.com.Tests;

import Packt.com.base.BaseTest;
import Packt.com.herokuapp.LogInPage;
import Packt.com.herokuapp.SecurePage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FirstTest extends BaseTest {

    // protected String username = "tomsmith";
    // protected String password = "SuperSecretPassword!";


    @Test(priority = 1)
    @Parameters({"username", "password", "browser"})
    public void TC01(String username, String password, String browser) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " on Thread ID: " + Thread.currentThread().getId());
        // Votre code de test ici
        SoftAssert softAssert = new SoftAssert();
        LogInPage logInPage = new LogInPage(driver);
        logInPage.open();
        // login and clicking login button
        SecurePage securePage = logInPage.LogIn(username, password);
        securePage.waitForSecurePage(10000);

        // verifications
        softAssert.assertTrue(securePage.isSecurePageLoaded(), "Logout button is not visible");
        softAssert.assertTrue(securePage.getPageSource().contains("You logged into a secure area!"), "Page source doesn't contain expected text: 'You logged into a secure area!'");
        softAssert.assertAll();
    }
}
