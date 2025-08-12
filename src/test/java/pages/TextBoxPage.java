package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private static final String RESULT_NAME_LABEL = "Name";
    private static final String RESULT_EMAIL_LABEL = "Email";
    private static final String RESULT_CURRENT_ADDRESS_LABEL = "Current Address";
    private static final String RESULT_PERMANENT_ADDRESS_LABEL = "Permananet Address";


    private final SelenideElement userNameField = $("#userName");
    private final SelenideElement emailField = $("#userEmail");
    private final SelenideElement currentAddressField = $("#currentAddress");
    private final SelenideElement permanentAddressField = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement outputBlock = $("#output");

    public TextBoxPage open() {
        Selenide.open("/text-box");

        $("h1").shouldHave(text("Text Box"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public TextBoxPage setUserName(String userName) {
        userNameField.setValue(userName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailField.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressField.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressField.setValue(permanentAddress);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public TextBoxPage shouldHaveUserName(String userName) {
        shouldHaveResult(RESULT_NAME_LABEL, userName);
        return this;
    }

    public TextBoxPage shouldHaveEmail(String email) {
        shouldHaveResult(RESULT_EMAIL_LABEL, email);
        return this;
    }

    public TextBoxPage shouldHaveCurrentAddress(String currentAddress) {
        shouldHaveResult(RESULT_CURRENT_ADDRESS_LABEL, currentAddress);
        return this;
    }

    public TextBoxPage shouldHavePermanentAddress(String permanentAddress) {
        shouldHaveResult(RESULT_PERMANENT_ADDRESS_LABEL, permanentAddress);
        return this;
    }

    private void shouldHaveResult(String key, String value) {
        outputBlock.$$("p")
                .findBy(text(key))
                .shouldHave(text(value));
    }
}
