package quru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SimpleJUnitTest {

@BeforeEach
void Opendemoqa(){
    Configuration.pageLoadStrategy = "eager";

    Selenide.open("https://demoqa.com/automation-practice-form");
}
    @Test
    void firstTest(){
        Configuration.holdBrowserOpen = true;

        //First Name
    $("[id=firstName]").setValue("Имя");

    //Last Name
    $("[id=lastName]").setValue("Фамилия");

    //Email
    $("[id=userEmail]").setValue("firstlastname@gmail.com");

    //Gender
    $("[for=gender-radio-1]").click();

    //Mobile
    $("[id=userNumber]").setValue("1234567891");

    //Date of Birth
    $("[id=dateOfBirthInput]").click();
    $(".react-datepicker__month-select").click();
    $(".react-datepicker__month-select").selectOption("April");
    $(".react-datepicker__year-select").click();
    $(".react-datepicker__year-select").selectOption("2004");
    $(".react-datepicker__day--004").click();

    //Subjects
    $("[id=subjectsInput]").setValue("Economics").pressEnter();

    //Hobbies
    $("[for=hobbies-checkbox-1]").click();

    //Picture
    $("#uploadPicture").uploadFile(new File("/Users/anatoliy.aleshin/Downloads/Homework.png"));

    //Current Address
    $("[id=currentAddress]").setValue("Москва");

    //State and City
    $("[id=react-select-3-input]").setValue("NCR").pressEnter();
    $("[id=react-select-4-input]").setValue("Delhi").pressEnter().pressEnter();

    //Проверка полей ввода
    $(".table").shouldHave(text("Имя"));
    $(".table").shouldHave(text("Фамилия"));
    $(".table").shouldHave(text("firstlastname@gmail.com"));
    $(".table").shouldHave(text("1234567891"));
    $(".table").shouldHave(text("04 April,2004"));
    $(".table").shouldHave(text("Economics"));
    $(".table").shouldHave(text("Sports"));
    $(".table").shouldHave(text("Homework.png"));
    $(".table").shouldHave(text("Москва"));
    $(".table").shouldHave(text("NCR Delhi"));
}

}
