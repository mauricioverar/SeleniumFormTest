package cl.kibernumacademy.form.pages;

import org.openqa.selenium.*;
//import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.Select;

public class FormularioPage {
  private WebDriver driver;

  // Localizadores
  private By firstName = By.id("firstName");
  private By lastName = By.id("lastName");
  private By userEmail = By.id("userEmail");

  private By genderMale = By.id("genderMale");
  private By genderFemale = By.id("genderFemale");
  private By genderOther = By.id("genderOther");

  private By userNumber = By.id("userNumber");

  private By hobbyReading = By.id("hobbyReading");
  private By hobbyMusic = By.id("hobbyMusic");
  private By hobbySports = By.id("hobbySports");

  private By currentAddress = By.id("currentAddress");
  private By stateSelect = By.id("stateSelect");

  private By citySelect = By.id("citySelect");
  private By submitButton = By.id("submitBtn");

  private By modalBodyContent = By.id("confirmationModal");

  public FormularioPage(WebDriver driver) {
    this.driver = driver;
  }

  public void setFirstName(String name) {
    driver.findElement(firstName).clear();
    driver.findElement(firstName).sendKeys(name);
  }

  public void setLastName(String last) {
    driver.findElement(lastName).clear();
    driver.findElement(lastName).sendKeys(last);
  }

  public void setUserEmail(String email) {
    driver.findElement(userEmail).clear();
    driver.findElement(userEmail).sendKeys(email);
  }

  public void setMobile(String mobile) {
    driver.findElement(userNumber).clear();
    driver.findElement(userNumber).sendKeys(mobile);
  }

  public void setAddress(String address) {
    driver.findElement(currentAddress).clear();
    driver.findElement(currentAddress).sendKeys(address);
  }

  /*
   * * public void selectGender(String gender) {
   * driver.findElement(By.xpath("//label[text()='" + gender + "']")).click();
   * }
   */
  public void selectGender(String gender) {
    switch (gender.toLowerCase()) {
      case "masculino":
        driver.findElement(genderMale).click();
        break;
      case "femenino":
        driver.findElement(genderFemale).click();
        break;
      case "otro":
        driver.findElement(genderOther).click();
        break;
      default:
        System.out.println("Opción no válida");
        break;
    }
  }

  public void selectHobby(String hobby) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hobbyReading));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hobbyMusic));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(hobbySports));

    switch (hobby.toLowerCase()) {
      case "lectura":
        driver.findElement(hobbyReading).click();
        break;
      case "música":
        driver.findElement(hobbyMusic).click();
        break;
      case "deportes":
        driver.findElement(hobbySports).click();
        break;
      default:
        System.out.println("Opción no válida");
        break;
    }
  }

  // En los select tienen un comportamiento especial, selenium puede interactuar
  // con ellos aunque
  // no estén visibles en la pantalla
  public void selectState(String state) {
    Select stateDropdown = new Select(driver.findElement(stateSelect));
    stateDropdown.selectByVisibleText(state);
  }

  public void selectCity(String city) {
    Select cityDropdown = new Select(driver.findElement(citySelect));
    cityDropdown.selectByVisibleText(city);
  }

  public void submitForm() {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(submitButton));
    driver.findElement(submitButton).click();
  }

  public String getModalBodyContent() {
    try {
      Thread.sleep(2000); // Espera para que el modal se cargue completamente y espera siempre 2 segundos
      // ! No es la mejor práctica usar Thread.sleep, pero es una forma simple de
      // esperar
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return driver.findElement(modalBodyContent).getText();
  }

}
