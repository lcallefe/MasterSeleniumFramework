package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class CheckoutPage extends BasePage {

    private final By billingFirstNameFld = By.id("billing_first_name");
    private final By billingLastNameFld = By.id("billing_last_name");
    private final By billingAddressFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostcodeFld = By.id("billing_postcode");
    private final By billingEmailBtn = By.id("billing_email");

    private final By placeOrderBtn = By.id("place_order");

    private final By successNotice = By.cssSelector(".woocommerce-notice");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingAddress(String firstName, String lastName, String address, String city, String postcode, String email){
        driver.findElement(billingFirstNameFld).sendKeys(firstName);
        driver.findElement(billingLastNameFld).sendKeys(lastName);
        driver.findElement(billingAddressFld).sendKeys(address);
        driver.findElement(billingCityFld).sendKeys(city);
        driver.findElement(billingPostcodeFld).sendKeys(postcode);
        driver.findElement(billingEmailBtn).sendKeys(email);
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice() {
        return driver.findElement(successNotice).getText();
    }

}
