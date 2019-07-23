

    import Login.LoginTests;
    import Mail.MailTests;
    import User.UserSettingsTests;
    import API.API_vk_test;
    import org.junit.runners.Suite;
import org.junit.runner.RunWith;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({UserSettingsTests.class,LoginTests.class, MailTests.class,API_vk_test.class })
    public class testSute  {

    }

