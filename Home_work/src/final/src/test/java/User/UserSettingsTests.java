package User;





import Login.LoginTests;
import Pages.Mail;
import Pages.Main;
import Pages.UserSetting;



import app.DBOperation;
import app.singeltonDriver;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.Test;


public class UserSettingsTests {
    private int pass = 2;
    private int login = 3;
    private  int description = 4;
    private Main main;
    private Mail mail;
    private UserSetting userSetting;
    private static final Logger log = Logger.getLogger(LoginTests.class);
    {

        main = new Main();
        mail=new Mail();
        userSetting=new UserSetting();
    }


    @Test
    public void settingsUserEdit()
    {   String  firstName = "s12";
        String  lastName = "k12";
        DBOperation dbOperation = new DBOperation();
        main.openMailru();
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login),dbOperation.Get(1, pass));
        main.loginInMailru();
        Assert.assertTrue(main.loginIsLogined());
        log.info("step 2: successful login");
        userSetting.goToSettingUser();
        log.info("step 3: open user settings");
        userSetting.editFirstNameFild(firstName);
        log.info("step 4: enter new user first name");
        userSetting.editLastNameFild(lastName);
        log.info("step 5: enter new user last name");
        userSetting.editSave();
        log.info("step 6: save new user name");
        userSetting.openUserMenu();
        Assert.assertEquals(userSetting.cheackEditName(),firstName + " "+ lastName);
        log.info("step 7: check new user name");
        singeltonDriver.closeBrowser();
    }





}
