package tests;

import org.junit.jupiter.api.Test;
import page.RegistrationPage;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .submit()
                .checkSubmitResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkSubmitResult("Gender", testData.gender)
                .checkSubmitResult("Mobile", testData.phone);
    }

    @Test
    void registration() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobbies(testData.hobby)
                .setPicture(testData.picturePath)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()
                .checkSubmitResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkSubmitResult("Student Email", testData.email)
                .checkSubmitResult("Gender", testData.gender)
                .checkSubmitResult("Mobile", testData.phone)
                .checkSubmitResult("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkSubmitResult("Subjects", testData.subject)
                .checkSubmitResult("Hobbies", testData.hobby)
                .checkSubmitResult("Picture", testData.pictureName)
                .checkSubmitResult("Address", testData.address)
                .checkSubmitResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void negativeTest() {
        registrationPage.openPage()
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .submit()
                .checkBorderColor();
    }
}
