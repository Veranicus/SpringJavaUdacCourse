package com.udacity.jwnd.c1.review;

import com.udacity.jwnd.c1.review.controller.ChatPage;
import com.udacity.jwnd.c1.review.controller.LoginPage;
import com.udacity.jwnd.c1.review.controller.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

    @Test
    void contextLoads() {
    }

    @LocalServerPort
    private Integer port;

    private static WebDriver webDriver;

    private LoginPage loginPage;

    private SignupPage signupPage;

    private ChatPage chatPage;

    private String baseUrl;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterAll
    static void afterAll() {
        webDriver.quit();
        webDriver = null;
    }

    @BeforeEach
    void setUp() {
        baseUrl = baseUrl = "http://localhost:" + port;

    }

    @Test
    void testLoginAndSingup() {

        webDriver.get(baseUrl + "/signup");

       SignupPage signupPage = new SignupPage(webDriver);


        String username = "pzastoup";
        String firstName = "John";
        String lastName = "Test";
        String password = "whatabadpassword";
        String messageText = "Hello!";

        signupPage.signupUser(firstName,lastName,username,password);

        webDriver.get(baseUrl + "/login");
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.setInputPassword(username);
        loginPage.setInputUsername(password);
        loginPage.submitAllLoginInputs();

       ChatPage chatPage = new ChatPage(webDriver);
        chatPage.sendChatMessage("Hello World!");


        assertEquals(username,chatPage.getFirstMessage().getUsername());
        assertEquals(messageText,chatPage.getFirstMessage().getMessageText());
    }
}
