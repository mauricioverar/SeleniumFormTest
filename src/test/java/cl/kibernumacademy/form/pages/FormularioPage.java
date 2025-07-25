package cl.kibernumacademy.form.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
