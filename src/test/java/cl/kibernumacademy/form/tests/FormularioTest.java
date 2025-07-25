package cl.kibernumacademy.form.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import cl.kibernumacademy.form.pages.FormularioPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FormularioTest {

  private WebDriver driver;
  private FormularioPage formularioPage;

  @BeforeAll
  void setupClass() {
    WebDriverManager.chromedriver().setup();
    System.setProperty("file.encoding", "UTF-8");
  }

  @BeforeEach
  void setupTest() {
    driver = new ChromeDriver();
    driver.manage().window().setSize(new org.openqa.selenium.Dimension(1366, 768));
    //driver.manage().window().maximize();
    driver.get("https://selenium-bootcamp.netlify.app/");
    formularioPage = new FormularioPage(driver);
  }

  @AfterEach
  void tearDown() {
    /* if (driver != null) {
      driver.quit(); // Cierra el navegador después de cada prueba
    } */
    // if(driver != null) driver.quit();
  }

  @Test
  void testLlenadoFormulario() {
    formularioPage.setFirstName("Sofia");
    formularioPage.setLastName("Perez");
    formularioPage.setUserEmail("sofia@correo.com");
    formularioPage.selectGender("Femenino");
    formularioPage.setMobile("1234567890");
    formularioPage.selectHobby("Lectura");
    formularioPage.selectHobby("Música");
    formularioPage.setAddress("Calle Falsa 123");
    formularioPage.selectState("Región Metropolitana");
    formularioPage.selectCity("Santiago");
    formularioPage.submitForm();

    String modalContent = formularioPage.getModalBodyContent();
    assertTrue(modalContent.contains("Sofia"));
    assertTrue(modalContent.contains("Perez"));
    assertTrue(modalContent.contains("sofia@correo.com"));
    assertTrue(modalContent.contains("Femenino"));
    assertTrue(modalContent.contains("1234567890"));
    assertTrue(modalContent.contains("Lectura"));
    assertTrue(modalContent.contains("Música"));
    assertTrue(modalContent.contains("Calle Falsa 123"));
    assertTrue(modalContent.contains("Región Metropolitana"));
    assertTrue(modalContent.contains("Santiago"));

  }

}