import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by SteamRolan on 8/25/2017.
 */
public class Equinox extends SelDriver {

    @Test
    public void findClosestGym() {

        driver.get("https://www.equinox.com/");
        WebElement joinButton = driver.findElement(By.cssSelector(".box.black.button.inline"));
        joinButton.click();
        Wait.sleep(2500);
        WebElement searchBox = driver.findElement(By.id("searchedText"));
        searchBox.sendKeys("11236");
        searchBox.submit();

    }

    @Test
    //method that verifies that twelve gym locations are showingk
    public void verifyGymRegions() {

        driver.get("https://www.equinox.com/");


        //Find and click the club locations button

        // WebElement clubButton = driver.findElement(By.cssSelector(".menu-classes"));
        WebElement clubButton = driver.findElement(By.linkText("CLUBS"));
        clubButton.click();
        Wait.sleep(5000);

        //Find the images and verify that they are displayed

        //List<WebElement> clubImages = driver.findElements(By.tagName("img"));
        List<WebElement> clubImages = driver.findElements(By.cssSelector(".region-list>ul>li>a"));
        System.out.println("There are " + clubImages.size() + " images.");

        //WebElement clubImage = driver.findElement(By.tagName("img"));
        //WebElement clubImage = driver.findElement(By.cssSelector(".region-list>ul>li>a"));


        int countForAssert=0;
        for (int x = 0; x < clubImages.size(); x++) {
            if (clubImages.get(x).isDisplayed()) {
                //assert (clubImages.get(x).isDisplayed());
                System.out.println("is displayed");
                countForAssert++;
            }
        }
        assert (countForAssert==12);

    }
}