package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
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
    void registration() {
        registrationPage.openPage()
                .setFirstName("Тест")
                .setLastName("Тестов")
                .setEmail("test@aaa.ru")
                .setGender("Other")
                .setNumber("8901234567")
                .setDateOfBirth("01", "January", "2001")
                .setSubject("Economics")
                .setHobbies("Reading").setHobbies("Sports")
                .setPicture("homework.jpg")
                .setAddress("Москва 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .checkSubmitResult("Student Name", "Тест Тестов")
                .checkSubmitResult("Student Email", "test@aaa.ru")
                .checkSubmitResult("Gender", "Other")
                .checkSubmitResult("Mobile", "8901234567")
                .checkSubmitResult("Date of Birth", "20 January,2001")
                .checkSubmitResult("Subjects", "Economics")
                .checkSubmitResult("Hobbies", "Reading, Sports")
                .checkSubmitResult("Picture", "homework.jpg")
                .checkSubmitResult("Address", "Москва 1")
                .checkSubmitResult("State and City", "NCR Delhi");
    }
}