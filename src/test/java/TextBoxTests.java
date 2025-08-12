import data.TextBoxTestData;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends BaseTest {
    private final TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillAllFieldsTest() {
        TextBoxTestData data = new TextBoxTestData();

        textBoxPage
                .open()
                .setUserName(data.getUserName())
                .setEmail(data.getEmail())
                .setCurrentAddress(data.getCurrentAddress())
                .setPermanentAddress(data.getPermanentAddress())
                .clickSubmit();

        textBoxPage
                .shouldHaveUserName(data.getUserName())
                .shouldHaveEmail(data.getEmail())
                .shouldHaveCurrentAddress(data.getCurrentAddress())
                .shouldHavePermanentAddress(data.getPermanentAddress());
    }
}
