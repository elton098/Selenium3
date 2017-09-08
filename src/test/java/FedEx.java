import org.apache.xpath.operations.Equals;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by SteamRolan on 8/27/2017.
 */
public class FedEx extends SelDriver {

    @Test

    public void getQuote(){

        //Go to fedex.com
        driver.get("https://www.fedex.com/");

        //Select US location
        WebElement locSelect = driver.findElement(By.id("locFormSelect"));
        Select locationSelect = new Select(locSelect);
        locationSelect.selectByIndex(1);

        //Go to Get Rate & Transit Times. Fill in relevant information.
        WebElement getRate = driver.findElement(By.className("rates"));
        getRate.click();
        WebElement origZip = driver.findElement(By.id("origZipId"));
        origZip.sendKeys("11236");
        WebElement destZip = driver.findElement(By.id("destZipId"));
        destZip.sendKeys("90001");
        WebElement weight = driver.findElement(By.id("totalPackageWeight"));
        weight.sendKeys("10");

        //Schedule a pick up
        Select pickUp = new Select(driver.findElement(By.id("raCodeId")));
        pickUp.selectByIndex(2);

        //Get a quick quote
        WebElement quickQuote = driver.findElement(By.id("quickQuote"));
        quickQuote.click();

        //Verify that Rate & Transit Times is the third element


        WebElement shipFromTo=driver.findElement(By.cssSelector(".rating>div>form>table>tbody>tr>td>table>tbody" +
                ">tr>td>table>tbody>tr>td>table>tbody>tr>td>h2"));
        WebElement ratesAndTransit=driver.findElement(By.cssSelector(".rating>div>form>table>tbody>tr>td" +
                ">table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>h2"));
        System.out.println(shipFromTo.getText());
        System.out.println(ratesAndTransit.getText());
        assertEquals(" 3. Rates and Transit Times",ratesAndTransit.getText());


        /* This showed that the element size is 1. I was unable to find this web element to be within a list of other elements.

        List<WebElement> rateTransitText = driver.findElements(By.cssSelector(".rating>div>form>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>h2")); //this is wrong
        rateTransitText.size();
        System.out.println(rateTransitText.size());
        */


        //Verify that the services are specific

        //List<WebElement> services = driver.findElements(By.tagName("input"));
        //List<WebElement> services = driver.findElements(By.cssSelector("td>input"));
        // this one worked  List<WebElement> services = driver.findElements(By.name("service"));
        //List<WebElement> services = driver.findElements(By.tagName("radio"));



       /* this worked but Kyle said it's better to use the id
        assertEquals("FIRST_OVERNIGHT",services.get(0).getAttribute("value"));
        assertEquals("PRIORITY_OVERNIGHT",services.get(1).getAttribute("value"));
        assertEquals("STANDARD_OVERNIGHT",services.get(2).getAttribute("value"));
        assertEquals("FEDEX_2_DAY_AM",services.get(3).getAttribute("value"));
        assertEquals("FEDEX_2_DAY",services.get(4).getAttribute("value"));
        assertEquals("FEDEX_EXPRESS_SAVER",services.get(5).getAttribute("value"));


        System.out.println(services.get(0).getAttribute("id"));
        System.out.println(services.get(1).getAttribute("value"));
        System.out.println(services.get(2).getAttribute("value"));
        System.out.println(services.get(3).getAttribute("value"));
        System.out.println(services.get(4).getAttribute("value"));
        System.out.println(services.get(5).getAttribute("value"));

        */

        assertEquals("FedEx First Overnight®",driver.findElement(By.id("FIRST_OVERNIGHT_service0")).getText());
        assertEquals("FedEx Priority Overnight®",driver.findElement(By.id("PRIORITY_OVERNIGHT_service1")).getText());
        assertEquals("FedEx Standard Overnight®",driver.findElement(By.id("STANDARD_OVERNIGHT_service2")).getText());
        assertEquals("FedEx 2Day®",driver.findElement(By.id("FEDEX_2_DAY_service3")).getText());
        assertEquals("FedEx 2Day AM®",driver.findElement(By.id("FEDEX_2_DAY_AM_service4")).getText());
        assertEquals("FedEx Express Saver®",driver.findElement(By.id("FEDEX_EXPRESS_SAVER_service6")).getText());

        System.out.println(driver.findElement(By.id("FIRST_OVERNIGHT_service0")).getText());
        System.out.println(driver.findElement(By.id("PRIORITY_OVERNIGHT_service1")).getText());
        System.out.println(driver.findElement(By.id("STANDARD_OVERNIGHT_service2")).getText());
        System.out.println(driver.findElement(By.id("FEDEX_2_DAY_service3")).getText());
        System.out.println(driver.findElement(By.id("FEDEX_2_DAY_AM_service4")).getText());
        System.out.println(driver.findElement(By.id("FEDEX_EXPRESS_SAVER_service6")).getText());

        /*
        int specificServices=1;

        for(int i=0; i<services.size(); i++){




           if(services.get(0).getAttribute("value").equals(services.get(i).getAttribute("value")))
               System.out.println("Same service");
           else {
               System.out.println("Different service");
               specificServices++;
           }


          /*   for(int j=1; j<services.size(); j++){
                if(services.get(i).getAttribute("value").equals(services.get(j).getAttribute("value")))
                    System.out.println("same service");
                else
                    System.out.println("different service");
            }

          */


        }


