package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;
import com.github.javafaker.Faker;

import java.util.Locale;

import static utils.RandomUtils.*;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker(new Locale("ru"));
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress("en");
    String numberPhone = faker.phoneNumber().subscriberNumber(10);
    String gender = getRandomGender();
    String streetAddress = faker.address().streetAddress();
    String day = String.valueOf(getRandomInt(1, 28));
    String month = getRandomMonth();
    String year = String.valueOf(getRandomInt(1990, 2024));
    String birthDay = String.format("%s %s,%s", day, month, year);
    String subject = getRandomSubject();
    String hobbies = getRandomHobbies();
    String picture = "homework.jpg";

    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(numberPhone)
                .submit()
                .checkSubmitResult("Student Name", firstName + " " + lastName)
                .checkSubmitResult("Gender", gender)
                .checkSubmitResult("Mobile", numberPhone);
    }

    @Test
    void registration() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(numberPhone)
                .setDateOfBirth(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAddress(streetAddress)
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .checkSubmitResult("Student Name", firstName + " " + lastName)
                .checkSubmitResult("Student Email", userEmail)
                .checkSubmitResult("Gender", gender)
                .checkSubmitResult("Mobile", numberPhone)
                .checkSubmitResult("Date of Birth", birthDay)
                .checkSubmitResult("Subjects", subject)
                .checkSubmitResult("Hobbies", hobbies)
                .checkSubmitResult("Picture", picture)
                .checkSubmitResult("Address", streetAddress)
                .checkSubmitResult("State and City", "NCR Delhi");
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setGender(gender)
                .setNumber(numberPhone)
                .submit()
                .checkBorderColor();
    }
}
