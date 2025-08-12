import data.PracticeFormTestData;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormPageNegativeTests extends BaseTest {
    private static final String invalidMobile = "123"; // should have 10 digits
    private static final String invalidEmail = "123@123"; // should have domain

    private final PracticeFormPage page = new PracticeFormPage();
    private final PracticeFormPage.ResultModal resultModal = new PracticeFormPage.ResultModal();

    @Test
    void emptyRequiredFieldsShowsErrorTest() {
        PracticeFormTestData data = new PracticeFormTestData();

        page.open()
                .setEmail(data.getEmail())
                .setCurrentAddress(data.getCurrentAddress())
                .clickSubmit();

        page.shouldHaveInvalidFirstNameField()
                .shouldHaveInvalidLastNameField()
                .shouldHaveInvalidGenderRadioGroup()
                .shouldHaveInvalidMobileField();
        resultModal.shouldNotBeVisible();
    }

    @Test
    void invalidMobileFormatShowsErrorTest() {
        page.open()
                .setMobile(invalidMobile)
                .clickSubmit();

        page.shouldHaveInvalidMobileField();
        resultModal.shouldNotBeVisible();
    }

    @Test
    void invalidEmailFormatShowsErrorTest() {
        page.open()
                .setEmail(invalidEmail)
                .clickSubmit();

        page.shouldHaveInvalidEmailField();
        resultModal.shouldNotBeVisible();
    }
}
