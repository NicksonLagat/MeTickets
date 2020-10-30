package WebPages;

import PageObjects.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends PageObject {

    private final String EXPECTED_MESSAGE = "Madaraka Express - Online Booking";


    @FindBy(name = "schedule_type")
    private WebElement schedule_type;

    @FindBy(name = "terminal_id")
    private WebElement terminal_id;

    @FindBy(name = "destination_id")
    private WebElement destination_id;

    @FindBy(name = "travel-date")
    private WebElement travel_date;

    @FindBy(id = "depature_time")
    private WebElement depature_time;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/form/div/div[7]/button")
    private WebElement submit;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/form/div/div[1]/h2")
    private WebElement verify;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody")
    private WebElement datepickerTable;

    @FindBy(tagName = "td")
    private WebElement tds;



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void loadPage(){

       String ACTUAL_MESSAGE = this.verify.getText();
        if(ACTUAL_MESSAGE.equals(EXPECTED_MESSAGE)){

            System.out.println("Title Verified");
        }

        //driver.navigate().refresh();

    }

    public void selectTrainType(){

        this.schedule_type.isDisplayed();

        Select st = new Select(this.schedule_type);
        st.selectByIndex(2);

        System.out.println("Check check");

    }


    public void selectFrom(){

        this.terminal_id.isDisplayed();
        Select tid = new Select(this.terminal_id);
        tid.selectByIndex(1);
    }

    public void selectTo(){

        this.destination_id.isDisplayed();

        Select desid = new Select(this.destination_id);
        desid.selectByValue("3");


    }

    public void travelDate() {

        this.travel_date.sendKeys("10/31/2020");
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


            //
            //Date d = new Date(1);
            //SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
            //String date = sdf.format(d);
            //String splitter[]=date.split("-");
            //String month_year = splitter[0];
            //String day = splitter[1];

            //System.out.println(month_year);
            //System.out.println(day);


        }
    public void departTime(){

        this.depature_time.isDisplayed();

        Select dpt = new Select(this.depature_time);
        dpt.selectByValue("3.00");
    }

    public void bookTrain(){

        this.submit.isDisplayed();

        this.submit.click();
    }

    }


