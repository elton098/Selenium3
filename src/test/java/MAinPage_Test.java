import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class MAinPage_Test extends SelDriver {

    //veirfy that the user can search for something on google
    @Test
    public void verifyGoogleSearch(){
        driver.get("http://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("Rolan cut class for 8 months and i'm definitely not pissed");
        driver.findElement(By.name("btnK")).click();
        assert(driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[1]/div/div/h3/a")).getText().contains("Rolan"));
        assert (driver.findElement(By.xpath(".//*[@id='rso']/div/div/div[1]/div/div/h3/a")).isDisplayed());
        assertEquals("rolan","ROLAN");
        assertTrue(true);
    }
}
