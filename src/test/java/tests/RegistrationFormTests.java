package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("Smoke")
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Тест")
                .setLastName("Тестов")
                .setGender("Other")
                .setNumber("89012345678")
                .submit()
                .checkSubmitResult("Student Name", "Тест Тестович")
                .checkSubmitResult("Gender", "Other")
                .checkSubmitResult("Mobile", "89012345678");
    }

    @Test
    @Tag("Regress")
    void registration() {
        registrationPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("ivan@mail.ru")
                .setGender("Other")
                .setNumber("8901234567")
                .setDateOfBirth("20", "January", "2001")
                .setSubject("Economics")
                .setHobbies("Reading").setHobbies("Sports")
                .setPicture("homework.jpg")
                .setAddress("Москва 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .checkSubmitResult("Student Name", "Ivan" + " " + "Ivanov")
                .checkSubmitResult("Student Email", "ivan@mail.ru")
                .checkSubmitResult("Gender", "Other")
                .checkSubmitResult("Mobile", "8901234567")
                .checkSubmitResult("Date of Birth", "20 January,2001")
                .checkSubmitResult("Subjects", "Economics")
                .checkSubmitResult("Hobbies", "Reading, Sports")
                .checkSubmitResult("Picture", "homework.jpg")
                .checkSubmitResult("Address", "Москва 1")
                .checkSubmitResult("State and City", "NCR Delhi");
    }

    @Test
    @Tag("Regress")
    void negativeTest() {
        registrationPage.openPage()
                .setGender("Other")
                .setNumber("1234567890")
                .submit()
                .checkBorderColor();
    }
}