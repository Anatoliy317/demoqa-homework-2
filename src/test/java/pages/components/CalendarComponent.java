package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__month").$(byText("20")).click();
    }
}