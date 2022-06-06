package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    //private final By addToCartBtn = By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']");


    public StorePage(WebDriver driver) {
        super(driver);
    }

    /*
    public StorePage enterTxtInSearchFld(String txt) {
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }
    public StorePage clickSearchBtn(){
        driver.findElement(searchBtn).click();
        return this;
    }
    */


    public StorePage search(String txt){
        driver.findElement(searchFld).sendKeys(txt);
        driver.findElement(searchBtn).click();
        return this;
    }

    public void clickAddToCartBtn(String productName) {
        By addToCartBtn = getAddToCartElement(productName);
        driver.findElement(addToCartBtn).click();
    }

    public CartPage clickViewCartBtn(String cartName) {
        By viewCartBtn = getViewToCartBtn(cartName);
        driver.findElement(viewCartBtn).click();
        return new CartPage(driver);
    }

    private By getViewToCartBtn(String cartName) {
        return By.cssSelector("a[title='"+cartName+"']");
    }

    private By getAddToCartElement(String productName) {
        return By.cssSelector("a[aria-label='Add “"+ productName +"” to your cart']");
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

}
