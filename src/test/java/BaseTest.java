import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    // @AfterEach
    // void afterEachTest() {
    //     Selenide.closeWebDriver();
    // }
}
