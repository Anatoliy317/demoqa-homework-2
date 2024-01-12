package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

    public class RegistrationTests extends TestBase {

        @Test
        void successfulRegistrationTest() {
            Configuration.pageLoadStrategy = "eager";
            open("/automation-practice-form");
            $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        //First Name
        $("#firstName").setValue("Имя");

        //Last Name
        $("#lastName").setValue("Фамилия");

        //Email
        $("#userEmail").setValue("firstlastname@gmail.com");

        //Gender
        $("[for=gender-radio-1]").click();

        //Mobile
        $("#userNumber").setValue("1234567891");

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("2004");
        $(".react-datepicker__day--004").click();

        //Subjects
        $("#subjectsInput").setValue("Economics").pressEnter();

        //Hobbies
        $("[for=hobbies-checkbox-1]").click();

    //Picture
        String homeworkName = "homework.jpg";
        $("#uploadPicture").uploadFromClasspath(homeworkName);

    //Current Address
    $("#currentAddress").setValue("Москва");

    //State and City
    $("#react-select-3-input").setValue("NCR").pressEnter();
    $("#react-select-4-input]").setValue("Delhi").pressEnter();
    $("#submit").click();

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