        // System.out.println("There are "+specificServices+ " different services under Rates & Transit Times");




    @Test

    public void verifyTransit(){

        //Go to fedex.com/us/
        driver.get("https://www.fedex.com/us/");

        //Go to Get Rates & Transit Times. Fill in relevant information.
        WebElement getRate = driver.findElement(By.className("rates"));
        getRate.click();
        WebElement origZip = driver.findElement(By.id("origZipId"));
        origZip.sendKeys("11236");
        WebElement destZip = driver.findElement(By.id("destZipId"));
        destZip.sendKeys("90001");
        WebElement weight = driver.findElement(By.id("totalPackageWeight"));
        weight.sendKeys("10");

        //Get a transit time
        Select pickUp = new Select(driver.findElement(By.id("raCodeId")));
        pickUp.selectByIndex(2);
        WebElement transitTime = driver.findElement(By.id("ttTime"));
        transitTime.click();

        //Select the type of package
        Select packageType = new Select(driver.findElement(By.id("packageTypeId")));
        packageType.selectByIndex(4);
        WebElement continuePurple = driver.findElement(By.className("buttonpurple"));
        continuePurple.click();

        //Verify that the third column is Transit Times

        WebElement rateAndTransit= driver.findElement(By.cssSelector(".rating>div>form>table>tbody>tr>td>table>" +
                "tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>table>tbody>tr>td>h2"));
        
        assertEquals(" 3. Transit Times",rateAndTransit.getText());
        System.out.println(rateAndTransit.getText());

        //Verify that seven (it's actually six) services are available
        List<WebElement> services2 = driver.findElements(By.name("service"));
        for(int i=0;i>services2.size();i++) {
            assert(services2.get(i).isSelected());
        }

    }

    //Elton ignore the below Kyle changed some stuff down here (unless I undid it) and I don't want to use it.
    @Test

    public void getQuote2(){

        //Go to fedex.com
        driver.get("https://www.fedex.com/");

        //Select US location
        WebElement locSelect = driver.findElement(By.id("locFormSelect"));
        Select locationSelect = new Select(locSelect);
        locationSelect.selectByIndex(1);

        //Go to Get Rate & Transit Times. Fill in relevant information.
        WebElement getRate = driver.findElement(By.className("rates"));
        getRate.click();
        WebElement origZip = driver.findElement(By.id("origZipId"));
        origZip.sendKeys("11236");
        WebElement destZip = driver.findElement(By.id("destZipId"));
        destZip.sendKeys("90001");
        WebElement weight = driver.findElement(By.id("totalPackageWeight"));
        weight.sendKeys("10");

        //Schedule a pick up
        Select pickUp = new Select(driver.findElement(By.id("raCodeId")));
        pickUp.selectByIndex(2);

        //Get a quick quote
        WebElement quickQuote = driver.findElement(By.id("quickQuote"));
        quickQuote.click();

        //Verify that Rate & Transit Times is the third element

        List <WebElement> rateTransitText = driver.findElements(By.id("packageRating")); //this is wrong
        for(int x = 0; x< rateTransitText.size(); x++){
        System.out.println(rateTransitText.get(x).getText());}


        //Verify that the services are specific
        //List<WebElement> services = driver.findElements(By.tagName("input"));
        //List<WebElement> services = driver.findElements(By.cssSelector("td>input"));
        List<WebElement> services = driver.findElements(By.name("service"));
        //List<WebElement> services = driver.findElements(By.tagName("radio"));
        int specificServices=1;
        for(int i=0; i<services.size(); i++){
            if(services.get(0).getAttribute("value").equals(services.get(i).getAttribute("value")))
                System.out.println("Same service");
            else {
                System.out.println("Different service");
                specificServices++;
            }

          /*   for(int j=1; j<services.size(); j++){
                if(services.get(i).getAttribute("value").equals(services.get(j).getAttribute("value")))
                    System.out.println("same service");
                else
                    System.out.println("different service");
            }
          */
        }
        System.out.println("There are "+specificServices+ " different services under Rates & Transit Times");


    }






}
