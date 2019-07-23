package Mail;



import Login.LoginTests;
import Pages.Mail;
import Pages.Main;



import app.DBOperation;
import app.singeltonDriver;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.Test;

public class MailTests {
    private int pass = 2;
    private int login = 3;
    private  int description = 4;
    private Main main;
    private Mail mail;
    private static final Logger log = Logger.getLogger(LoginTests.class);
    {

        main = new Main();
        mail=new Mail();
    }
    @Test
    public void successful1SendMail()
    {
        DBOperation dbOperation = new DBOperation();
        main.openMailru();
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login),dbOperation.Get(1, pass));
        main.loginInMailru();
        Assert.assertTrue(main.loginIsLogined());
        log.info("step 2: successful login");
        mail.openNewMail();
        log.info("step 3: open new mail");
        mail.enterEmailAddres(dbOperation.Get(1, login));
        mail.enterTextEmail();
        mail.sendEmail();
        Assert.assertTrue(mail.emailIsSended());
        singeltonDriver.closeBrowser();
    }

    @Test
    public void successful2GetMail()
    {
        DBOperation dbOperation = new DBOperation();
        main.openMailru();
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login),dbOperation.Get(1, pass));
        main.loginInMailru();
        Assert.assertTrue(main.loginIsLogined());
        log.info("step 2: successful login");
        Assert.assertTrue(mail.mailIsGet());
        log.info("step 3: new mail is get ");
        singeltonDriver.closeBrowser();
    }

    @Test
    public void  successful3deleteGetedMail()
    {
        DBOperation dbOperation = new DBOperation();
        main.openMailru();
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login),dbOperation.Get(1, pass));
        main.loginInMailru();
        Assert.assertTrue(main.loginIsLogined());
        log.info("step 2: successful login");
        mail.selektedFirstMail();
        mail.deleteMail();
        mail.goToDeleteMails();
        Assert.assertTrue(mail.mailIsGet());
        singeltonDriver.closeBrowser();
    }

    @Test
    public void  saveMail()
    {
        DBOperation dbOperation = new DBOperation();
        main.openMailru();
        log.info("step 1: open mail.ru");
        main.enterLiginAndPass(dbOperation.Get(1, login),dbOperation.Get(1, pass));
        main.loginInMailru();
        Assert.assertTrue(main.loginIsLogined());
        log.info("step 2: successful login");
        mail.openNewMail();
        mail.enterEmailAddres(dbOperation.Get(1, login));
        mail.enterTextEmail();
        mail.saveEmail();
        mail.canselMail();
        mail.goToDraftsMails();

        Assert.assertTrue(mail.mailInDrafts());
        singeltonDriver.closeBrowser();
    }


}
