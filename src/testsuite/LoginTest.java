package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest
{
    @Before
    public void openBrowser()
    {
        setBrowser();
    }

    //1. userShouldNavigateToLoginPageSuccessfully
    @Test
    public void userShouldNavigateToLoginPageSuccessfully() throws InterruptedException
    {
        //1.1 click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        //1.2 Verify the text ‘Welcome Back!’
        String expectedText="Welcome Back!";
        String actualText= driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals("Welcome back text not found",expectedText,actualText);

        //Hold the screen
        Thread.sleep(2000);
    }

    //2. verifyTheErrorMessage
    @Test
    public void verifyTheErrorMessage() throws InterruptedException
    {
        //2.1 click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        //2.2 Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("v@gmail.com");

        //2.3 Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("5422nn");

        //2.4 Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();

        //2.5 Verify the error message ‘Invalid email or password.’
        String expectedText="Invalid email or password.";
        String actualText=driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("Invalid message not found",expectedText,actualText);

        //Hold the screen
        Thread.sleep(2000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
