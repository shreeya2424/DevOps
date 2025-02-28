import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginPageTest {

    @Test
    void testLoginPageElements() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Load the local login page
            File htmlFile = new File("path/to/templates/login.html");
            driver.get(htmlFile.toURI().toString());

            // Test 1: Verify Page Title
            assertEquals("Login - Furniture Store", driver.getTitle(), "Title Mismatch!");

            // Test 2: Verify Input Fields
            WebElement emailField = driver.findElement(By.xpath("//input[@type='text']"));
            WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));

            assertTrue(emailField.isDisplayed(), "Email input field missing!");
            assertTrue(passwordField.isDisplayed(), "Password input field missing!");

            // Test 3: Verify Login Button
            WebElement loginButton = driver.findElement(By.tagName("button"));
            assertTrue(loginButton.isDisplayed(), "Login button missing!");

            // Test 4: Verify Back Button
            WebElement backButton = driver.findElement(By.linkText("⬅ Back to Home"));
            assertTrue(backButton.isDisplayed(), "Back button missing!");

            backButton.click();
            assertTrue(driver.getCurrentUrl().endsWith("index.html"), "Back button link broken!");

            System.out.println("All login page tests passed successfully!");

        } finally {
            driver.quit();
        }
    }
}
