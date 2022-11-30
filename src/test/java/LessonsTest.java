import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LessonsTest {
    //TC_1_1 - Тест кейс:
    //1. Октрыть страницу https://openweathermap.org/
    //2. Набрать в строке поиска город Paris
    //3. Нажать пункт меню Search
    //4. Из выпадающего списка выбрать Paris, FR
    //5. Подтвердить, что заголво изменился "Paris", FR"




    @Test
    public void testH2TagText_WhereSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String CityName = "Paris";
        String expectedResult = "Paris, FR";

//Снизу с помощью команды get можем открыть драйвер
        driver.get(url);
        Thread.sleep(5000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']"));
        searchCityField.click();
        searchCityField.sendKeys(CityName);

        WebElement searchButton = driver.findElement(
                 By.xpath("//button[@type = 'submit']")
        );
        searchButton.click();
        Thread.sleep(1000);
        WebElement parisFRChoiceInDroppdownMenu = driver.findElement(
                By.xpath("//ul[@class=\"search-dropdown-menu\"]/li/span[text() = 'Paris, FR ']"));
        parisFRChoiceInDroppdownMenu.click();

        // Снизу в команде обычно sleep будет красной, но можно нажать на правую кнопку мышки и решить проблему.
        //Так же после этого появляется свеиху команда "throws IntterruptedEpection"
        Thread.sleep(5000);

        WebElement h2CityNameHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2"));

        String actualResult = h2CityNameHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);



        driver.quit();


    }
}
