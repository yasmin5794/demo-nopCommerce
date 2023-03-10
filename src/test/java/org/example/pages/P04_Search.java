package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class P04_Search {
    SoftAssert softAssert = new SoftAssert();
    public void currentUrl() {
         Hooks.driver.navigate().to("https://demo.nopcommerce.com/search?q=");

        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/search?q=");
        softAssert.assertAll();
    }

    public WebElement searchBar() {

     return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public void searchButton()
    {
       Hooks.driver.findElement(By.xpath("//*[@class='button-1 search-box-button']")).click();
    }

    public void NumOfResults()
    {
      List<WebElement> numOfResults = Hooks.driver.findElements(By.className("product-title"));

      int size = numOfResults.size();
        System.out.println(size);

    }
    public void searchSuccessText()
    {
        String searchBarText = Hooks.driver.findElement(By.id("small-searchterms")).getText();
      List<WebElement> result_text = Hooks.driver.findElements(By.className("product-title"));
       int numOfElements = result_text.size();

               for (int j=0; j < numOfElements; j++)
               {
                 String resultText = result_text.get(j).getText().toLowerCase();

                   softAssert.assertEquals(resultText,searchBarText);
                   softAssert.assertAll();
               }
    }
 public WebElement clickOnProduct()
    {
      return Hooks.driver.findElement(By.className("picture"));
    }

    public void getSku()
    {

       String skuResult = Hooks.driver.findElement(By.className("value")).getText();
       // System.out.println(skuResult);
        String skuSearch = Hooks.driver.findElement(By.id("q")).getText();
        //  System.out.println(skuSearch);

        Assert.assertEquals(skuSearch,skuResult);
    }





}
