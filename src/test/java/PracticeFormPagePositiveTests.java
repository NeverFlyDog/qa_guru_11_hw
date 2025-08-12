import data.CalendarDate;
import data.PracticeFormTestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormPagePositiveTests extends BaseTest {
    private final PracticeFormPage page = new PracticeFormPage();
    private final PracticeFormPage.ResultModal resultModal = new PracticeFormPage.ResultModal();

    private PracticeFormTestData data;

    @BeforeEach
    public void initTestData() {
        data = new PracticeFormTestData();
    }

    @Test
    void fillAllFieldsTest() {
        page.open()
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .setEmail(data.getEmail())
                .selectGender(data.getGender())
                .setMobile(data.getMobile())
                .selectDateOfBirth(data.getDateOfBirth())
                .selectSubjects(data.getSubjects())
                .selectHobbies(data.getHobbies())
                .uploadPicture(data.getFilename())
                .setCurrentAddress(data.getCurrentAddress())
                .selectState(data.getState())
                .selectCity(data.getCity())
                .clickSubmit();

        resultModal.shouldBeVisible()
                .shouldHaveTitle()
                .shouldHaveHeaders()
                .shouldHaveStudentName(data.getFirstName(), data.getLastName())
                .shouldHaveStudentEmail(data.getEmail())
                .shouldHaveGender(data.getGender())
                .shouldHaveMobile(data.getMobile())
                .shouldHaveDateOfBirth(data.getDateOfBirth())
                .shouldHaveSubjects(data.getSubjects())
                .shouldHaveHobbies(data.getHobbies())
                .shouldHavePicture(data.getFilename())
                .shouldHaveAddress(data.getCurrentAddress())
                .shouldHaveStateAndCity(data.getState(), data.getCity())
                .clickClose();
    }

    @Test
    void fillRequiredFieldsTest() {
        page.open()
                .setFirstName(data.getFirstName())
                .setLastName(data.getLastName())
                .selectGender(data.getGender())
                .setMobile(data.getMobile())
                .clickSubmit();

        resultModal.shouldBeVisible()
                .shouldHaveTitle()
                .shouldHaveHeaders()
                .shouldHaveStudentName(data.getFirstName(), data.getLastName())
                .shouldHaveGender(data.getGender())
                .shouldHaveMobile(data.getMobile())
                .shouldHaveDateOfBirth(CalendarDate.now());

        resultModal.shouldHaveStudentEmail("")
                .shouldHaveSubjects("")
                .shouldHaveHobbies("")
                .shouldHavePicture("")
                .shouldHaveAddress("")
                .shouldHaveStateAndCity("", "")
                .clickClose();
    }
}
