package Test;


import Utilites.Utilis;
import WebPages.BookingInfo;
import WebPages.HomePage;
import WebPages.SearchResults;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Tests {

    private static final WebDriver driver = new ChromeDriver();


    @BeforeSuite
    public static void main(String[]args){

        System.setProperty("webdriver.chrome.driver","Utils.CHROME_DRIVER_LOCATION") ;

    }

    @Test(testName = "SGR BOOKING FUNCTIONALITY")
    public static void booking() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://metickets.krc.co.ke/");


        HomePage hp = new HomePage(driver);
        hp.loadPage();
        hp.selectTrainType();
        Thread.sleep(3000);
        hp.selectFrom();
        Thread.sleep(3000);
        hp.selectTo();
        Thread.sleep(4000);
        hp.travelDate();
        Thread.sleep(1000);
        hp.departTime();
        Thread.sleep(1000);
        hp.bookTrain();

        SearchResults sr = new SearchResults(driver);
        sr.searchResults();
        Thread.sleep(2000);
        sr.enterbookingDetails();
        Thread.sleep(2000);


        BookingInfo bi = new BookingInfo(driver);
        bi.confirmBooking();
        Thread.sleep(0);



    }

    @AfterSuite
    public  static void tearDown(){

        Date d = new Date();
        System.out.println(d.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scrFile, new File("D:\\Screenshots\\"+sdf.format(d)+".png"));
        } catch (IOException e) {

            e.printStackTrace();

        }


        driver.manage().deleteAllCookies();
        driver.close();
    }


}
