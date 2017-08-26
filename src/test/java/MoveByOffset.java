import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by SteamRolan on 8/20/2017.
 */
public class MoveByOffset extends SelDriver {

    @Test
    public void testMoveByOffset(){
        driver.get("file://C:/8850OS_Code/Chapter 2/HTML/Selectable.html");
        WebElement three = driver.findElement(By.name("three"));
        System.out.println("X Coordinate : "+ three.getLocation().getX()+"Y Coordinate : "+ three.getLocation().getY());
        Actions builder = new Actions(driver);
        builder.moveByOffset(three.getLocation().getX()+120, three.getLocation().getY()+1);
        builder.perform();
        WebElement three2 = driver.findElement(By.name("three"));

    }

    @Test // verify that the user can go to princeton review using google.com
    public void verifyGoToPrincetonReview() {

        driver.get("https://www.google.com/");   //go to Google

        //search for princeton review
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Princeton Review");
        searchBox.submit();
        WebElement pRlink = driver.findElement(By.id("vs0p1c0"));
        pRlink.click();
        WebElement pRLogo = driver.findElement(By.className("navbar-brand"));
        assert (pRLogo.isDisplayed());

    }



    @Test
    public void verifyValue() {

        driver.get("https://www.princetonreview.com/");   //go to Google
        //search for princeton review
        WebElement satButton = driver.findElement(By.linkText("ACT"));
        satButton.click();
        Wait.sleep(2500);
        WebElement selfPacedValue = driver.findElement(By.xpath(".//*[@id='ultimate-bundle-ratecard-additional']/div[1]/div/div[1]/p[1]/a"));
        List<WebElement> araY = driver.findElements(By.cssSelector(".price-value"));
     //   assert(der.equals("$299"));
        assertEquals("$299",araY.get(1).getText());
    }


    }


