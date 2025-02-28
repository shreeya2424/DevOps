package com.java_spring_tut.javademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// @SpringBootTest
// class JavademoApplicationTests {

// 	@Test
// 	void contextLoads() {
// 	}

// }
---------------------------------------------------
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JavademoApplicationTests {

    @Test
    void testHomePage() {
        // Set path to ChromeDriver (update path as needed)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Load the local HTML file
            File htmlFile = new File("templates/index.html");
            driver.get(htmlFile.toURI().toString());

            // Test 1: Verify Page Title
            assertEquals("Home - Furniture Store", driver.getTitle(), "Title Mismatch!");

            // Test 2: Verify Buttons Exist
            WebElement loginButton = driver.findElement(By.linkText("Login"));
            WebElement registerButton = driver.findElement(By.linkText("Register"));
            WebElement productsButton = driver.findElement(By.linkText("View Products"));

            assertTrue(loginButton.isDisplayed(), "Login button missing!");
            assertTrue(registerButton.isDisplayed(), "Register button missing!");
            assertTrue(productsButton.isDisplayed(), "Products button missing!");

            // Test 3: Click Buttons and Check URLs
            loginButton.click();
            assertTrue(driver.getCurrentUrl().endsWith("templates/login.html"), "Login link broken!");

            driver.navigate().back();
            registerButton.click();
            assertTrue(driver.getCurrentUrl().endsWith("templates/register.html"), "Register link broken!");

            driver.navigate().back();
            productsButton.click();
            assertTrue(driver.getCurrentUrl().endsWith("templates/products.html"), "Products link broken!");

            System.out.println("All tests passed successfully!");

        } finally {
            // Close browser
            driver.quit();
        }
    }
}

